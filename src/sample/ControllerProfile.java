/********************************************************************************
 * Author: Curiel, Freiddy
 *
 * This is the controller for the profile scene where users will get to see and
 * edit their personal info such as height, weight, and age
 *
 *
 ********************************************************************************/

package sample;

import static sample.Main.currentUser;
import static sample.Main.database;
import static sample.Main.primaryStage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControllerProfile {

  @FXML
  private MenuItem menuHomeButton;

  @FXML
  private Label ageLabel;

  @FXML
  private Label sexLabel;

  @FXML
  private Label heightLabel;


  // As soon as the scene starts labels will be set to show the current users age, gender, height
  public void initialize () {
    int age = database.displayAge(currentUser);
    ageLabel.setText("" + age);

    String sex = database.displayGender(currentUser);
    sexLabel.setText("" + sex);

    double height = database.displayHeight(currentUser);
    heightLabel.setText("" + height + " inches");
  }

  // Takes you back to the home screen
  @FXML
  void menuHomeButtonPressed(ActionEvent event) throws IOException {
    Stage window = Main.getPrimaryStage();
    Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
    Scene homeScene = new Scene(homeParent);
    window.setScene(homeScene);
    window.show();
  }
}
