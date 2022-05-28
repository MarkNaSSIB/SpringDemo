package com.NaSSIB.spring.SpringDemo;

import java.util.Set;

public class Validation {

  public static boolean validEmail(String email) {
    if (email.contains("@")) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean populatedSet(Set<String> set) {

    if (set.size() > 0) {
      return true;
    } else {
      return false;
    }
  }


}
