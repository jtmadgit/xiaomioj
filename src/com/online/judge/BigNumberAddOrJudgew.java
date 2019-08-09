package com.online.judge;

import java.util.*;

/**
 * #19 大数的加法运算与大小判断
 *
 * 描述
 * 对于给定的算术表达式，按规则输出计算结果，仅包含加法和大小判断。
 *
 * 输入
 * 一行字符串，为加号、大于、小于( + < > ) 连接的两个不限大小的非负整数。
 *
 * 输出
 * 当符号为 + 时, 计算两个数相加的和, 并以字符串格式返回；
 * 当符号为 < 时, 如果左数小于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N；
 * 当符号为 > 时, 如果左数大于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N。
 * !!!请同学们尽量使用算法来解决这个问题
 *
 * 输入样例
 * 972919822976663297>74058
 * 875098336507333719633571722631534917759993913379786689>53558270653237768027942884431075534537929401567824882097903948774409200
 * 7625022925148127196027859399571498914361+790786706794530
 *
 * 输出样例
 * Y
 * N
 * 7625022925148127196027860190358205708891
 *
 * @{author} majintao
 * @{create} 2019-08-09-20:50
 */
public class BigNumberAddOrJudgew {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split("\\+|<|>");
      while (inputArray[0].startsWith("0") && inputArray[0].length()>1){
        inputArray[0] = inputArray[0].substring(1);
      }
      while (inputArray[1].startsWith("0") && inputArray[1].length()>1){
        inputArray[1] = inputArray[1].substring(1);
      }
      String[] firstNumber = inputArray[0].split("");
      String[] secondNumber = inputArray[1].split("");
      int firstLength = firstNumber.length;
      int secondLength = secondNumber.length;
      String result = "";
      if (line.indexOf("+") != -1) { //大数相加
        int max = firstLength > secondLength ? firstLength : secondLength;
        int flag = 0; // 进位标记
        int firstIndex = firstLength -1, secondIndex = secondLength-1;
        for(int i=max; i>0; i--) {
          int first = firstIndex >= 0 ? Integer.parseInt(firstNumber[firstIndex--]) : 0,
              second = secondIndex >= 0 ? Integer.parseInt(secondNumber[secondIndex--]) : 0;
          int sum = first + second;
          sum += flag;
          if(sum>=10){
            sum -= 10;
            flag = 1;
          }else{
            flag = 0;
          }
          result = sum + result;
        }
        if(flag>0){
          result = 1 + result;
        }
      } else {
        if(firstLength != secondLength){
          result = ((line.indexOf(">")!=-1 && firstLength > secondLength) || (line.indexOf("<") !=-1 && firstLength < secondLength)) ? "Y" : "N";
        }else{
          String flag = "<";
          for(int i=0; i<firstLength; i++){
            int first = Integer.parseInt(firstNumber[i]);
            int second = Integer.parseInt(secondNumber[i]);
            if(first > second){
              flag = ">";
              break;
            }else if(first == second){
              flag = "=";
            }else{
              break;
            }
          }
          result = flag.equals("=") ? "N" : (line.indexOf(flag)!=-1 ? "Y" : "N");
        }
      }
      System.out.println(result);
      // System.out.println("answer");
    }

  }
}
