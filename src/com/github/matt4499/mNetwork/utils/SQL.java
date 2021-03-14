package com.github.matt4499.mNetwork.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

  static String host;
  static String port;
  static String database;
  static String username;
  static String password;
  public static Connection connection;

  public static Boolean init() {
    host = "game-db-ca-1.iceline.host";
    port = "3306";
    database = "s11731_logs";
    username = "u11731_oDgDspODaO";
    password = "^11HvlysP.^NthRq5.IEJd6f";
    try {
      connection = openConnection();
      Statement statement = openConnection().createStatement();
      statement.close();
      return true;
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return false;
    }

  }

  public static Connection openConnection() throws SQLException, ClassNotFoundException {
    if (connection != null && !connection.isClosed()) {
      return connection;
    }
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,
        username, password);
  }

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    return openConnection();
  }

}
