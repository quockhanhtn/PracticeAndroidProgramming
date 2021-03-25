package com.example.id18110304_firstapplication;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private EditText editTextName;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView() {
        textViewResult = findViewById(R.id.textViewResult);
        editTextName = findViewById(R.id.editTextName);
        buttonSubmit = findViewById(R.id.btnSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSubmitOnClick(v);
            }
        });
    }

    void buttonSubmitOnClick(View v) {
        String userInputName = String.valueOf(editTextName.getText()).trim();
        String message = "";
        if (userInputName.isEmpty()) {
            message = getResources().getString(R.string.empty_name_text);
        } else {
            message = getResources().getString(R.string.hello_text)
                    + " <b style=\"color: #000;\">" + userInputName + " </b>!<br/>"
                    + getResources().getString(R.string.message_text);
        }
        textViewResult.setText(Html.fromHtml(message));
    }
}

