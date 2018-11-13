package sample;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static sample.Main.currentUser;
import static sample.Main.database;

public class ControllerSignup {

  @FXML
  private TextField firstNameText;

  @FXML
  private Label lab;

  @FXML
  private Label lab2;

  @FXML
  private TextField lastNameText;

  @FXML
  private TextField userNameText;

  @FXML
  private TextField passwordText;



  @FXML
  void signupPress(ActionEvent event) throws IOException {
    String firstName = firstNameText.getText();
    String lastName = lastNameText.getText();
    String username = userNameText.getText();
    String password = passwordText.getText();

    if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()) {
      lab.setText("One or more");
      lab2.setText("fields empty");
    }
    else if (database.checkIfUsernameExist(username)) {
      lab.setText("Username exist");
    }
    else if (password.length() > 16) {
      lab.setText("Password must be");
      lab2.setText("16 characters or less");
    }
    else {
      database.createAccount(firstName, lastName, username, password);
      currentUser = username;
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle(null);
      alert.setHeaderText(null);
      alert.setContentText("Account created!");

      alert.showAndWait();

      Parent profileSetupParent = FXMLLoader.load(getClass().getResource("ProfileSetup.fxml"));
      Scene profileSetupScene = new Scene(profileSetupParent);
      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.setScene(profileSetupScene);
      window.show();
    }
  }

}


