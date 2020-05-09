package com.example.mysql_andriod;

import android.nfc.Tag;
import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static android.content.ContentValues.TAG;

public class UserDao {
    JdbcUtil jdbcUtil = JdbcUtil.getInstance();

    Connection conn = jdbcUtil.getConnection("android","root","123456");

    //注册
    public boolean register(String name,String password,String phone){
        if(conn == null){
            Log.i(TAG,"register:conn is null");

            return false;
        }
        else {

            String sql ="insert into user(password,phone,name) values(?,?,?)";
            try{
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1,password);
                pre.setInt(2,Integer.parseInt(phone));
                pre.setString(3,name);
                return pre.execute();
            } catch (SQLException e) {
                return false;
            }finally {
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }
    //登录

    public boolean login(String name,String password){
        if (conn == null){
            Log.i(TAG,"login:conn is null");
            return false;
            }else {
            String sql ="select * from user where name=? and password=?";
            try{
                PreparedStatement pres = conn.prepareStatement(sql);
                pres.setString(1,name);
                pres.setString(2,password);
                ResultSet res = pres.executeQuery();
                boolean t =res.next();
                return t;
            }catch (SQLException e){
                return false;
            }

        }

    }

}
