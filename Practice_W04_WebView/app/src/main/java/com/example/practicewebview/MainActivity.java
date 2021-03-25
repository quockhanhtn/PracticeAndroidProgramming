package com.example.practicewebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    String currentWebViewUrl = "";
    WebView webView;

    ImageButton btnRefresh;
    ImageButton btnForward;
    ImageButton btnGoBack;
    EditText editTextUrl;
    ImageButton btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        setListener();

        goToUrl("https://quockhanh.dev");
    }

    void initComponent() {
        webView = (WebView) findViewById(R.id.web_view);

        btnGoBack = (ImageButton) findViewById(R.id.btn_go_back);
        btnForward = (ImageButton) findViewById(R.id.btn_forward);
        btnRefresh = (ImageButton) findViewById(R.id.btn_refresh);
        btnEnter = (ImageButton) findViewById(R.id.btn_enter);

        editTextUrl = (EditText) findViewById(R.id.edit_text_url);
    }

    void setListener() {
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
                updateUrl();
            }
        });

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goForward();
                updateUrl();
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(currentWebViewUrl);
            }
        });

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl(editTextUrl.getText().toString());
            }
        });
    }

    void goToUrl(String url) {
        currentWebViewUrl = url;
        webView.loadUrl(currentWebViewUrl);
    }

    void updateUrl() {
        currentWebViewUrl = webView.getUrl();
        editTextUrl.setText(currentWebViewUrl);
    }
}