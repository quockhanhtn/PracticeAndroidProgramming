package com.example.imageview;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private static final int SELECT_PICTURE = 100;
   private static final String TAG = "SelectImageActivity";
   final List<String> LIST_SCALE_TYPE = Arrays.asList(
           "Matrix",
           "Fit XY",
           "Fit start",
           "Fit center",
           "Fit end",
           "Center",
           "Center crop",
           "Center inside"
   );
   final List<ImageView.ScaleType> LIST_SCALE_TYPE_VALUE = Arrays.asList(
           ImageView.ScaleType.MATRIX,
           ImageView.ScaleType.FIT_XY,
           ImageView.ScaleType.FIT_START,
           ImageView.ScaleType.FIT_CENTER,
           ImageView.ScaleType.FIT_END,
           ImageView.ScaleType.CENTER,
           ImageView.ScaleType.CENTER_CROP,
           ImageView.ScaleType.CENTER_INSIDE
   );
   final List<String> LIST_BACKGROUND_COLOR_STR = Arrays.asList(
           "AliceBlue", "AntiqueWhite", "Aqua", "Aquamarine", "Azure", "Beige", "Bisque", "Black",
           "BlanchedAlmond", "Blue", "BlueViolet", "Brown", "BurlyWood", "CadetBlue", "Chartreuse",
           "Chocolate", "Coral", "CornflowerBlue", "Cornsilk", "Crimson", "Cyan", "DarkBlue", "DarkCyan",
           "DarkGoldenRod", "DarkGray", "DarkGreen", "DarkKhaki", "DarkMagenta", "DarkOliveGreen",
           "DarkOrange", "DarkOrchid", "DarkRed", "DarkSalmon", "DarkSeaGreen", "DarkSlateBlue",
           "DarkSlateGray", "DarkTurquoise", "DarkViolet", "DeepPink", "DeepSkyBlue", "DimGray",
           "DodgerBlue", "FireBrick", "FloralWhite", "ForestGreen", "Fuchsia", "Gainsboro", "GhostWhite",
           "Gold", "GoldenRod", "Gray", "Green", "GreenYellow", "HoneyDew", "HotPink", "IndianRed",
           "Indigo", "Ivory", "Khaki", "Lavender", "LavenderBlush", "LawnGreen", "LemonChiffon",
           "LightBlue", "LightCoral", "LightCyan", "LightGoldenRodYellow", "LightGray", "LightGreen",
           "LightPink", "LightSalmon", "LightSeaGreen", "LightSkyBlue", "LightSlateGray", "LightSteelBlue",
           "LightYellow", "Lime", "LimeGreen", "Linen", "Magenta", "Maroon", "MediumAquaMarine", "MediumBlue",
           "MediumOrchid", "MediumPurple", "MediumSeaGreen", "MediumSlateBlue", "MediumSpringGreen",
           "MediumTurquoise", "MediumVioletRed", "MidnightBlue", "MintCream", "MistyRose", "Moccasin",
           "NavajoWhite", "Navy", "OldLace", "Olive", "OliveDrab", "Orange", "OrangeRed", "Orchid",
           "PaleGoldenRod", "PaleGreen", "PaleTurquoise", "PaleVioletRed", "PapayaWhip", "PeachPuff",
           "Peru", "Pink", "Plum", "PowderBlue", "Purple", "Red", "RosyBrown", "RoyalBlue", "SaddleBrown",
           "Salmon", "SandyBrown", "SeaGreen", "SeaShell", "Sienna", "Silver", "SkyBlue", "SlateBlue",
           "SlateGray", "Snow", "SpringGreen", "SteelBlue", "Tan", "Teal", "Thistle", "Tomato",
           "Turquoise", "Violet", "Wheat", "White", "WhiteSmoke", "Yellow", "YellowGreen"
   );
   final List<Integer> LIST_BACKGROUND_COLOR_INT = Arrays.asList(
           Color.argb(255, 0xF0, 0xF8, 0xFF),
           Color.argb(255, 0xFA, 0xEB, 0xD7),
           Color.argb(255, 0x00, 0xFF, 0xFF),
           Color.argb(255, 0x7F, 0xFF, 0xD4),
           Color.argb(255, 0xF0, 0xFF, 0xFF),
           Color.argb(255, 0xF5, 0xF5, 0xDC),
           Color.argb(255, 0xFF, 0xE4, 0xC4),
           Color.argb(255, 0x00, 0x00, 0x00),
           Color.argb(255, 0xFF, 0xEB, 0xCD),
           Color.argb(255, 0x00, 0x00, 0xFF),
           Color.argb(255, 0x8A, 0x2B, 0xE2),
           Color.argb(255, 0xA5, 0x2A, 0x2A),
           Color.argb(255, 0xDE, 0xB8, 0x87),
           Color.argb(255, 0x5F, 0x9E, 0xA0),
           Color.argb(255, 0x7F, 0xFF, 0x00),
           Color.argb(255, 0xD2, 0x69, 0x1E),
           Color.argb(255, 0xFF, 0x7F, 0x50),
           Color.argb(255, 0x64, 0x95, 0xED),
           Color.argb(255, 0xFF, 0xF8, 0xDC),
           Color.argb(255, 0xDC, 0x14, 0x3C),
           Color.argb(255, 0x00, 0xFF, 0xFF),
           Color.argb(255, 0x00, 0x00, 0x8B),
           Color.argb(255, 0x00, 0x8B, 0x8B),
           Color.argb(255, 0xB8, 0x86, 0x0B),
           Color.argb(255, 0xA9, 0xA9, 0xA9),
           Color.argb(255, 0x00, 0x64, 0x00),
           Color.argb(255, 0xBD, 0xB7, 0x6B),
           Color.argb(255, 0x8B, 0x00, 0x8B),
           Color.argb(255, 0x55, 0x6B, 0x2F),
           Color.argb(255, 0xFF, 0x8C, 0x00),
           Color.argb(255, 0x99, 0x32, 0xCC),
           Color.argb(255, 0x8B, 0x00, 0x00),
           Color.argb(255, 0xE9, 0x96, 0x7A),
           Color.argb(255, 0x8F, 0xBC, 0x8F),
           Color.argb(255, 0x48, 0x3D, 0x8B),
           Color.argb(255, 0x2F, 0x4F, 0x4F),
           Color.argb(255, 0x00, 0xCE, 0xD1),
           Color.argb(255, 0x94, 0x00, 0xD3),
           Color.argb(255, 0xFF, 0x14, 0x93),
           Color.argb(255, 0x00, 0xBF, 0xFF),
           Color.argb(255, 0x69, 0x69, 0x69),
           Color.argb(255, 0x1E, 0x90, 0xFF),
           Color.argb(255, 0xB2, 0x22, 0x22),
           Color.argb(255, 0xFF, 0xFA, 0xF0),
           Color.argb(255, 0x22, 0x8B, 0x22),
           Color.argb(255, 0xFF, 0x00, 0xFF),
           Color.argb(255, 0xDC, 0xDC, 0xDC),
           Color.argb(255, 0xF8, 0xF8, 0xFF),
           Color.argb(255, 0xFF, 0xD7, 0x00),
           Color.argb(255, 0xDA, 0xA5, 0x20),
           Color.argb(255, 0x80, 0x80, 0x80),
           Color.argb(255, 0x00, 0x80, 0x00),
           Color.argb(255, 0xAD, 0xFF, 0x2F),
           Color.argb(255, 0xF0, 0xFF, 0xF0),
           Color.argb(255, 0xFF, 0x69, 0xB4),
           Color.argb(255, 0xCD, 0x5C, 0x5C),
           Color.argb(255, 0x4B, 0x00, 0x82),
           Color.argb(255, 0xFF, 0xFF, 0xF0),
           Color.argb(255, 0xF0, 0xE6, 0x8C),
           Color.argb(255, 0xE6, 0xE6, 0xFA),
           Color.argb(255, 0xFF, 0xF0, 0xF5),
           Color.argb(255, 0x7C, 0xFC, 0x00),
           Color.argb(255, 0xFF, 0xFA, 0xCD),
           Color.argb(255, 0xAD, 0xD8, 0xE6),
           Color.argb(255, 0xF0, 0x80, 0x80),
           Color.argb(255, 0xE0, 0xFF, 0xFF),
           Color.argb(255, 0xFA, 0xFA, 0xD2),
           Color.argb(255, 0xD3, 0xD3, 0xD3),
           Color.argb(255, 0x90, 0xEE, 0x90),
           Color.argb(255, 0xFF, 0xB6, 0xC1),
           Color.argb(255, 0xFF, 0xA0, 0x7A),
           Color.argb(255, 0x20, 0xB2, 0xAA),
           Color.argb(255, 0x87, 0xCE, 0xFA),
           Color.argb(255, 0x77, 0x88, 0x99),
           Color.argb(255, 0xB0, 0xC4, 0xDE),
           Color.argb(255, 0xFF, 0xFF, 0xE0),
           Color.argb(255, 0x00, 0xFF, 0x00),
           Color.argb(255, 0x32, 0xCD, 0x32),
           Color.argb(255, 0xFA, 0xF0, 0xE6),
           Color.argb(255, 0xFF, 0x00, 0xFF),
           Color.argb(255, 0x80, 0x00, 0x00),
           Color.argb(255, 0x66, 0xCD, 0xAA),
           Color.argb(255, 0x00, 0x00, 0xCD),
           Color.argb(255, 0xBA, 0x55, 0xD3),
           Color.argb(255, 0x93, 0x70, 0xDB),
           Color.argb(255, 0x3C, 0xB3, 0x71),
           Color.argb(255, 0x7B, 0x68, 0xEE),
           Color.argb(255, 0x00, 0xFA, 0x9A),
           Color.argb(255, 0x48, 0xD1, 0xCC),
           Color.argb(255, 0xC7, 0x15, 0x85),
           Color.argb(255, 0x19, 0x19, 0x70),
           Color.argb(255, 0xF5, 0xFF, 0xFA),
           Color.argb(255, 0xFF, 0xE4, 0xE1),
           Color.argb(255, 0xFF, 0xE4, 0xB5),
           Color.argb(255, 0xFF, 0xDE, 0xAD),
           Color.argb(255, 0x00, 0x00, 0x80),
           Color.argb(255, 0xFD, 0xF5, 0xE6),
           Color.argb(255, 0x80, 0x80, 0x00),
           Color.argb(255, 0x6B, 0x8E, 0x23),
           Color.argb(255, 0xFF, 0xA5, 0x00),
           Color.argb(255, 0xFF, 0x45, 0x00),
           Color.argb(255, 0xDA, 0x70, 0xD6),
           Color.argb(255, 0xEE, 0xE8, 0xAA),
           Color.argb(255, 0x98, 0xFB, 0x98),
           Color.argb(255, 0xAF, 0xEE, 0xEE),
           Color.argb(255, 0xDB, 0x70, 0x93),
           Color.argb(255, 0xFF, 0xEF, 0xD5),
           Color.argb(255, 0xFF, 0xDA, 0xB9),
           Color.argb(255, 0xCD, 0x85, 0x3F),
           Color.argb(255, 0xFF, 0xC0, 0xCB),
           Color.argb(255, 0xDD, 0xA0, 0xDD),
           Color.argb(255, 0xB0, 0xE0, 0xE6),
           Color.argb(255, 0x80, 0x00, 0x80),
           Color.argb(255, 0xFF, 0x00, 0x00),
           Color.argb(255, 0xBC, 0x8F, 0x8F),
           Color.argb(255, 0x41, 0x69, 0xE1),
           Color.argb(255, 0x8B, 0x45, 0x13),
           Color.argb(255, 0xFA, 0x80, 0x72),
           Color.argb(255, 0xF4, 0xA4, 0x60),
           Color.argb(255, 0x2E, 0x8B, 0x57),
           Color.argb(255, 0xFF, 0xF5, 0xEE),
           Color.argb(255, 0xA0, 0x52, 0x2D),
           Color.argb(255, 0xC0, 0xC0, 0xC0),
           Color.argb(255, 0x87, 0xCE, 0xEB),
           Color.argb(255, 0x6A, 0x5A, 0xCD),
           Color.argb(255, 0x70, 0x80, 0x90),
           Color.argb(255, 0xFF, 0xFA, 0xFA),
           Color.argb(255, 0x00, 0xFF, 0x7F),
           Color.argb(255, 0x46, 0x82, 0xB4),
           Color.argb(255, 0xD2, 0xB4, 0x8C),
           Color.argb(255, 0x00, 0x80, 0x80),
           Color.argb(255, 0xD8, 0xBF, 0xD8),
           Color.argb(255, 0xFF, 0x63, 0x47),
           Color.argb(255, 0x40, 0xE0, 0xD0),
           Color.argb(255, 0xEE, 0x82, 0xEE),
           Color.argb(255, 0xF5, 0xDE, 0xB3),
           Color.argb(255, 0xFF, 0xFF, 0xFF),
           Color.argb(255, 0xF5, 0xF5, 0xF5),
           Color.argb(255, 0xFF, 0xFF, 0x00),
           Color.argb(255, 0x9A, 0xCD, 0x32)
   );
   Spinner spinnerScaleType;
   Spinner spinnerBackgroundColor;
   ImageView imageViewMain;
   ImageButton btnBrowseImg;

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

   private void handlePermission() {
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
         return;
      }

      if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
         //ask for permission
         ActivityCompat.requestPermissions(this,
                 new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                 SELECT_PICTURE);
      }
   }

   @Override
   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      switch (requestCode) {
         case SELECT_PICTURE:
            for (int i = 0; i < permissions.length; i++) {
               String permission = permissions[i];
               if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                  boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
                  if (showRationale) {
                     //  Show your own message here
                  } else {
                     showSettingsAlert();
                  }
               }
            }
      }
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
   }

   /* Choose an image from Gallery */
   void openImageChooser() {
      Intent intent = new Intent();
      intent.setType("image/*");
      intent.setAction(Intent.ACTION_GET_CONTENT);
      startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
   }

   public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      new Thread(new Runnable() {
         @Override
         public void run() {
            if (resultCode == RESULT_OK) {
               if (requestCode == SELECT_PICTURE) {
                  // Get the url from data
                  final Uri selectedImageUri = data.getData();
                  if (null != selectedImageUri) {
                     // Get the path from the Uri
                     String path = getPathFromURI(selectedImageUri);
                     Log.i(TAG, "Image Path : " + path);
                     // Set the image in ImageView
                     imageViewMain.post(new Runnable() {
                        @Override
                        public void run() {
                           imageViewMain.setImageURI(selectedImageUri);
                        }
                     });

                  }
               }
            }
         }
      }).start();

   }

   /* Get the real path from the URI */
   public String getPathFromURI(Uri contentUri) {
      String res = null;
      String[] proj = {MediaStore.Images.Media.DATA};
      Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
      if (cursor.moveToFirst()) {
         int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
         res = cursor.getString(column_index);
      }
      cursor.close();
      return res;
   }

   private void showSettingsAlert() {
      AlertDialog alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setTitle("Alert");
      alertDialog.setMessage("App needs to access the Camera.");
      alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
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
                    openAppSettings(MainActivity.this);
                 }
              });
      alertDialog.show();
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      handlePermission();
      findView();
      setSpinnerAdapter();
      setListener();
   }

   void findView() {
      spinnerScaleType = findViewById(R.id.spinner_scale_type);
      spinnerBackgroundColor = findViewById(R.id.spinner_background_color);
      imageViewMain = findViewById(R.id.image_view_main);
      btnBrowseImg = findViewById(R.id.btn_change_img);
   }

   void setSpinnerAdapter() {
      ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, LIST_SCALE_TYPE);
      spinnerScaleType.setAdapter(dataAdapter);
      dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

      ColorSpinnerAdapter customColorAdapter = new ColorSpinnerAdapter(getApplicationContext(), LIST_BACKGROUND_COLOR_STR, LIST_BACKGROUND_COLOR_INT);
      spinnerBackgroundColor.setAdapter(customColorAdapter);
   }

   void setListener() {
      spinnerScaleType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            imageViewMain.setScaleType(LIST_SCALE_TYPE_VALUE.get(position));
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {
            imageViewMain.setScaleType(LIST_SCALE_TYPE_VALUE.get(0));
         }
      });

      spinnerBackgroundColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            imageViewMain.setBackgroundColor(LIST_BACKGROUND_COLOR_INT.get(position));
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {
            imageViewMain.setBackgroundColor(LIST_BACKGROUND_COLOR_INT.get(0));
         }
      });

      btnBrowseImg.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            openImageChooser();
         }
      });
   }
}