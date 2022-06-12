package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
    private Connection con;
    public DButil() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=sodb;user=lgt;password=123456";
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url);
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return con;
    }
    public void dis_connect() throws SQLException{
        con.close();
    }
}
