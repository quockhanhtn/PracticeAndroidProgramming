package com.quockhanh.intentfilters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      findViewById(R.id.btn_send_mail).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intentSendMail = new Intent(Intent.ACTION_SEND);
            intentSendMail.setType("message/rfc822");
            intentSendMail.putExtra(Intent.EXTRA_EMAIL, new String[]{"18110304@student.hcmute.edu.vn"});
            intentSendMail.putExtra(Intent.EXTRA_SUBJECT, "Assignment Intent Filters");
            intentSendMail.putExtra(Intent.EXTRA_TEXT, "This is submit from Lâm Quốc Khánh - 18110304");
            startActivity(Intent.createChooser(intentSendMail,"Choose Mail App"));
         }
      });
   }
}