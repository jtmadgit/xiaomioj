package com.online.judge;

import java.util.Scanner;

/**
 * #1 A+B
 *
 * 难度:★ 时间限制:2000ms 内存限制:128M
 *
 * 描述
 * 给出两个非负数 aa 和 bb，输出 a+ba+b 的结果
 *
 * 输入
 * 多组输入。
 * 包含两个非负数 aa 和 bb，以空格分隔；aa 和 bb 保证小于 2^{32}2
 *
 * 输出
 * 你的输出是对一行数据处理的结果，也即 a+ba+b 的结果.
 *
 * @{author} majintao
 * @{create} 2019-07-26-9:09
 */
public class SumA_B {

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(" ");
      long sum = 0L;
      try{
        for(String item: inputArray){
          sum += Long.valueOf(item);
        }
        System.out.println(sum);
      }catch(Exception e){
        e.printStackTrace();
        System.out.println("输入数据有误");
      }
    }

  }
}
