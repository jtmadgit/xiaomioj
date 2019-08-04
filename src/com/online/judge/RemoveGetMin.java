package com.online.judge;

import java.util.*;

/**
 * #9  移除 K 位得到最小值
 *
 * 描述
 * 有一行由 N 个数字组成的数字字符串，字符串所表示的数是一正整数。移除字符串中的 K 个数字，使剩下的数字是所有可能中最小的。
 * 假设：
 * 字符串的长度一定大于等于 K
 * 字符串不会以 0 开头
 *
 * 输入
 * 一行由 N 个数字组成的数字字符串（0 < N < 20），和一个正整数 K（K < N），两个数据由空格隔开，如：1432219 3。
 *
 * 输出
 * 移除 K 位后可能的最小的数字字符串。 如 1432219 移除 4, 3, 2 这 3 个数字后得到 1219，为所有可能中的最小值。
 *
 * @{author} majintao
 * @{create} 2019-08-4-11:32
 */
public class RemoveGetMin {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(" ");
      if (inputArray.length < 2) {
        System.out.println("输入有误");
        continue;
      }
      String inputStr = inputArray[0];
      Integer removeNum = Integer.parseInt(inputArray[1]);
      String first = inputStr.substring(0, removeNum + 1);
      String last = inputStr.substring(removeNum + 1);
      int min = 9;
      /*
      保证首位数字最小即可，只需处理前removeNum+1位数字，找出其中的最小值
      * */
      for(String item: first.split("")){
        Integer current = Integer.parseInt(item);
        if (min > Integer.parseInt(item)) {
          min = current;
        }
      }
      System.out.println(Integer.parseInt(min + last));
      // System.out.println("answer");
    }

  }
}
