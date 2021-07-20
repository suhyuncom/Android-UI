package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    //로그인 버튼 클릭 시 전환되는 로그인 화면
    Button Button;
    EditText EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        EditText = (EditText) findViewById(R.id.loginId);
        EditText = (EditText) findViewById(R.id.loginPwd);
    }

    public void loginSetting(){
        Button = (Button) findViewById(R.id.login);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원 정보 확인, 로그인 안내
            }
        });
    }

    public void createAcSetting(){
        Button = (Button) findViewById(R.id.login);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입
            }
        });
    }

    public void forgetAcSetting(){
        Button = (Button) findViewById(R.id.login);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원 정보 찾기
            }
        });
    }
}