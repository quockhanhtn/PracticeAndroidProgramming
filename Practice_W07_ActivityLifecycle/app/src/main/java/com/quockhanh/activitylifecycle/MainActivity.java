package com.quockhanh.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

   @SuppressLint("LongLogTag")
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Log.i("[18110304 - Activity Lifecycle]", "onCreate invoked");
   }

   @SuppressLint("LongLogTag")
   @Override
   protected void onStart() {
      super.onStart();
      Log.i("[18110304 - Activity Lifecycle]", "onStart invoked");
   }

   @SuppressLint("LongLogTag")
   @Override
   protected void onResume() {
      super.onResume();
      Log.i("[18110304 - Activity Lifecycle]", "onResume invoked");
   }

   @SuppressLint("LongLogTag")
   @Override
   protected void onPause() {
      super.onPause();
      Log.i("[18110304 - Activity Lifecycle]", "onPause invoked");
   }

   @SuppressLint("LongLogTag")
   @Override
   protected void onStop() {
      super.onStop();
      Log.i("[18110304 - Activity Lifecycle]", "onStop invoked");
   }

   @SuppressLint("LongLogTag")
   @Override
   protected void onRestart() {
      super.onRestart();
      Log.i("[18110304 - Activity Lifecycle]", "onRestart invoked");
   }

   @SuppressLint("LongLogTag")
   @Override
   protected void onDestroy() {
      super.onDestroy();
      Log.i("[18110304 - Activity Lifecycle]", "onDestroy invoked");
   }
}