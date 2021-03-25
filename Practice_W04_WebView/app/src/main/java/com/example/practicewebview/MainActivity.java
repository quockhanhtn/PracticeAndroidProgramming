package com.example.practicewebview;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   String currentWebViewUrl = "";
   WebView webView;

   ImageButton btnRefresh;
   ImageButton btnForward;
   ImageButton btnGoBack;
   EditText editTextUrl;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      initComponent();

      goToUrl("https://quockhanh.dev");
   }

   void initComponent() {
      webView = (WebView) findViewById(R.id.web_view);

      btnGoBack = (ImageButton) findViewById(R.id.btn_go_back);
      btnForward = (ImageButton) findViewById(R.id.btn_forward);
      btnRefresh = (ImageButton) findViewById(R.id.btn_refresh);

      editTextUrl = (EditText) findViewById(R.id.edit_text_url);

      editTextUrl.setOnKeyListener(new View.OnKeyListener() {
         public boolean onKey(View v, int keyCode, KeyEvent event) {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
               goToUrl(editTextUrl.getText().toString());
               return true;
            }
            return false;
         }
      });
   }

   public void btnGoBackOnClick(View v) {
      webView.goBack();
      updateUrl();
   }

   public void btnForwardClick(View v) {
      webView.goForward();
      updateUrl();
   }

   public void btnRefreshOnClick(View v) {
      webView.loadUrl(currentWebViewUrl);
   }

   void goToUrl(String url) {
      currentWebViewUrl = url;
      webView.loadUrl(currentWebViewUrl);
      editTextUrl.setText(currentWebViewUrl);
      updateButtonStatus();
   }

   void updateUrl() {
      currentWebViewUrl = webView.getUrl();
      editTextUrl.setText(currentWebViewUrl);
      updateButtonStatus();
   }

   void updateButtonStatus() {
       btnGoBack.setEnabled(webView.canGoBack());
       btnForward.setEnabled(webView.canGoForward());
       editTextUrl.clearFocus();
   }
}