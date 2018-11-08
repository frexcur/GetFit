package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DBTest {

  private static String dbURL = "jdbc:derby:C:/Apache/db-derby-10.14.2.0-bin/bin/MyDBHi;create=true;";
  private static String tableName = "users";
  // jdbc Connection
  private static Connection conn = null;
  private static Statement stmt = null;

  public static void main(String[] args) {
    createConnection();
    shutdown();
  }

  public static void createConnection() {
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
      //Get a connection
      conn = DriverManager.getConnection(dbURL);
    } catch (Exception except) {
      except.printStackTrace();
    }
  }

  private static void insertRestaurants(int id, String restName, String cityName) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + tableName + " values (" +
          id + ",'" + restName + "','" + cityName + "')");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  private static void selectRestaurants() {
    try {
      stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery("select * from " + tableName);
      ResultSetMetaData rsmd = results.getMetaData();
      int numberCols = rsmd.getColumnCount();
      for (int i = 1; i <= numberCols; i++) {
        //print Column Names
        System.out.print(rsmd.getColumnLabel(i) + "\t\t");
      }

      System.out.println("\n-------------------------------------------------");

      while (results.next()) {
        int id = results.getInt(1);
        String restName = results.getString(2);
        String cityName = results.getString(3);
        System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
      }
      results.close();
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  private static void shutdown() {
    try {
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        DriverManager.getConnection(dbURL + ";shutdown=true");
        conn.close();
      }
    } catch (SQLException sqlExcept) {

    }

  }

  public void insertFirstName(String firstName) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + "USERS (FIRSTNAME) " + " values (" +
          "'" + firstName + "')");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void insertLastName(String lastName) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + "USERS (LASTNAME) " + " values (" +
          "'" + lastName + "')");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void createAccount(String firstName, String lastName, String username,
      String password, int age, double weight, double height) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + "USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, "
          + "AGE, WEIGHT, HEIGHT) " + " values (" +
          "'" + firstName + "', '" + lastName + "', '" + username + "', '" +
          password + "', " + age + ", " + weight + ", " + height + ")");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }
}