package com.online.judge;

import java.util.*;

/**
 * 最长连续数组
 *
 *描述
 * 输入一个乱序的连续数列，输出其中最长连续数列长度，要求算法复杂度为 O(n) 。
 *
 * 输入
 * 54,55,300,12,56
 *
 * 输出
 * 3
 * @{author} majintao
 * @{create} 2019-08-01-16:35
 */
public class LongestContinuousSequence {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(",");
      int length = inputArray.length;
      Integer[] intInputArray = new Integer[length];
      for (int i=0; i<length; i++) {
        intInputArray[i] = Integer.valueOf(inputArray[i]);
      }
      Arrays.sort(intInputArray);
      int longestCount = 1;
      int currenCount = 1;
      for(int i=0; i<length-1;i++){
        if(intInputArray[i+1] - intInputArray[i] == 1){
          currenCount++;
        }else if(currenCount >= longestCount){
          longestCount = currenCount;
          currenCount = 1;
        }
      }
      if (currenCount != 1 ) {
        longestCount = currenCount;
      }
      System.out.println(longestCount);
    }

  }
}
