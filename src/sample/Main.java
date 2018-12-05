/********************************************************************************
 * Author: Curiel, Freiddy
 *
 * Main method of the application. Multiple static variables are initiated here
 * to be used later in the program.
 *
 *
 ********************************************************************************/

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static String currentUser;
  static DBTest database = new DBTest();
  public static Stage primaryStage;
  public static double activityLevel;
  public static String activityLevelString;
  public static String goal;
  static String imagePath;
  public static TDEECalculator calc = new TDEECalculator();

  @Override
  public void start(Stage primaryStage) throws Exception {
    database.createConnection();
    setPrimaryStage(primaryStage);
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    primaryStage.setTitle("Get Lit, Get Fit");
    primaryStage.setScene(new Scene(root, 620, 400));
    primaryStage.show();
  }

  private void setPrimaryStage(Stage primaryStage) {
    Main.primaryStage = primaryStage;
  }

  public static Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void main(String[] args) {
    launch(args);
  }
}