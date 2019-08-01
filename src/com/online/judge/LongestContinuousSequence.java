package com.online.judge;

import java.util.*;
import java.util.stream.Collectors;

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
      List<String> sort = Arrays.stream(inputArray)
          .sorted((current, next) -> Integer.valueOf(current) - Integer.valueOf(next))
          .collect(Collectors.toList());
      int longestCount = 1;
      int currenCount = 1;
      for(int i=0; i<sort.size()-1;i++){
        if(Integer.valueOf(sort.get(i+1)) - Integer.valueOf(sort.get(i)) == 1){
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
