/********************************************************************************
 * Author: Curiel, Freiddy
 *
 * This is the controller for the initial setup of a profile. This will only be
 * when someone just made a new account
 *
 *
 ********************************************************************************/

package sample;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.remainderUnsigned;
import static sample.Main.activityLevel;
import static sample.Main.activityLevelString;
import static sample.Main.calc;
import static sample.Main.currentUser;
import static sample.Main.database;
import static sample.Main.goal;
import static sample.Main.main;
import static sample.Main.primaryStage;
import static sample.Main.imagePath;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControllerProfileSetup {
//  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//  LocalDateTime now = LocalDateTime.now();

  //These obeservable list are going to be used in a choice box for the user to pick their gender,
  //activity level, and their goal for weight lost or gain

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

  private FileChooser fileChooser;


  private File file;

  private Desktop desktop = Desktop.getDesktop();

  private Image image;

  private FileInputStream fis;

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
  private TextField goalWeightText;

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
    fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(
        //new ExtensionFilter("Text Files", "*.txt"),
        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        //new ExtensionFilter("All Files", "*.*")
    );
  }

  @FXML
  void choiceBoxEntered(MouseEvent event) {
    genderChoice.getSelectionModel().selectedIndexProperty().addListener(
        new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> observable, Number oldValue,
              Number newValue) {
            if (newValue.equals(0)) {
              activityLevelChoice.setItems(activityLevelListMen);
            }
            else {
              activityLevelChoice.setItems(activityLevelListWomen);
            }
          }
        });

  }

  @FXML
  void setChoiceBox() {
    genderChoice.setItems(genderList);
    goalChoice.setItems(goalList);
  }

  @FXML
  void uploadPicPressed(ActionEvent event) throws IOException {

    file = fileChooser.showOpenDialog(primaryStage);
    if (file != null) {
      imagePath = file.toURI().toString();
    }
  }

  @FXML
  void skipPressed(ActionEvent event) throws IOException {
    Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setScene(homeScene);
    window.show();
  }

  /*
  When the submit button is pressed the into from the text field, for certain things like age, are
  converted into an int and put into the database as a new entry. The rest are also stored in the
  same row
   */
  @FXML
  void submitPressed(ActionEvent event) throws IOException {

    double height = Double.parseDouble(heightTextField.getText());
    double goalWeight = Double.parseDouble(goalWeightText.getText());
    double weight = Double.parseDouble(weightTextField.getText());
    int age = parseInt(ageTextField.getText());

    database.editHeight(currentUser, height);
    database.editWeight(currentUser, weight);
    database.editAge(currentUser, age);
    database.editGoalWeight(currentUser, goalWeight);

    if (genderChoice.getSelectionModel().selectedIndexProperty().getValue() == 0){
      database.editGender(currentUser, 'M');
    }
    else {
      database.editGender(currentUser, 'F');
    }

    String gender = database.displayGender(currentUser);

    if (gender.equalsIgnoreCase("M")) {
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 0) {
        activityLevel = 1.2;
        activityLevelString = "Sedentary";
        database.editActivityLevel(currentUser,"Sedentary");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEMen(weight, height, age, activityLevel));
      }
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 1) {
        activityLevel = 1.375;
        activityLevelString = "Lightly Active";
        database.editActivityLevel(currentUser,"Lightly Active");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEMen(weight, height, age, activityLevel));
      }
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 2) {
        activityLevel = 1.55;
        activityLevelString = "Moderately Active";
        database.editActivityLevel(currentUser,"Moderately Active");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEMen(weight, height, age, activityLevel));
      }
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 3) {
        activityLevel = 1.725;
        activityLevelString = "Very Active";
        database.editActivityLevel(currentUser,"Very Active");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEMen(weight, height, age, activityLevel));

      }
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 4) {
        activityLevel = 1.9;
        activityLevelString = "Extremely Active";
        database.editActivityLevel(currentUser,"Extremely Active");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEMen(weight, height, age, activityLevel));
      }
    }
    else {
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 0) {
        activityLevel = 1.1;
        activityLevelString = "Sedentary";
        database.editActivityLevel(currentUser,"Sedentary");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEWomen(weight, height, age, activityLevel));

      }
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 1) {
        activityLevel = 1.275;
        activityLevelString = "Lightly Active";
        database.editActivityLevel(currentUser,"Lightly Active");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEWomen(weight, height, age, activityLevel));
      }
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 2) {
        activityLevel = 1.35;
        activityLevelString = "Moderately Active";
        database.editActivityLevel(currentUser,"Moderately Active");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEWomen(weight, height, age, activityLevel));
      }
      if (activityLevelChoice.getSelectionModel().selectedIndexProperty().getValue() == 3) {
        activityLevel = 1.525;
        activityLevelString = "Very Active";
        database.editActivityLevel(currentUser,"Very Active");
        database.editMainCalories(currentUser, (int)calc.calculateTDEEWomen(weight, height, age, activityLevel));
      }
    }

    int maintenanceCalories = database.displayMaintenanceCalories(currentUser);

    switch (goalChoice.getSelectionModel().selectedIndexProperty().getValue()) {
      case 0:
        goal = "Lose 0.5 pounds per week";
        database.editGoal(currentUser, "Lose 0.5 pounds per week");
        database.editGoalCalories(currentUser, maintenanceCalories - 250);
        break;
      case 1:
        goal = "Gain 0.5 pounds per week";
        database.editGoal(currentUser, "Gain 0.5 pounds per week");
        database.editGoalCalories(currentUser, maintenanceCalories + 250);
        break;
      case 2:
        goal = "Lose 1 pound per week";
        database.editGoal(currentUser, "Lose 1 pound per week");
        database.editGoalCalories(currentUser, maintenanceCalories - 500);
        break;
      case 3:
        goal = "Gain 1 pounds per week";
        database.editGoal(currentUser, "Gain 1 pound per week");
        database.editGoalCalories(currentUser, maintenanceCalories + 500);
        break;
      case 4:
        goal = "Lose 1.5 pounds per week";
        database.editGoal(currentUser, "Lose 1.5 pounds per week");
        database.editGoalCalories(currentUser, maintenanceCalories - 750);
        break;
      case 5:
        goal = "Gain 1.5 pounds per week";
        database.editGoal(currentUser, "Gain 1.5 pounds per week");
        database.editGoalCalories(currentUser, maintenanceCalories + 750);
        break;
      case 6:
        goal = "Lose 2 pounds per week";
        database.editGoal(currentUser, "Lose 2 pounds per week");
        database.editGoalCalories(currentUser, maintenanceCalories - 1000);
        break;
      case 7:
        goal = "Gain 2 pounds per week";
        database.editGoal(currentUser, "Gain 2 pounds per week");
        database.editGoalCalories(currentUser, maintenanceCalories + 1000);
        break;
      default:
        System.out.println("something went wrong");
    }

    Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setScene(homeScene);
    window.show();
  }
}