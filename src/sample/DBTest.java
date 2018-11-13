package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

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
      sqlExcept.printStackTrace();
    }
  }

  public void insertFirstName(String firstName) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + tableName + "(FIRSTNAME) " + " values (" +
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

  public void insertUsername(String username) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into USERS (USERNAME) values (" +
          "'" + username + "')");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void insertPassword(String password) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + "USERS (PASSWORD) " + " values (" +
          "'" + password + "')");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void editAge(String username, int age) {
    try {
      stmt = conn.createStatement();
      stmt.execute("update USERS set AGE = " + age +  " where USERNAME = '" + username + "'");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void editWeight(String username, double weight) {
    try {
      stmt = conn.createStatement();
      stmt.execute("update USERS set WEIGHT = " + weight + " where USERNAME = '" + username + "'");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void editHeight(String username, double height) {
    try {
      stmt = conn.createStatement();
      stmt.execute("update USERS set HEIGHT = " + height + " where USERNAME = '" + username + "'");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void editGender(String username, char gender) {
    try {
      stmt = conn.createStatement();
      stmt.execute("update USERS set GENDER = '" + gender + "' where USERNAME = '" + username + "'");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void createAccount(String firstName, String lastName, String username,
      String password) {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + "USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD)" +
          " values ('" + firstName + "', '" + lastName + "', '" + username + "', '" +
          password + "')");
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public String displayGender(String username) {
    try {
      stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery("select * from USERS where USERNAME = '" + username + "'");
      while (results.next()) {
        double weight = results.getDouble(6);
        double height = results.getDouble(7);
        String gender = results.getString(8);
        return gender;
      }
      results.close();
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
    return displayGender(username);
  }

  public int displayAge(String username) {
    try {
      stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery("select * from USERS where USERNAME = '" + username + "'");
      while (results.next()) {
        String firstName = results.getString(1);
        String lastName = results.getString(2);
        String user = results.getString(3);
        String password = results.getString(4);
        int age = results.getInt(5);
        double weight = results.getDouble(6);
        double height = results.getDouble(7);
        String gender = results.getString(8);
        return age;
      }
      results.close();
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
    return displayAge(username);
  }


  public double displayWeight(String username) {
    try {
      stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery("select * from USERS where USERNAME = '" + username + "'");
      while (results.next()) {
        int age = results.getInt(5);
        double weight = results.getDouble(6);
        double height = results.getDouble(7);
        String gender = results.getString(8);
        return weight;
      }
      results.close();
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
    return displayWeight(username);
  }

  public boolean checkIfUsernameExist(String username) {
    boolean usernameExist = false;
    try {
      stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery("select * from USERS where USERNAME = '" + username + "'");
      while (results.next()) {
        String usernameCounter = results.getString("username");
        if (usernameCounter.equalsIgnoreCase(username)){
          usernameExist = true;
        }
      }
      results.close();
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
    return usernameExist;
  }

  public boolean checkIfPasswordIsCorrect(String username, String password) {
    boolean passwordCorrect = false;
    try {
      stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery("select * from USERS where USERNAME = '" + username + "'");
      while (results.next()) {
        String passwordCounter = results.getString("password");
        if (passwordCounter.equals(password)){
          passwordCorrect = true;
        }
      }
      results.close();
      stmt.close();
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
    return passwordCorrect;
  }



//  public void createAccount(String firstName, String lastName, String username,
//      String password, int age, double weight, double height) {
//    try {
//      stmt = conn.createStatement();
//      stmt.execute("insert into " + "USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, "
//          + "AGE, WEIGHT, HEIGHT) " + " values (" +
//          "'" + firstName + "', '" + lastName + "', '" + username + "', '" +
//          password + "', " + age + ", " + weight + ", " + height + ")");
//      stmt.close();
//    } catch (SQLException sqlExcept) {
//      sqlExcept.printStackTrace();
//    }
//  }
  }