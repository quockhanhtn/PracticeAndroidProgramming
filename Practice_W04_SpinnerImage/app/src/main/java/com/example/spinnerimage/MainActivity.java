package com.example.spinnerimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   final List<String> LIST_COUNTRIES = Arrays.asList(
           "Vietnam",
           "Thailand",
           "Brunei",
           "Myanmar",
           "Cambodia",
           "Laos",
           "Singapore",
           "Indonesia",
           "Malaysia",
           "Philippines",
           "East Timor"
   );
   final List<String> LIST_PHONE_CODES = Arrays.asList(
           "+84",
           "+66",
           "+673",
           "+95",
           "+855",
           "+856",
           "+65",
           "+62",
           "+60",
           "+63",
           "+670"
   );
   final List<Integer> LIST_COUNTRY_FLAGS = Arrays.asList(
           R.drawable.flag_vn,
           R.drawable.flag_th,
           R.drawable.flag_bn,
           R.drawable.flag_mm,
           R.drawable.flag_kh,
           R.drawable.flag_la,
           R.drawable.flag_sg,
           R.drawable.flag_id,
           R.drawable.flag_my,
           R.drawable.flag_ph,
           R.drawable.flag_tl
   );

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Spinner spin = (Spinner) findViewById(R.id.spinner);
      spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "You Select Position: " + position + " " + LIST_COUNTRIES.get(position), Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
      });

      SpinnerAdapter customAdapter = new SpinnerAdapter(getApplicationContext(), LIST_COUNTRY_FLAGS, LIST_COUNTRIES, LIST_PHONE_CODES);
      spin.setAdapter(customAdapter);
   }
}