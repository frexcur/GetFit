package sample;

import static java.lang.Integer.parseInt;
import static sample.Main.currentUser;
import static sample.Main.database;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerProfileSetup {
//  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//  LocalDateTime now = LocalDateTime.now();

  ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");

  ObservableList<String> goalList = FXCollections.observableArrayList("Lose 0.5 pounds per week",
      "Gain 0.5 pounds per week", "Lose 1 pound per week", "Gain 1 pound per week", "Lose 1.5 pounds "
          + "per week", "Gain 1.5 pounds per week", "Lose 2 pounds per week", "Gain 2 pounds per week");

  ObservableList<String> activityLevelListMen = FXCollections.observableArrayList("Sedentary "
      + "(little to no exercise)", "Lightly Active (light exercise/sports 1-3 days/week)", "Moderately Active "
      + "(moderate exercise/sports 3-5 days/week)", "Very Active (hard exercise/sports 6-7 days a week)",
      "Extremely Active (very heavy exercise/ physical job/ training twice a day");

  ObservableList<String> activityLevelListWomen = FXCollections.observableArrayList("Sedentary "
      + "(little to no exercise)", "Lightly Active (light exercise/sports 1-3 days/week)", "Moderately Active "
      + "(moderate exercise/sports 3-5 days/week)", "Very Active (hard exercise/sports 6-7 days a week)");

  @FXML
  private ChoiceBox genderChoice;

  @FXML
  private ChoiceBox goalChoice;

  @FXML
  private ChoiceBox activityLevelChoice;

  @FXML
  private TextField ageTextField;

  @FXML
  private TextField heightTextField;

  @FXML
  private TextField weightTextField;

  @FXML
  private Button submitButton;

  @FXML
  private Button skipButton;

  @FXML
  private Label timeLabel;

  public void initialize (){
    setChoiceBox();
  }

  @FXML
  void setChoiceBox() {
    genderChoice.setItems(genderList);
    goalChoice.setItems(goalList);
    if (genderChoice.equals("Male")) {
      activityLevelChoice.setItems(activityLevelListMen);
    }
    else {
      activityLevelChoice.setItems(activityLevelListWomen);
    }
  }

  @FXML
  void skipPressed(ActionEvent event) {
  }

  @FXML
  void submitPressed(ActionEvent event) throws IOException {
    double height = parseInt(heightTextField.getText());
    double weight = parseInt(weightTextField.getText());
    int age = parseInt(ageTextField.getText());
    database.editHeight(currentUser, height);
    database.editWeight(currentUser, weight);
    database.editAge(currentUser, age);
    if (genderChoice.equals("Male")){
      database.editGender(currentUser, 'M');
    }
    else {
      database.editGender(currentUser, 'F');
    }

    Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setScene(homeScene);
    window.show();
  }
}