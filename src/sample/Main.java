package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static String currentUser;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    primaryStage.setTitle("Get Lit, Get Fit");
    primaryStage.setScene(new Scene(root, 620, 400));
    primaryStage.show();


  }


  public static void main(String[] args) {
    launch(args);
  }
}