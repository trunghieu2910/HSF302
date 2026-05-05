package com.mycompany.superapp;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
       // ta sẽ dùng các class đc cung cấp ẵn bưới JDK cos trong JDBC
        // JDBC từ ffoongj móc vưới sql server để lấy dữ liệu về

        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HSF302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "1234";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Subject");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Code") + " " + rs.getString("Name"));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}