package com.isil.introduccion;
import java.sql.*;

public class UpdatePrepared {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
                "root",
                "root");

        PreparedStatement preparedStmt = cnx.prepareStatement("UPDATE Users SET name =? WHERE idUser= ?");
        preparedStmt.setString(1,"Juan");
        preparedStmt.setInt(2,1);
       // preparedStmt.setString(3,"Manchester");
        preparedStmt.executeUpdate();

        PreparedStatement actualizarNombre=cnx.prepareStatement("select * from Users where  idUser=?");
        actualizarNombre.setInt(1, 1);

        ResultSet rs =actualizarNombre.executeQuery();

        while (rs.next()) {
            System.out.println( rs.getString("name"));
            System.out.println( rs.getString("phone"));
            System.out.println( rs.getString("city"));
        }

        cnx.close();
    }
}
