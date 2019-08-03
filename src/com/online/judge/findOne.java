package com.online.judge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 给出N个数字。其中仅有一个数字出现过一次，其他数字均出现过两次，
 * 找出这个出现且只出现过一次的数字。要求时间和空间复杂度最小。
 *
 * 输入
 * 输入多个数字，每个数字以空格分开。数字数量 N < 20，输入数字的最大值小于 256.
 *
 * 输出
 * 输出内容为只出现过唯一一次的数字
 *
 * @{author} majintao
 * @{create} 2019-07-31-17:08
 */
public class findOne {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;

    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(" ");
      /*Map<String, List<String>> groupResult = Arrays.stream(inputArray).collect(Collectors.groupingBy(String::valueOf));
      List<List<String>> find = groupResult.values().stream().filter( array -> array.size() == 1).collect(Collectors.toList());
      System.out.println(find.get(0).get(0));*/
      List<String> result = new ArrayList();
      for(String item : inputArray){
        if (result.contains(item)) {
          result.remove(item);
        } else {
          result.add(item);
        }
      }
      System.out.println(result.get(0));
    }

  }
}
