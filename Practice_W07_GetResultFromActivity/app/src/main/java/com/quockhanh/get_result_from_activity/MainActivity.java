package com.quockhanh.get_result_from_activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

   static final int EDIT_INFO_REQUEST_CODE = 9;

   TextView mainTextView = null;
   Button btnEdit = null;

   String userFirstName = "";
   String userLastName = "";
   String userGender = "";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      mainTextView = findViewById(R.id.main_text_view);
      btnEdit = findViewById(R.id.btn_edit);
      btnEdit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, InputInfoActivity.class);
            intent.putExtra(Const.KEY_FIRST_NAME, userFirstName);
            intent.putExtra(Const.KEY_LAST_NAME, userLastName);
            intent.putExtra(Const.KEY_GENDER, userGender);
            startActivityForResult(intent, EDIT_INFO_REQUEST_CODE);
         }
      });

      updateMainTextView();
   }

   @Override
   protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      switch (requestCode) {
         case EDIT_INFO_REQUEST_CODE:
            if (resultCode == RESULT_OK) {
               if (data == null) {
                  return;
               }
               Bundle bundleResult = data.getExtras();

               if (bundleResult.containsKey(Const.KEY_FIRST_NAME)) {
                  userFirstName = bundleResult.getString(Const.KEY_FIRST_NAME);
               }
               if (bundleResult.containsKey(Const.KEY_LAST_NAME)) {
                  userLastName = bundleResult.getString(Const.KEY_LAST_NAME);
               }
               if (bundleResult.containsKey(Const.KEY_GENDER)) {
                  userGender = bundleResult.getString(Const.KEY_GENDER);
               }
               updateMainTextView();
               Snackbar.make(findViewById(R.id.main_text_view), "Update info successfully", Snackbar.LENGTH_SHORT).show();
            } else {
               Snackbar.make(findViewById(R.id.main_text_view), "No change", Snackbar.LENGTH_SHORT).show();
            }
            break;
         default:
            super.onActivityResult(requestCode, resultCode, data);
      }
   }

   @SuppressLint("SetTextI18n")
   void updateMainTextView() {
      String content = "";

      if (!TextUtils.isEmpty(userFirstName)) {
         content += "First name: <b>" + userFirstName + "</b><br/>";
      }

      if (!TextUtils.isEmpty(userLastName)) {
         content += "Last name: <b>" + userLastName + "</b><br/>";
      }

      if (!TextUtils.isEmpty(userGender)) {
         content += "Gender: <b>" + userGender + "</b><br/>";
      }

      if (content.equals("")) {
         content = "<p style=\"color:#ff0000;\">Can't find your information in app</p";
         btnEdit.setText("Add your info");
      } else {
         content = "<p>" + content + "</p";
         btnEdit.setText("Edit your info");
      }

      mainTextView.setText(Html.fromHtml(content));
   }
}