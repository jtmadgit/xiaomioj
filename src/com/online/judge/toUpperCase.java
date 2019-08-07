package com.online.judge;

import java.util.*;

/**
 * #17 小写数字转大写数字
 *
 * 描述
 * 实现一个算法，可以将小写数字转换成大写数字。
 *
 * 输入
 * 输入一个整数。范围在0～450亿之间。
 *
 *  输出
 *  输出对应的大写数字，以“元整”结尾。 大写数字要符合汉语读写习惯。
 *
 * @{author} majintao
 * @{create} 2019-08-07-11:16
 */
public class toUpperCase {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    String[] uppers = new String []{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    String[] units = new String[]{"", "拾", "佰", "仟", "万"};
    String suffix = "元整";
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String result = "";
      String[] inputArray = line.split("");
      int length = inputArray.length;
      int expectNum = -1;
      for(int i=0; i< length; i++) {
        int current = Integer.parseInt(inputArray[i]);
        int currentWeight = length - i - 1;
        if (current == 0) {
          if(!result.endsWith("亿") && !result.endsWith("万")){
            result += currentWeight == 8 ? "亿" : (currentWeight == 4 ? "万" : "");
            expectNum = currentWeight % 4 == 0 ? i+1 : -1;
          }
          continue;
        }
        if (i-1 > 0 && inputArray[i-1].equals("0") && i!= expectNum) {
          result += "零";
        }

        if (currentWeight >= 8) {
          int remainder = currentWeight % 8;
          result += uppers[current] + units[remainder];
        } else {
          int remainder = currentWeight % 4;
          result += uppers[current] + units[remainder];
        }
        result += currentWeight == 8 ? "亿" : (currentWeight == 4 ? "万" : "");
      }

      System.out.println((result.equals("") ? "零" : result) + suffix);
      // System.out.println("answer");
    }

  }
}
