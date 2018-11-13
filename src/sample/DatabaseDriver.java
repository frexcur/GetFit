package sample;

public class DatabaseDriver {

  public static void main(String[] args) {
    DBTest db = new DBTest();
    db.createConnection();
    db.displayAge("frexcur");
    db.editAge("frexcur", 30);
    db.editWeight("frexcur", 400);
    db.editGender("frexcur", 'M');
  }

}
