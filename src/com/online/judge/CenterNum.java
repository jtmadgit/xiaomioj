package com.online.judge;

import java.util.*;

/**
 * 旋转数(即中中间数)
 *
 *描述
 * 给出一个有序数列随机旋转之后的数列，如原有序数列为：[0,1,2,4,5,6,7] ，旋转之后为[4,5,6,7,0,1,2]。
 * 假定数列中无重复元素，且数列长度为奇数。 求出旋转数列的中间值。如数列[4,5,6,7,0,1,2]的中间值为4。
 *
 * 输入
 * 4,5,6,7,0,1,2
 *
 * 输出
 * 4
 * @{author} majintao
 * @{create} 2019-08-01-19:18
 */
public class CenterNum {
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
      System.out.println(intInputArray[(length - 1) / 2]);
      // System.out.println("answer");
    }

  }
}
