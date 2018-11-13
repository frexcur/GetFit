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
import javafx.stage.Stage;

public class ControllerHome {

  @FXML
  private MenuItem profileMenuButton;

  public void initialize (){
  }


  @FXML
  void profileMenuPressed(ActionEvent event) throws IOException {
    Parent profileParent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
    Scene profileScene = new Scene(profileParent);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(profileScene);
    window.show();

  }

}
