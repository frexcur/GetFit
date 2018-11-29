package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Food {
  public final SimpleStringProperty name;
  public final SimpleIntegerProperty calories;
  public final SimpleDoubleProperty servings;
  public final double caloriesWithServings;
  public final SimpleDoubleProperty fat;
  public final SimpleDoubleProperty proteins;
  public final SimpleDoubleProperty carbs;


  public Food(String name, int calories, double servings, double fat, double proteins, double carbs) {
    this.name = new SimpleStringProperty(name);
    this.calories = new SimpleIntegerProperty(calories);
    this.servings = new SimpleDoubleProperty(servings);
    this.fat = new SimpleDoubleProperty(fat);
    this.proteins = new SimpleDoubleProperty(proteins);
    this.carbs = new SimpleDoubleProperty(carbs);
    this.caloriesWithServings = calories * servings;

  }

  public String getName() {
    return name.get();
  }

  public SimpleStringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public int getCalories() {
    return calories.get();
  }

  public SimpleIntegerProperty caloriesProperty() {
    return calories;
  }

  public void setCalories(int calories) {
    this.calories.set(calories);
  }

  public double getServings() {
    return servings.get();
  }

  public SimpleDoubleProperty servingsProperty() {
    return servings;
  }

  public void setServings(double servings) {
    this.servings.set(servings);
  }

  public double getFat() {
    return fat.get();
  }

  public SimpleDoubleProperty fatProperty() {
    return fat;
  }

  public void setFat(double fat) {
    this.fat.set(fat);
  }

  public double getProteins() {
    return proteins.get();
  }

  public SimpleDoubleProperty proteinsProperty() {
    return proteins;
  }

  public void setProteins(double proteins) {
    this.proteins.set(proteins);
  }

  public double getCarbs() {
    return carbs.get();
  }

  public SimpleDoubleProperty carbsProperty() {
    return carbs;
  }

  public void setCarbs(double carbs) {
    this.carbs.set(carbs);
  }
}
