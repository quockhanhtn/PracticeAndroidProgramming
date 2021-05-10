package com.quockhanh.sqlite;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      DatabaseHandler db = new DatabaseHandler(this);

      // Inserting Contacts
      Log.d("Insert: ", "Inserting ..");
      db.addContact(new Contact("Ravi", "9100000000"));
      db.addContact(new Contact("Srinivas", "9199999999"));
      db.addContact(new Contact("Tommy", "9522222222"));
      db.addContact(new Contact("Karthik", "9533333333"));

      // Reading all contacts
      Log.d("Reading: ", "Reading all contacts..");
      List<Contact> contacts = db.getAllContacts();

      for (Contact cn : contacts) {
         String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                 cn.getPhoneNumber();
         // Writing Contacts to log
         Log.d("Name: ", log);
      }
   }
}