package com.algorithm.illustration;

/**
 * 二分法
 *
 * @{author} issuser
 * @{create} 2019-12-04-15:18
 */
public class Dichotomy {

  public static void main(String[] args) {
    Integer[] integers = new Integer[]{1,3,5,7,8,9,10};
    System.out.println(binarySearch(integers, 33));
  }

  public static Integer binarySearch(Integer[] integers, Integer findInt){
    int start = 0;
    int end = integers.length - 1;
    int mid, guess;
    while (end >= start) {
      mid = (start + end) / 2;
      guess = integers[mid];
      if (guess > findInt) {
        end = mid - 1;
      } else if (guess < findInt) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
