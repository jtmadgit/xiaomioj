package com.online.judge;

import java.util.*;

/**
 * #10 爬楼梯 (经典递归)
 *
 * 描述
 * 在你面前有一个n阶的楼梯，你一步只能上1阶或2阶。 请问计算出你可以采用多少种不同的方式爬完这个楼梯。
 *
 * 输入
 * 一个正整数，表示这个楼梯一共有多少阶
 *
 * 输出
 * 一个正整数，表示有多少种不同的方式爬完这个楼梯
 *
 * @{author} issuser
 * @{create} 2019-08-02-18:12
 */
public class ClimbStairs {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      int input = Integer.valueOf(line);
      int count = climbStairs(input);
      System.out.println(count);
      // System.out.println("answer");
    }

  }

  public static int climbStairs(int staris){
    if (staris == 1) {
     return 1;
    } if (staris == 2) {
      return 2;
    } else {
      return climbStairs(staris -1) + climbStairs(staris -2);
    }
  }
}
