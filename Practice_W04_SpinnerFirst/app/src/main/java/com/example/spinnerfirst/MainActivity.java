package com.example.spinnerfirst;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   final List<String> LIST_PROVINCES = Arrays.asList(
           "Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang",
           "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Phước", "Bình Thuận",
           "Bình Định", "Cà Mau", "Cần Thơ", "Cao Bằng", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Tĩnh",
           "Hải Dương", "Hải Phòng", "Hậu Giang", "Hoà Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang",
           "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định",
           "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam",
           "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
           "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang",
           "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp"
   );

   private Spinner spinnerProvince;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      spinnerProvince = findViewById(R.id.spinner_province);

      ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, LIST_PROVINCES);
      spinnerProvince.setAdapter(dataAdapter);
      dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

      spinnerProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "Bạn đã chọn tỉnh: " + LIST_PROVINCES.get(position), Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(MainActivity.this, "Không có tỉnh/thành phố nào được chọn", Toast.LENGTH_SHORT).show();
         }
      });
   }
}