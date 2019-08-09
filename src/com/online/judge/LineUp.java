package com.online.judge;

import java.util.*;

/**
 * #18 帮小学生排队
 *
 * 描述
 * 用一个数组表示一群正在排队的小学生，每个小学生用一对整数 H, K 来表示：H 表示这个小学生的身高，K 表示这个小学生前面应该有 K 个人的身高 >= 他。
 * 写一个算法，对给出的一组小学生计算出符合描述的正确排序。
 *
 * 输入
 * 输入为一组整数，以空格分隔：
 *     第 1 个数字表示小学生的数量 n；
 *     从第 2 个数字起，后续的数字两两一组，分别代表每个小学生的 H 和 K 的值：H1K1H2K2⋯HnKn.
 *
 * 输出
 *  根据输入，按照题目要求对小学生进行排序，每个小学生对应的 H 和 K 值为一组，按组输出，数字间使用空格分隔。
 *
 *  输入样例
 *  6 7 0 4 4 7 1 5 0 6 1 5 2
 *
 *  输出样例
 *  5 0 7 0 5 2 6 1 4 4 7 1
 *
 * @{author} majintao
 * @{create} 2019-08-08-16:10
 */
public class LineUp {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNextLine()) {
      line = scan.nextLine().trim();
      // please write your code here
      String[] inputArray = line.split(" ");
      int length = Integer.parseInt(inputArray[0]);// 排队的人数
      String[] group = new String[length];
      String[] result = new String[length];// 输入结果
      for (int i=1; i<inputArray.length; i+=2) {
        group[(i - 1) / 2] = inputArray[i] + " " + inputArray[i + 1];
      }
      for (int i=length - 1; i>0; i--) {
        for (int j=0; j< i; j++) {
          int current = Integer.parseInt(group[j].split(" ")[0]);
          int next = Integer.parseInt(group[j+1].split(" ")[0]);
          if (next < current) {
            String temp = group[j];
            group[j] = group[j + 1];
            group[j + 1] = temp;
          }
        }
      }
      int lastHeight = -1;
      List<String> removeList =  new ArrayList();
      List<String> indexList = new ArrayList();
      for(int i=0; i<length; i++){
        indexList.add(i+"");
      }
      for(int i=0; i< length; i++){
        String[] current = group[i].split(" ");
        int height = Integer.parseInt(current[0]);
        int index = Integer.parseInt(current[1]);
        if(lastHeight != -1 && lastHeight != height){
          for(int k=0; k<removeList.size();k++){
            indexList.remove(removeList.get(k));
          }
          removeList = new ArrayList();
        }
        result[Integer.parseInt(indexList.get(index))] = group[i];
        lastHeight = height;
        removeList.add(indexList.get(index));
      }
      String resultStr = "";
      for(int i=0; i< length; i++){
        resultStr += result[i] + " ";
      }
      System.out.println(resultStr);
      // System.out.println("answer");
    }

  }
}
