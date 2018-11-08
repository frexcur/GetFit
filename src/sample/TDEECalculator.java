package sample;

public class TDEECalculator {

  double calculateTDEEWomen(double weight, double height, int age, double activityLevel) {
    double basalMetabolicRate = ((height * 2.54) * 6.25) + ((weight * 0.453592) * 9.99)
        - (age * 4.92) - 161;
    return basalMetabolicRate * activityLevel;
  }

  double calculateTDEEMen(double weight, double height, int age, double activityLevel) {
    double basalMetabolicRate = ((height * 2.54) * 6.25) + ((weight * 0.453592) * 9.99)
        - (age * 4.92) + 5;
    return basalMetabolicRate * activityLevel;
  }

  public static void main(String[] args) {

    TDEECalculator calculator = new TDEECalculator();
    double calories = calculator.calculateTDEEMen(180, 70, 20, ActivityLevelMen.SEDENTARY.getValue());
    System.out.println((int)calories);
  }

}
