package com.example.mysql_andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static  final  String TAG="MainActivity";
    private EditText name,password,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =findViewById(R.id.edit_name);
        password= findViewById(R.id.edit_password);
        phone = findViewById(R.id.edit_phone);
    }

    public void fun(View v){
        switch (v.getId()){
            //注册
            case R.id.register:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String n = name.getText().toString().trim();
                        String paw =password.getText().toString().trim();
                        String num = phone.getText().toString().trim();
                        UserDao ud = new UserDao();
                        boolean result = ud.register(n,paw, num);
                        if (!result){
                            Log.i(TAG,"fun"+result);
                            Looper.prepare();
                            Toast.makeText(MainActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                            Looper.loop();

                            //以上为jdbc注册
                        }else {
                            Log.i(TAG,"fun"+result);
                            Looper.prepare();
                            Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            Looper.loop();

                            //以上为jdbc注册
                        }

                    }
                }).start();
                break;
            case R.id.login:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String n= name.getText().toString().trim();
                        String paw =password.getText().toString().trim();
                        if(n.equals("")||paw.equals("")){
                            Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }
                        UserDao ud = new UserDao();
                        Boolean result =ud.login(n,paw);
                        if (!result){
                            Looper.prepare();
                            Toast.makeText(MainActivity.this, "用户名不存在或密码错误！", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }else {
                            Looper.prepare();
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(MainActivity.this,SuccessActivity.class);
                            intent.putExtra("name",n);
                            startActivity(intent);
                            Looper.loop();
                        }
                        //以上为jdbc登录
                    }
                }).start();
        }
    }

}
