package com.test.exam;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JTMAD
 * @date 2020-05-25-11:06
 */
public class Test {

  public static void main(String args[]){
    System.out.println(1.00 - 9 * 0.10);
    System.out.println(1.00 - 0.10 * 10);
    Collection[] a = new Collection[]{new HashSet()};
    getString(a[0]);
    A[] b = new A[]{new B(), new C()};
    for(int i=0; i< b.length;i++) {
      System.out.println(getString(b[i]));
    }
  }

  public static String getString(Collection c){
    return "collection";
  }

  public static String getString(Set s) {
    return "set";
  }

  public static String getString(A a){
    return "A";
  }

  public static String getString(B b){
    return "B";
  }

  public static String getString(C c) {
    return "C";
  }

  public static String getString(List list){
    return "list";
  }
}

interface A {}

class B implements A{}

class C implements A {}
