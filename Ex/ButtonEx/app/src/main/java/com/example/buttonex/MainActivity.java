package com.example.buttonex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    final static String DATE_FORMAT = "dd/MM/yyyy";

    final Calendar MY_CALENDAR = Calendar.getInstance();

    EditText editTextFirstName;
    EditText editTextLastName;
    EditText editTextDob;

    ImageView imageGender;

    Switch toggleTerm;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
    }

    void initView() {
        editTextFirstName = (EditText) findViewById(R.id.edit_text_first_name);
        editTextLastName = (EditText) findViewById(R.id.edit_text_last_name);
        editTextDob = (EditText) findViewById(R.id.edit_text_dob);
        imageGender = (ImageView) findViewById(R.id.image_gender);
        toggleTerm = (Switch) findViewById(R.id.toggle_term);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }

    void setListener() {
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MY_CALENDAR.set(Calendar.YEAR, year);
                MY_CALENDAR.set(Calendar.MONTH, monthOfYear);
                MY_CALENDAR.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDobEditText();
            }
        };

        editTextDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this,
                        date,
                        MY_CALENDAR.get(Calendar.YEAR),
                        MY_CALENDAR.get(Calendar.MONTH),
                        MY_CALENDAR.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        toggleTerm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnRegister.setEnabled(toggleTerm.isChecked());
            }
        });
    }

    private void updateDobEditText() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        editTextDob.setText(sdf.format(MY_CALENDAR.getTime()));
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if (!checked) {
            return;
        }

        switch (view.getId()) {
            case R.id.radio_gender_male:
                imageGender.setImageResource(R.drawable.gender_male);
                break;
            case R.id.radio_gender_female:
                imageGender.setImageResource(R.drawable.gender_female);
                break;
            case R.id.radio_gender_other:
                imageGender.setImageResource(R.drawable.gender_non_binary);
                break;
        }
    }

    public void onButtonShowPopupWindowClick(View view) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        boolean focusables = true; // lets taps outside the popup also dismiss it

        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusables);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}