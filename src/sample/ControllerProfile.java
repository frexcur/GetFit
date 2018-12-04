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

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerProfile {

  @FXML
  private MenuItem menuHomeButton;

  @FXML
  private ImageView profilePic;

  @FXML
  private Label ageLabel;

  @FXML
  private Label sexLabel;

  @FXML
  private Label heightLabel;

  @FXML
  private Label weightLabel;

  @FXML
  private Label currentWeightLabel;

  @FXML
  private Label goalLabel;

  @FXML
  private Label maintanenceCaloriesLabel;

  @FXML
  private Label activityLevelLabel;


  // As soon as the scene starts labels will be set to show the current users age, gender, height
  public void initialize () {

    int age = database.displayAge(currentUser);
    ageLabel.setText("" + age);

    String sex = database.displayGender(currentUser);
    sexLabel.setText("" + sex);

    double height = database.displayHeight(currentUser);
    heightLabel.setText("" + height);

    double weight = database.displayWeight(currentUser);
    currentWeightLabel.setText("" + weight);

    double goalWeight = 185;
    weightLabel.setText(""+ goalWeight);

    String weightGoal = database.displayGoal(currentUser);
    goalLabel.setText("" + weightGoal);

    String actLevel = database.displayActivityLevel(currentUser);
    activityLevelLabel.setText(actLevel);

    int maintenanceCalories = database.displayGoalCalories(currentUser);
    maintanenceCaloriesLabel.setText("" + maintenanceCalories);

//    if (sex.equalsIgnoreCase("M")){
//      ActivityLevelMen activityM = ActivityLevelMen.valueOf(weightGoal);
//      calc.calculateTDEEMen(weight, height, age, activityM.getValue());
//    }
//    else {
//      ActivityLevelWomen activityW = ActivityLevelWomen.valueOf(weightGoal);
//      calc.calculateTDEEWomen(weight, height, age, activityW.getValue());
//    }
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

  @FXML
  void logoutPressed(ActionEvent event) throws IOException {
    Stage window = Main.getPrimaryStage();
    Parent loginParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
    Scene loginScene = new Scene(loginParent);
    window.setScene(loginScene);
    window.show();
  }

  @FXML
  void diaryPressed(ActionEvent event) throws IOException{
    Stage window = Main.getPrimaryStage();
    Parent diaryParent = FXMLLoader.load(getClass().getResource("Diary.fxml"));
    Scene diaryScene = new Scene(diaryParent);
    window.setScene(diaryScene);
    window.show();
  }

}
