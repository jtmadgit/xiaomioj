package com.algorithm.illustration;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 递归
 *
 * @{author} majitao
 * @{create} 2019-12-05-9:36
 */
public class Recursive {

  private static int  step = 0;

  public static void main(String[] args) {
    //Integer[] integers = new Integer[]{2, 4, 3, 5, 9, 8, 1};
    //System.out.println(sum(integers, integers.length));
    hanoi(10, "A", "B", "C");
  }

  /**
   * 递归求数组和
   */
  private static int sum(Integer[] integers, int length) {
    if (length == 0) {
      return 0;
    } else {
      int index = integers.length - length;
      int first = integers[index];
      integers[index] = 0;
      length--;
      return first + sum(integers, length);
    }
  }

  ;

  private static Integer[] quickSort(Integer[] integers) {
    if (integers.length < 2) {
      return integers;
    } else if (integers.length == 2) {
      if (integers[0] > integers[1]) {
        int temp = integers[0];
        integers[0] = integers[1];
        integers[1] = temp;
      }
      return integers;
    } else {
      int standard = integers[0];
      Arrays.stream(integers).filter(item -> item >= standard).collect(Collectors.toList());
      String larger = "";
      String smaller = "";
      for (int i = 1; i < integers.length; i++) {
        if (standard >= integers[i]) {
          larger += integers[i] + ",";
        } else {
          smaller += integers[i] + ",";
        }
      }
    }
    return null;
  }

  private static void hanoi(int n, String start, String destination, String assist){
    if (n == 1){
      hanoiMove(1, start, destination);
    }else if(n > 1){
      hanoi(n - 1, start, destination, assist);
      hanoiMove(n, start, assist);
      hanoi(n - 1, assist, destination, start);
    }
  }

  private static void hanoiMove(int n, String start, String end){
    ++step;
    System.out.println("第" + step + "步:" + n + ": " + start + "->" + end);
  }
}
