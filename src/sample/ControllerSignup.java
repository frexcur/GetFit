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

public class ControllerSignup {


  AccountHashMap<String, String> accountHash = new AccountHashMap<>();

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

    Account a1 = new Account(firstName, lastName, username, password);
    accountHash.put("freddy", password);
    accountHash.put("Fred", password);

    if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()) {
      lab.setText("One or more");
      lab2.setText("fields empty");
    } else if (accountHash.compareIfExist(accountHash, username, password)) {
      lab.setText("Username exist");
    } else {

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


