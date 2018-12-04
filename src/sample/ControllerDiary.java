package sample;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class ControllerDiary {

  static double breakfastTotalCalories = 0;
  static double dinnerTotalCalories = 0;
  static double lunchTotalCalories = 0;
  static double totalCalories= 0;
  static int water = 0;

  static ObservableList <Food> breakfast =
      FXCollections.observableArrayList();

  static ObservableList <Food> lunch =
      FXCollections.observableArrayList();

  static ObservableList <Food> dinner =
      FXCollections.observableArrayList();

  static ObservableList <Food> foodChoice =
      FXCollections.observableArrayList();

  static ObservableList <Food> foods =
      FXCollections.observableArrayList(new Food("Broccoli", 150, 2, 4, 5,
          5));

  @FXML
  private TextField nameText;

  @FXML
  private TextField caloriesText;

  @FXML
  private TextField servingsText;

  @FXML
  private TextField fatText;

  @FXML
  private TextField proteinText;

  @FXML
  private TextField carbsText;

  @FXML
  private Label waterLabel;

  @FXML
  private Label breakfastCaloriesLabel;

  @FXML
  private Label lunchCaloriesLabel;

  @FXML
  private Label dinnerCaloriesLabel;

  @FXML
  private Label totalCaloriesLabel;

  @FXML
  private TableView<Food> breakfastTable;

  @FXML
  private TableColumn<Food, String> breakfastName;

  @FXML
  private TableColumn<Food, Integer> breakfastCalories;

  @FXML
  private TableColumn<Food, Double> breakfastServings;

  @FXML
  private TableColumn<Food, Double> breakfastFat;

  @FXML
  private TableColumn<Food, Double> breakfastProteins;

  @FXML
  private TableColumn<Food, Double> breakfastCarbs;

  @FXML
  private TableView<Food> lunchTable;

  @FXML
  private TableColumn<Food, String> lunchName;

  @FXML
  private TableColumn<Food, Integer> lunchCalories;

  @FXML
  private TableColumn<Food, Double> lunchServings;

  @FXML
  private TableColumn<Food, Double> lunchFat;

  @FXML
  private TableColumn<Food, Double> lunchProteins;

  @FXML
  private TableColumn<Food, Double> lunchCarbs;

  @FXML
  private TableView<Food> dinnerTable;

  @FXML
  private TableColumn<Food, String> dinnerName;

  @FXML
  private TableColumn<Food, Integer> dinnerCalories;

  @FXML
  private TableColumn<Food, Double> dinnerServings;

  @FXML
  private TableColumn<Food, Double> dinnerFat;

  @FXML
  private TableColumn<Food, Double> dinnerProteins;

  @FXML
  private TableColumn<Food, Double> dinnerCarbs;

  @FXML
  public void initialize () {

    breakfastName.setCellValueFactory(
        new PropertyValueFactory<Food,String>("name")
    );
    breakfastCalories.setCellValueFactory(
        new PropertyValueFactory<Food, Integer>("calories")
    );
    breakfastServings.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("servings")
    );
    breakfastFat.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("fat")
    );
    breakfastProteins.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("proteins")
    );
    breakfastCarbs.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("carbs")
    );


    lunchName.setCellValueFactory(
        new PropertyValueFactory<Food,String>("name")
    );
    lunchCalories.setCellValueFactory(
        new PropertyValueFactory<Food, Integer>("calories")
    );
    lunchServings.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("servings")
    );
    lunchFat.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("fat")
    );
    lunchProteins.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("proteins")
    );
    lunchCarbs.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("carbs")
    );

    dinnerName.setCellValueFactory(
        new PropertyValueFactory<Food,String>("name")
    );
    dinnerCalories.setCellValueFactory(
        new PropertyValueFactory<Food, Integer>("calories")
    );
    dinnerServings.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("servings")
    );
    dinnerFat.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("fat")
    );
    dinnerProteins.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("proteins")
    );
    dinnerCarbs.setCellValueFactory(
        new PropertyValueFactory<Food, Double>("carbs")
    );
    breakfastTable.setItems(breakfast);
    lunchTable.setItems(lunch);
    dinnerTable.setItems(dinner);

    breakfastCaloriesLabel.setText("" + breakfastTotalCalories);
    lunchCaloriesLabel.setText("" + lunchTotalCalories);
    dinnerCaloriesLabel.setText("" + dinnerTotalCalories);
    totalCaloriesLabel.setText("Total calories: " + totalCalories);
    waterLabel.setText("Cups of water: " + water);

  }

  @FXML
  void addToBreakfast(ActionEvent event) {
    String name = nameText.getText();
    int calories = parseInt(caloriesText.getText());
    double servings = Double.parseDouble(servingsText.getText());
    double fat = Double.parseDouble(fatText.getText());
    double protein = Double.parseDouble(proteinText.getText());
    double carbs = Double.parseDouble(carbsText.getText());

    double foodCalories = calories * servings;

    breakfastTotalCalories += foodCalories;
    totalCalories += foodCalories;
    breakfastCaloriesLabel.setText("" + breakfastTotalCalories);
    totalCaloriesLabel.setText("Total calories: " + totalCalories);

    Food food1 = new Food (name, calories, servings, fat, protein, carbs);
    foods.add(food1);
    breakfast.add(food1);
    breakfastTable.setItems(breakfast);

    nameText.clear();
    caloriesText.clear();
    servingsText.clear();
    fatText.clear();
    proteinText.clear();
    carbsText.clear();

  }


  @FXML
  void addToDinner(ActionEvent event) {
    String name = nameText.getText();
    int calories = parseInt(caloriesText.getText());
    double servings = Double.parseDouble(servingsText.getText());
    double fat = Double.parseDouble(fatText.getText());
    double protein = Double.parseDouble(proteinText.getText());
    double carbs = Double.parseDouble(carbsText.getText());

    double foodCalories = calories * servings;

    dinnerTotalCalories += foodCalories;
    totalCalories += foodCalories;
    dinnerCaloriesLabel.setText("" + dinnerTotalCalories);
    totalCaloriesLabel.setText("Total calories: " + totalCalories);

    Food food1 = new Food (name, calories, servings, fat, protein, carbs);
    foods.add(food1);
    dinner.add(food1);
    dinnerTable.setItems(dinner);


    nameText.clear();
    caloriesText.clear();
    servingsText.clear();
    fatText.clear();
    proteinText.clear();
    carbsText.clear();
  }

  @FXML
  void addToLunch(ActionEvent event) {
    String name = nameText.getText();
    int calories = parseInt(caloriesText.getText());
    double servings = Double.parseDouble(servingsText.getText());
    double fat = Double.parseDouble(fatText.getText());
    double protein = Double.parseDouble(proteinText.getText());
    double carbs = Double.parseDouble(carbsText.getText());

    double foodCalories = calories * servings;

    lunchTotalCalories += foodCalories;
    totalCalories += foodCalories;
    lunchCaloriesLabel.setText("" + lunchTotalCalories);
    totalCaloriesLabel.setText("Total calories: " + totalCalories);

    Food food1 = new Food (name, calories, servings, fat, protein, carbs);
    foods.add(food1);
    lunch.add(food1);
    lunchTable.setItems(lunch);

    nameText.clear();
    caloriesText.clear();
    servingsText.clear();
    fatText.clear();
    proteinText.clear();
    carbsText.clear();
  }

  @FXML
  void addWater(ActionEvent event) {
    water++;
    waterLabel.setText("Cups of water: " + water);
  }
  @FXML
  void homePressed(ActionEvent event) throws IOException {
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
  void profilePressed(ActionEvent event) throws IOException {
    Stage window = Main.getPrimaryStage();
    Parent profileParent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
    Scene profileScene = new Scene(profileParent);
    window.setScene(profileScene);
    window.show();
  }
}
