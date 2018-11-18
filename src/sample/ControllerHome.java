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
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ControllerHome {

  @FXML
  private MenuItem profileMenuButton;

  @FXML
  private WebView youtubeView;

  public void initialize (){
  }


  @FXML
  void profileMenuPressed(ActionEvent event) throws IOException {
    Stage window = Main.getPrimaryStage();
    Parent profileParent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
    Scene profileScene = new Scene(profileParent);
    window.setScene(profileScene);
    window.show();
  }

}
