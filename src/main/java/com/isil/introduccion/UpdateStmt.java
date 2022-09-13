package com.isil.introduccion;
import java.sql.*;

public class UpdateStmt {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
                "root",
                "root");

        Statement stmt= cnx.createStatement();
        int filaAfectada= stmt.executeUpdate("UPDATE Users SET name='Jose'  where idUser=1");
        System.out.println(filaAfectada);

        PreparedStatement actualizarNombre=cnx.prepareStatement("select * from Users where  idUser=?");
        actualizarNombre.setInt(1, 1);

        ResultSet rs =actualizarNombre.executeQuery();

        while (rs.next()) {
            System.out.println( rs.getString("name"));
            System.out.println( rs.getString("idUser"));
            System.out.println( rs.getString("city"));
        }

        cnx.close();
    }
}
