package com.isil.introduccion;

import java.sql.*;

public class PreparedStmt {
    public static void main(String[] args)  throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
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

        //----------------------------------------------//
        PreparedStatement pstmt = cnx.prepareStatement("select * from Users where name=? and city=?");
        pstmt.setString(1, "Messi");
        pstmt.setString(2, "Argentina");

        ResultSet rs2=pstmt.executeQuery();

        while (rs2.next()) {
            System.out.println( rs2.getString("name") + "\n" +
                    rs2.getString("phone") + "\n" +
                    rs2.getString("city"));

        }
        cnx.close();
    }
}
