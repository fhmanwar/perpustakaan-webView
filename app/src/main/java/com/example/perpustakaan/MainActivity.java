package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
//
//        String url = "http://192.168.0.4/perpustakaan/auth";
//        WebView show = (WebView) findViewById(R.id.showWeb);
////        web.loadUrl("http://192.168.0.4/perpustakaan/auth");
//        show.getSettings().setJavaScriptEnabled(true);
//        show.setWebViewClient(new WebViewClient());
//        show.loadUrl(url);
//    }

    WebView view;
    SwipeRefreshLayout SwipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        SwipeRefresh = (SwipeRefreshLayout) this.findViewById(R.id.swipeRefresh);
        String url = "http://192.168.100.10/perpustakaan/";
        view = (WebView) this.findViewById(R.id.showWeb);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setDisplayZoomControls(false);
//        view.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+ url);
//        view.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        view.setWebViewClient(new WebViewClient());
        view.loadUrl(url);
//        init();
//        listener();
        SwipeRefresh.setOnRefreshListener(
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    view.reload();
                    SwipeRefresh.setRefreshing(false);
                }
            }
        );
    }

    @Override
    public void onBackPressed() {
        if(view != null && view.canGoBack()){
            view.goBack();
        }else{
            finish();
        }
    }
}
