package com.isil.introduccion;

import javax.swing.*;
import java.sql.*;

public class MainAPP {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver"); // cargamos el driver
        Connection cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/persona",
                                                    "root",
                                                    "root"
        );

        String query= "select * from Users "; //es un string que luego se pasa como valor en el resultset
        Statement stm=cnx.createStatement(); //ayuda a ejecutar query
        ResultSet rs= stm.executeQuery(query); //almacenamos los datos de la consulta realizada

        // dependencias:https://mvnrepository.com/search?q=sql+server+

        while (rs.next()) {
            System.out.println(rs.getString("idUser"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("city"));
        }

    }
}
