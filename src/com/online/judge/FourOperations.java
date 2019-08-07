package com.online.judge;

import java.util.*;

/**
 * #16 四则运算
 *
 *  描述
 *  实现一个算法，可以进行任意非负整数的加减乘除组合四则运算。
 *  请注意运算符的优先级。
 *
 *  输入
 *  请输入一行算式，使用空格分隔数字与运算符。
 *  数字为任意非负整数，运算符为+ - * /，不考虑括号。
 *
 *  输出
 *  输出算式的运算结果。如果是小数，请向下取整（包含中间步骤结果）。 如果出现“除0异常”，输出err。
 *
 * @{author} majintao
 * @{create} 2019-08-07-9:30
 */
public class FourOperations {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      if(line.indexOf("/ 0") != -1){
        System.out.println("err");
        continue;
      }
      line = line.replaceAll("-", "+ -");
      String[] inputArray = line.split("\\+");
      int result = 0;
      for(int i=0; i<inputArray.length; i++){
        String current = inputArray[i].trim();
        if (current.indexOf("*") != -1 || current.indexOf("/") != -1) {
          int symbol = 1;
          if (current.startsWith("-")) {
            symbol = -1;
            current = current.substring(1);
          }
          String[] temp = current.trim().split(" ");
          int tempCount = 0;
          for (int j=0; j<temp.length; j++) {
            if ((int)temp[j].charAt(0) >= 48) {
              int tempInt = Integer.parseInt(temp[j].trim());
              if (j-1 >= 0) {
                if (temp[j-1].equals("*")) {
                  tempCount *= tempInt;
                } else {
                  tempCount /= tempInt;
                }
              } else {
                tempCount += tempInt;
              }
            }
          }
          result += tempCount * symbol;
        } else {
          result += Integer.valueOf(current.replaceAll(" ", ""));
        }
      }

      System.out.println(result);
      // System.out.println("answer");
    }

  }
}
