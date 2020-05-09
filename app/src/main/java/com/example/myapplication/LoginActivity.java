package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     private TextView usernameText,pwdText;
     private Button loginBtm,registerBtm;
     private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText=findViewById(R.id.usertext);
        pwdText=findViewById(R.id.pwdtext);
        loginBtm=findViewById(R.id.login);
        registerBtm=findViewById(R.id.register);

        loginBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"点击登录按钮",Toast.LENGTH_SHORT).show();
                Log.d("get",usernameText.getText().toString());
            }
        });

        registerBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"点击注册按钮"+user+"注册成功",Toast.LENGTH_SHORT).show();;
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        usernameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("用户名改变：",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("用户名最终：",s.toString());
                user=s.toString();
            }
        });

    }
}
