package com.quockhanh.get_result_from_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class InputInfoActivity extends AppCompatActivity {
   EditText editTextFirstName = null;
   EditText editTextLastName = null;

   RadioGroup radioGroupGender = null;
   RadioButton radioMale = null;
   RadioButton radioFemale = null;
   RadioButton radioOther = null;

   Button btnSave = null;
   Button btnCancel = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_input_info);

      findViews();
      setViewListener();
      restoreData();
   }

   private void findViews() {
      editTextFirstName = findViewById(R.id.edit_text_first_name);
      editTextLastName = findViewById(R.id.edit_text_last_name);
      radioGroupGender = findViewById(R.id.radio_grp_gender);
      radioMale = findViewById(R.id.radio_gender_male);
      radioFemale = findViewById(R.id.radio_gender_female);
      radioOther = findViewById(R.id.radio_gender_other);
      btnSave = findViewById(R.id.btn_save);
      btnCancel = findViewById(R.id.btn_cancel);
   }

   private void setViewListener() {
      btnSave.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String genderReturn = "";
            switch (radioGroupGender.getCheckedRadioButtonId()) {
               case R.id.radio_gender_male:
                  genderReturn = "Male";
                  break;
               case R.id.radio_gender_female:
                  genderReturn = "Female";
                  break;
               default:
                  genderReturn = "Other";
            }

            Bundle extras = new Bundle();
            extras.putString(Const.KEY_FIRST_NAME, String.valueOf(editTextFirstName.getText()));
            extras.putString(Const.KEY_LAST_NAME, String.valueOf(editTextLastName.getText()));
            extras.putString(Const.KEY_GENDER, genderReturn);

            Intent intentReturn = new Intent();
            intentReturn.putExtras(extras);
            setResult(RESULT_OK, intentReturn);
            finish();
         }
      });
      btnCancel.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            setResult(RESULT_CANCELED);
            finish();
         }
      });
   }

   private void restoreData() {
      Intent intent = getIntent();
      if (intent == null) {
         return;
      }

      editTextFirstName.setText(intent.getStringExtra(Const.KEY_FIRST_NAME));
      editTextLastName.setText(intent.getStringExtra(Const.KEY_LAST_NAME));
      switch (intent.getStringExtra(Const.KEY_GENDER)) {
         case "Male":
            radioMale.setChecked(true);
            break;
         case "Female":
            radioFemale.setChecked(true);
            break;
         default:
            radioOther.setChecked(true);
      }
   }
}