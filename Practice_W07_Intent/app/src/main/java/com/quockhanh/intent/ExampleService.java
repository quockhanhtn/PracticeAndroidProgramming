package com.quockhanh.intent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ExampleService extends Service {
   @Nullable
   @Override
   public IBinder onBind(Intent intent) {
      return null;
   }

   @Override
   public void onCreate() {
      super.onCreate();
      Log.i("[18110304 - Intent]", "Service was created");
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
      Log.i("[18110304 - Intent]", "Service was destroyed");
   }
}
