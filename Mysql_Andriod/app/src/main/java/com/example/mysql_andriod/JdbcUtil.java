package com.example.mysql_andriod;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
    private static JdbcUtil instance;

    public static JdbcUtil getInstance() {
        if (instance == null){
            instance =new JdbcUtil();
        }
        return instance;
    }
   public Connection getConnection(String dbName, String name, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://192.168.1.5:3306/"+dbName;
            return DriverManager.getConnection(url,name,password);
        }catch (Exception e){
            return null;
        }


   }


}
