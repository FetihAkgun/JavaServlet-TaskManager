package com.example.web1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeritabaniBaglanti {

    public static Connection veritabaniBaslat() throws SQLException, ClassNotFoundException {
        String dbDriver="com.mysql.cj.jdbc.Driver";
        String dbURl="jdbc:mysql://localhost:3306/";

        String dbName="minipro";
        String dbUsername="root";
        String dbPassword="";

        Class.forName(dbDriver);
        Connection con= DriverManager.getConnection(dbURl + dbName,dbUsername,dbPassword);
        return con;

    }




}
