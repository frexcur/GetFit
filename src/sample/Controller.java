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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {


  public AccountHashMap<String, String> accountHash = new AccountHashMap<>();




  @FXML
  private TextField userNameText;

  @FXML
  private PasswordField passwordText;

  @FXML
  private Button loginButton;

  @FXML
  private Label lab;

  @FXML
  private Label passwordWrongLabel;

  @FXML
  void loginPress(ActionEvent event) throws IOException {
    accountHash.put("Fred", "password");
    String username = userNameText.getText();
    String password = passwordText.getText();

    if (accountHash != null) {
      if (accountHash.containsKey(username)) {
        if ((accountHash.get(username)).equals(password)) {
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle(null);
          alert.setHeaderText(null);
          alert.setContentText("Login successful!");

          alert.showAndWait();
          Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
          Scene homeScene = new Scene(homeParent);
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          window.setScene(homeScene);
          window.show();
        }

      }
      else {
        lab.setText("Wrong username");
        passwordWrongLabel.setText("or password");
      }
    } else {
      lab.setText("Wrong username");
      passwordWrongLabel.setText("or password");
    }

  }



  @FXML
  void signupPress(ActionEvent event) throws IOException {
    Parent signUpParent = FXMLLoader.load(getClass().getResource("Signup.fxml"));
    Scene signUpScene = new Scene(signUpParent);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setScene(signUpScene);
    window.show();

  }

}
