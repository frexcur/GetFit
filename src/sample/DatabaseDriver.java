/********************************************************************************
 * Author: Curiel, Freiddy
 *
 * This class is used for testing databases functions and making sure the methods
 * are actually executed
 *
 *
 ********************************************************************************/

package sample;

public class DatabaseDriver {

  public static void main(String[] args) {
    DBTest db = new DBTest();
    db.createConnection();
    int age = db.displayAge("frexcur");
    System.out.println(age);
    double weight = db.displayWeight("frexcur");
    System.out.println(weight);

    if (db.checkIfUsernameExist("fred")) {
      System.out.println("account exist");
    }
    else {
      System.out.println("wrong username or password");
    }

    if (db.checkIfPasswordIsCorrect("frexcur", "passher")){
      System.out.println("correct password");
    }
    else {
      System.out.println("wrong username or password");
    }

    db.editAge("frexcur", 30);
    db.editWeight("frexcur", 400);
    db.editGender("frexcur", 'M');
    weight = db.displayWeight("JohnD");
    System.out.println(weight);
    db.insertUsername("Brandon");
    db.editHeight("Brandon", 70);
  }

}
