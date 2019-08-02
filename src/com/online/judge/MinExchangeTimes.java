package com.online.judge;

import java.util.*;

/**
 * #8 最少交换次数
 *
 * 难度: ★★★★ 时间限制:1000ms 内存限制: 10M
 *
 * 描述
 * 给出一个无序数列，每次只能交换相邻两个元素，求将原数列变成递增数列的最少交换次数。
 * 如：数列：2,3,1，交换3和1后变成：2,1,3；交换1和2之后变成：1,2,3。总共交换2次。
 *
 * 输入
 * 逗号隔开的正整数数列
 *
 * 输出
 * 正整数
 *
 * @{author} majintao
 * @{create} 2019-08-02-16:57
 */
public class MinExchangeTimes {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(",");
      int length = inputArray.length;
      int minExchangeTimes = 0;
      Integer[] intInputArray = new Integer[length];
      for (int i=0; i<length; i++) {
        intInputArray[i] = Integer.valueOf(inputArray[i]);
      }

      System.out.println(minExchangeTimes);
      // System.out.println("answer");
    }

  }
}
