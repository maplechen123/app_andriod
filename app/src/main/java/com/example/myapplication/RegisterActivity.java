package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    EditText username,password,phonenum;
    Button regbtm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        regbtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String pass= password.getText().toString().trim();
                String phone = phonenum.getText().toString().trim();
                Log.i("TAG",name+"_"+pass+"_"+phone);
                UserService uService = new UserService(RegisterActivity.this);
                User user=new User();
                user.setUsername(name);
                user.setPassword(pass);
                user.setPhonenum(Integer.parseInt(phone));
                uService.register(user);
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();


            }
        });
    }
    private void findViews(){
        username=findViewById(R.id.register_user);
        password=findViewById(R.id.register_password);
        phonenum=findViewById(R.id.register_phonenum);
        regbtm=findViewById(R.id.register_btm);

    }
}
