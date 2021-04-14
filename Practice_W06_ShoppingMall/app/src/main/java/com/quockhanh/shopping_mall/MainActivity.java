package com.quockhanh.shopping_mall;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   Spinner spinnerProvinces;
   ArrayAdapter<CharSequence> spinnerProvincesAdapter;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      spinnerProvinces = findViewById(R.id.spinner_provinces);
      spinnerProvincesAdapter = ArrayAdapter.createFromResource(this,
              R.array.list_provinces, android.R.layout.simple_spinner_item);
      spinnerProvincesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerProvinces.setAdapter(spinnerProvincesAdapter);
   }
}