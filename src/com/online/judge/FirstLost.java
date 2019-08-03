package com.online.judge;

import java.util.*;

/**
 * #7 第一个缺失正数
 * 难度:★★ 时间限制:1000ms 内存限制:10M
 *
 * 描述
 * 给出一个无序的数列，找出其中缺失的第一个正数，要求复杂度为 O(n) 如：[1,2,0]，第一个缺失为3。
 * 如：[3,4,-1,1]，第一个缺失为2。
 *
 * 输入
 * 1,2,0
 *
 * 输出
 * 3
 *
 * @{author} majintao
 * @{create} 2019-08-02-16:32
 */
public class FirstLost {
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
      Arrays.sort(intInputArray);//排序
      int firstLost = 1;
      boolean flag = false;
      for(int i=0; i< length - 1; i++) {
        if (intInputArray[i] < 0) { //从第一个非负数开始处理
          continue;
        }
        //若存在两个以上的且相邻的两个非负数不连续,则第一个缺失正数为当前值+1
        if (intInputArray[i + 1] - intInputArray[i] != 1) {
          flag = true;
          firstLost = intInputArray[i] + 1;
          break;
        }
      }
      //输入的数组中不存在两个以上的非负数
      //数组最后一位>0,缺失正数为最后一个值+1,否则为-1
      if (!flag && intInputArray[length - 1] > 0) {
        firstLost = intInputArray[length - 1] + 1;
      }
      System.out.println(firstLost);
      // System.out.println("answer");
    }

  }
}
