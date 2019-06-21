package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
        String url = "http://192.168.0.4/perpustakaan/";
        view = (WebView) this.findViewById(R.id.showWeb);

        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setDisplayZoomControls(false);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
        view.setWebViewClient(new WebViewClient());

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
