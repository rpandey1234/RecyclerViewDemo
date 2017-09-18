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
 * The adapter is responsible for converting an object at a position into a list row item.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
// Note that we specify the custom ViewHolder which gives us access to our views

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

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder extends RecyclerView.ViewHolder {

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private TextView tvName;
        private Button btnOnline;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            btnOnline = (Button) itemView.findViewById(R.id.btnOnline);
        }

        // Involves populating data into the item through holder
        public void bind(final Contact contact) {
            tvName.setText(contact.getName());
            btnOnline.setEnabled(contact.isOnline());
            String btnText = mContext.getString(contact.isOnline()
                    ? R.string.message : R.string.offline);
            btnOnline.setText(btnText);
            btnOnline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(mContext, contact.getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, ContactDetailActivity.class);
                    intent.putExtra(ContactDetailActivity.NAME_EXTRA, contact.getName());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
