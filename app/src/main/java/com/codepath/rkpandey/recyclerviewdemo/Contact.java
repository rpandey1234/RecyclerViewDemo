package com.codepath.rkpandey.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * A plain old java object (POJO) which holds the data for a contact (person)
 */
public class Contact {

    private String mName;
    private boolean mIsOnline;

    public Contact(String name, boolean isOnline) {
        mName = name;
        mIsOnline = isOnline;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mIsOnline;
    }

    public static List<Contact> createContacts(int numContacts) {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 1; i <= numContacts; i++) {
            // The first half of the contacts created will be online
            contacts.add(new Contact("Person " + i, i <= numContacts / 2));
        }
        return contacts;
    }
}
