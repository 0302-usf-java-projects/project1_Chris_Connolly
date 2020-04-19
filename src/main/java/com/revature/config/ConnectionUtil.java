package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

  static {
    try {
        Class.forName("org.postgresql.Driver");
    } catch(ClassNotFoundException e) {
        e.printStackTrace();
    }
}

public static Connection connect() throws SQLException {
    return DriverManager.getConnection(
            "jdbc:postgresql://chrisco-db.c7xvbdwzcuip.us-east-1.rds.amazonaws.com"+
                    ":5432/ers",
            "chriscon46",
            "wasspord"
            );
}


}