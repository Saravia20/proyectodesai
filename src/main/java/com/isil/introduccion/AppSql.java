package com.isil.introduccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppSql {
    public static void main(String[] args)  throws Exception {
        Class.forName("com.microsoft.jdbc.sqlserver.SqlServerDriver");
        Connection cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
                "root",
                "root"
        );
        Statement stmt2= cnx.createStatement();
        ResultSet rs= stmt2.executeQuery("select * from Users where name='Ronaldo'");

        while (rs.next()) {
            System.out.println( rs.getString("name") + "\n" +
                    rs.getString("phone") + "\n" +
                    rs.getString("city"));

        }
    }
}
