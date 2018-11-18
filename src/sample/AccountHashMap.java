/********************************************************************************
 * Author: Curiel, Freiddy
 *
 * Another class currently not being used since the implementation of the database
 *
 *
 ********************************************************************************/

package sample;

import java.util.HashMap;

public class AccountHashMap<K, V> extends HashMap<K, V> {
  String username;
  String password;

  AccountHashMap (){
    username = "Default";
    password = "Default";
  }

  AccountHashMap (AccountHashMap h1, String username, String password) {
    this.username = username;
    this.password = password;
    h1.put(username, password);
  }
  /*
  Will print out every key and value inside the hashmap
   */
  void printMap(AccountHashMap h1) {
    h1.forEach((key, value) -> System.out.println("Key: " + key + " and value: " +  value +'\n'));
  }

  /*
  Boolean method that checks if the username exist already in the hashmap. If it does it will return
  true. If not it will put the username and password into the hashmap and return false.
   */
  boolean compareIfExist(AccountHashMap h1, String userName, String password) {
    if (h1.containsKey(userName)) {
      return true;
    } else {
    h1.put(userName,password);
    return false;
    }
  }
}
