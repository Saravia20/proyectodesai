package com.isil.introduccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppSql {
    public static void main(String[] args)  throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SqlServerDriver");
        Connection cnx= DriverManager.getConnection("jdbc:sqlserver://localhost:3306;databaseName=mantenimiento",
                "root",
                "root"
        );
        Statement stmt2= cnx.createStatement();
        ResultSet rs= stmt2.executeQuery("select * from Tb_Cliente where idCliente=1");

        while (rs.next()) {
            System.out.println( rs.getString("cod_ubigeo"));

        }
    }
}
