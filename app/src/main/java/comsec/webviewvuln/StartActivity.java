package comsec.webviewvuln;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StartActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_show);

        Intent intent = getIntent();

        String WebViewTitle = intent.getStringExtra("title");
        String WebViewURLtoLoad = intent.getStringExtra("url");
        getSupportActionBar().setTitle(WebViewTitle);

        WebView myWebView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.clearCache(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.startsWith("sendsms://")) {
                    Uri DataOfUri = Uri.parse(url);
                    String PhoneNum = DataOfUri.getHost();
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(PhoneNum, null, "MESSAGE FROM COMSEC APP", null, null);
                    return true;
                } else {
                    return false;
                }
            }
        });

        myWebView.addJavascriptInterface(new SmokeyBear(), "SmokeyBear");
        myWebView.loadUrl(WebViewURLtoLoad);
    }
}

