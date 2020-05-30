package com.test.exam;

import java.util.Scanner;

/**
 * 求连续数列
 *
 * @author JTMAD
 * @date 2020-05-30-17:34
 */
public class ContinueNumArray {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      String s = in.nextLine();
      String[] split = s.split(" ");
      int[] solution = solution(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
      if (solution.length == 0) {
        System.out.println(-1);
      } else {
        for(int i=0;i<solution.length;i++){
          System.out.print(solution[i] + " ");
        }
        System.out.println();
      }
    }
  }

  private static int[] solution(int sum, int count) {
    int[] result = new int[count];
    int nA1 = sum - count * (count - 1) / 2;
    if (nA1 % count != 0) {
      return new int[0];
    }
    result[0] = nA1 / count;
    for(int i=1;i<count;i++){
      result[i] = result[i - 1] + 1;
    }
    return result;
  }
}
