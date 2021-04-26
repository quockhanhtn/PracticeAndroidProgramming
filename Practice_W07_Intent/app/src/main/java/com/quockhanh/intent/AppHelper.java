package com.quockhanh.intent;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;

public class AppHelper {
   public static void openAppSettings(final Activity context) {
      if (context == null) {
         return;
      }
      final Intent i = new Intent();
      i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
      i.addCategory(Intent.CATEGORY_DEFAULT);
      i.setData(Uri.parse("package:" + context.getPackageName()));
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
      i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
      context.startActivity(i);
   }

   public static String getPathFromURI(ContentResolver contentResolver, Uri contentUri) {
      String res = null;
      String[] projection = {MediaStore.Images.Media.DATA};
      Cursor cursor = contentResolver.query(contentUri, projection, null, null, null);
      if (cursor.moveToFirst()) {
         int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
         res = cursor.getString(column_index);
      }
      cursor.close();
      return res;
   }

   public static void showSettingsAlert(Context context, Activity activity) {
      AlertDialog alertDialog = new AlertDialog.Builder(context).create();
      alertDialog.setTitle("Alert");
      alertDialog.setMessage("App needs to access the Camera.");
      alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DON'T ALLOW",
              new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    //finish();
                 }
              });
      alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
              new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    AppHelper.openAppSettings(activity);
                 }
              });
      alertDialog.show();
   }
}
