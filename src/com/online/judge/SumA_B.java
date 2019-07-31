package com.online.judge;

import java.util.Scanner;

/**
 * 给出两个非负数 aa 和 bb，输出 a+ba+b 的结果
 *
 * @{author} issuser
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
