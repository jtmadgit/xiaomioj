package com.tree;

import java.util.Objects;

/**
 * @author JTMAD
 * @date 2020-05-25-15:18
 */
public class ValidateTree {

  public static void main(String args[]) {
    System.out.println(validate(new Integer[]{5,6}));
  }

  public static boolean validate(Integer[] ints){
    if (ints.length == 1) { return true;}
    for(int i=1;i<ints.length;i++) {
      Integer temp = ints[i];
      if (Objects.isNull(temp)) {
        continue;
      }
      int parentIndex = (i - 1) / 2;
      if (i%2 == 1) {
        if (temp >= ints[parentIndex]) {
        return false;
        }
      } else {
        if (temp <= ints[parentIndex]) {
          return false;
        }
      }
    }
    return true;
  }
}
