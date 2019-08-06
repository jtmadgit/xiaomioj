package com.online.judge;

import java.util.*;

/**
 * #15 和为零的三元组
 * 描述
 * 给出一个整数数组, 数组中是否存在任意 3 个数 a, b, c 满足 a + b + c = 0?
 * 找出数组中所有满足以上条件的三元组，最后输出这些三元组的个数（包含相同元素的三元组只计算一次）。
 *
 * 输入
 * 一个包含多个整数（正或负）的字符串，每个整数之间用逗号（,）分隔，如：-1,0,1,2,-1,-4。
 *
 * 输出
 * 输入满足加和结果正好等于 0 的三元组的个数，如对于 -1,0,1,2,-1,-4 有 [-1, 0, 1] 和 [-1, -1, 2]，所以输出 2
 *
 * @{author} majintao
 * @{create} 2019-08-06-8:56
 */
public class SumZeroThree {
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
      List<String> resultList = new ArrayList();
      int count = 0;
      /*
      此为暴力破解方式,即列出所有的三元素组合,判断相加是否为零,算法耗时,不推荐
      * */
      for(int i=0;i<length;i++){
        for(int j=i+1;j<length;j++){
          for(int k=j+1;k<length;k++){
            if(intInputArray[i] + intInputArray[j] + intInputArray[k] == 0){
              String zeroStr = intInputArray[i] + "," + intInputArray[j] + "," + intInputArray[k];
              if(!resultList.contains(zeroStr)){
                resultList.add(zeroStr);
                count++;
              }
            }
          }
        }
      }
      System.out.println(count);
      // System.out.println("answer");
    }

  }
}
