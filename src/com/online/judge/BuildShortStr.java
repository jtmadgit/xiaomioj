package com.online.judge;

import java.util.*;

/**
 * #11 构建短字符串
 * 描述
 * 给定任意一个较短的子串，和另一个较长的字符串，判断短的字符串是否能够由长字符串中的字符组合出来，且长串中的每个字符只能用一次。
 *
 * 输入
 * 一行数据包括一个较短的字符串和一个较长的字符串，用一个空格分隔，如： ab aab bb abc aa cccc uak areuok
 *
 * 输出
 * 如果短的字符串可以由长字符串中的字符组合出来，返回字符串 “true”，否则返回字符串 "false"，注意返回字符串类型而不是布尔型。
 *
 * @{author} majintao
 * @{create} 2019-08-3-19:21
 */
public class BuildShortStr {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(" ");
      String[] shorter = inputArray[0].split("");
      if (inputArray.length < 2) {
        System.out.println("输入有误");
        continue;
      }
      /**
       * 说明一下这里为什么不用Array.asList()来将数组转换list
       * Array.asList()转换的list不是java.util.ArrayList，而是Array里面的内部类Array$ArrayList,该list的长度固定的无法改变的;
       * 没有实现add()和remove()方法，使用后会直接抛异常
       * **/
      List<String> longer = new ArrayList();
      for(String str: inputArray[1].split("")) {
        longer.add(str);
      }
      Boolean flag = true;
      for(String str: shorter){
        if(longer.contains(str)){
          longer.remove(str);
        }else{
          flag = false;
          break;
        }
      }
      System.out.println(flag);
      // System.out.println("answer");
    }

  }
}
