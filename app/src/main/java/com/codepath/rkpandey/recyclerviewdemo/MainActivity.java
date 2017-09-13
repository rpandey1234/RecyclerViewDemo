package com.codepath.rkpandey.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        List<Contact> contacts = Contact.createContacts(20);
        ContactsAdapter contactsAdapter = new ContactsAdapter(this, contacts);
        rvContacts.setAdapter(contactsAdapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
