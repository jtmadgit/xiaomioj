package com.online.judge;

import java.util.*;

/**
 * #14  在一个有序的经过旋转的数组里查找一个数(indexOf)
 *
 * 描述
 * 假设一个有序的数组，经过未知次数的旋转（例如0 1 2 4 5 6 7 被旋转成 4 5 6 7 0 1 2），
 * 从中查找一个目标值，如果存在，返回其下标，不存在，返回-1。注：假设数组无重复数字
 *
 * 输入
 * 输入一个有序经过旋转的数组和要查找的目标数字，数组中各数字用“逗号”分隔，数组和目标数字用“空格”分隔
 *
 * 输出
 * 一个整数，表示该目标数字的下标（不存在返回-1）
 *
 * @{author} majintao
 * @{create} 2019-08-05-17:17
 */
public class fineOneFromArray {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(" ");
      String[] resource = inputArray[0].split(",");
      int index = -1;
      for(int i=0; i< resource.length; i++){
        if(resource[i].equals(inputArray[1])) {
          index =i;
          break;
        }
      }
      System.out.println(index);
      // System.out.println("answer");
    }

  }
}
