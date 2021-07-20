package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

//인트로 화면 로딩 후 보여지는 첫 화면
public class MainActivity extends AppCompatActivity {
    WebView mWebView;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_start_page);

        ButtonSetting();
        //웹뷰 실행 부분, 필요한 부분에 호출.
        //webViewSetting();
    }

    //웹뷰 기본 세팅, 실행부분
    public void webViewSetting(){
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true); //javaScript 허용
        mWebView.loadUrl("https://www.naver.com/"); //웹뷰 url <수정>
        mWebView.setWebChromeClient((new WebChromeClient())); //웹뷰에서 크롬 허용
        mWebView.setWebViewClient(new webViewClientClass());//새창 띄우기 없이 웹뷰 내에서 작동
    }

    //버튼 세팅, 눌리면 loginactivity로 이동
    public void ButtonSetting(){
        mButton = (Button) findViewById(R.id.startloginbtn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
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

