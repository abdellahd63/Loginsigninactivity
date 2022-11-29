package com.example.pharmacom;
import java.sql.Connection;
import java.sql.DriverManager;
public class databaseconn {
    private Connection databaselink;

    public Connection getconnection(){
        String databasename="pharmacomdb";
        String databaseuser="cryptocode";
        String databasepassword="cryptocode";
        String url="jdbc:mysql://127.0.0.1:3306/?user="+databasename;
        try{
            Class.forName("com.mysql.cj.jbdc.Driver");
            databaselink=DriverManager.getConnection(url,databaseuser,databasepassword);
        }catch(Exception e){
            e.printStackTrace();
        }
        return databaselink;
    }
}
