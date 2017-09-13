package com.codepath.rkpandey.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rkpandey on 9/13/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private Context mContext;
    private List<Contact> mContacts;

    public ContactsAdapter(Context context, List<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_contact, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private Button btnOnline;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            btnOnline = (Button) itemView.findViewById(R.id.btnOnline);
        }

        public void bind(final Contact contact) {
            tvName.setText(contact.getName());
            btnOnline.setEnabled(contact.isOnline());
            // TODO: strings should come from a resource file
            btnOnline.setText(contact.isOnline() ? "Message" : "Offline");
            btnOnline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(mContext, contact.getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, ContactDetailActivity.class);
                    intent.putExtra("name", contact.getName());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
