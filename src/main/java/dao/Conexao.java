package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  private String driver = "com.mysql.jdbc.Driver";
  private String URL = "jdbc:mysql://localhost/iec_crud?useTimezone=true&serveTimezone=UTC";
  private String USER = "root";
  private String SENHA = "123456";
  private Connection conn;

  public Conexao() {
    try {
      Class.forName(driver);
      conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Connection getConn() {
    return conn;
  }

  public void fecharConexao() {
    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}