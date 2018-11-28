/********************************************************************************
 * Author: Curiel, Freiddy
 *
 * This controller is for the home screen of the program. Still not fully
 * implemented.
 *
 *
 ********************************************************************************/

package sample;

import static sample.Main.currentUser;
import static sample.Main.database;
import static sample.Main.goal;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ControllerHome {

  @FXML
  private MenuItem profileMenuButton;

  @FXML
  private Label goalCaloriesLabel;

  @FXML
  private Label foodEatenLabel;

  @FXML
  private Label remainingCaloriesLabel;

  @FXML
  private WebView youtubeView;

  public void initialize (){
    int goalCalories = database.displayGoalCalories(currentUser);
    int foodCalories = 0;
    goalCaloriesLabel.setText("" + goalCalories);
    foodEatenLabel.setText("" + foodCalories);
    remainingCaloriesLabel.setText("" + (goalCalories - foodCalories));
    youtubeView.getEngine().load(
        "https://www.youtube.com/embed/XQp9krhzdXc");
  }


  @FXML
  void profileMenuPressed(ActionEvent event) throws IOException {
    Stage window = Main.getPrimaryStage();
    Parent profileParent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
    Scene profileScene = new Scene(profileParent);
    window.setScene(profileScene);
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

}
