package com.isil.introduccion;

import java.sql.*;

public class InsertStmt  {
    public static void main(String[]args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
                "root",
                "root");

        Statement stmt= cnx.createStatement();
        int filas= stmt.executeUpdate("INSERT INTO Users VALUES  (5,'Ricardo',956421586,'Lima')");
        System.out.println("filas: " + filas);

        PreparedStatement insert1= cnx.prepareStatement("select * from Users where name=?");
        insert1.setString(1, "Ricardo");

        ResultSet rs = insert1.executeQuery();

        while (rs.next()) {
            System.out.println( rs.getString("name"));
        }

        cnx.close();
    }
}
