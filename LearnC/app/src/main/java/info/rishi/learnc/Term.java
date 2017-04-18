package info.rishi.learnc;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Term extends AppCompatActivity {
    WebView mWebView;
    String pos = "";
    Intent in=getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_term);


        this.mWebView = ((WebView)findViewById(R.id.mWebView));
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().getAllowFileAccessFromFileURLs();
        mWebView.getSettings().setLoadWithOverviewMode(true);



        mWebView.loadUrl(getIntent().getDataString());

//        Bundle extras = getIntent().getExtras();
//        String value = "file:///android_asset/organic_agriculture.html";
//        if (extras!=null){
//            value = extras.getString("keyHtml");
//        }

//        this.mWebView.getSettings().setBuiltInZoomControls(true);
//        this.mWebView.getSettings().setLoadWithOverviewMode(false);
//        this.mWebView.getSettings().setUseWideViewPort(false);
//        this.mWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
      // this.mWebView.loadUrl(value);

    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return(false);
        }
    }
}
