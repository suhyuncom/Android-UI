package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        //webViewSetting();
    }

    //웹뷰 기본 세팅, 실행부분
    public void webViewSetting(){
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true); //javaScript 허용
        mWebView.loadUrl("https://www.naver.com/"); //웹뷰 url
        mWebView.setWebChromeClient((new WebChromeClient())); //웹뷰에서 크롬 허용
        mWebView.setWebViewClient(new webViewClientClass());//새창 띄우기 없이 웹뷰 내에서 작동
    }

    //웹뷰 내에서 화면 뒤로가기
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //웹뷰 내에서 페이지 이동 클래스
    private class webViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL", url);
            view.loadUrl(url);
            return true;
        }
    }
}

