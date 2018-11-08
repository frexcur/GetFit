package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Account implements AccountInfo {

  private String userName;
  private String password;
  private String firstName;
  private String lastName;
  private int height;
  private int weight;
  private int age;
  private Gender gender;


  Account() {
    userName = "Default";
    password = "Default";
    firstName = "John";
    lastName = "Doe";
    height = 0;
    weight = 0;

  }

  Account(String userName, String password, String firstName, String lastName) {
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  Account(String userName, String password, String firstName, String lastName, int height,
      int weight, int age) {
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.height = height;
    this.weight = weight;
    this.age = age;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void printInfo() {
    System.out.println("Username: " + userName + ". Password: " + password + '\n' +
        "Last name, first name: " + lastName + ", " + firstName + '\n' +
        "Height: " + height + " inches" + '\n' + "Weight: " + weight + " pounds");
  }
}
