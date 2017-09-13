package com.codepath.rkpandey.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        String name = getIntent().getStringExtra("name");
        tvName.setText(name);
    }
}
