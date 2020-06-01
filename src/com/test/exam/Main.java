package com.test.exam;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      String input = in.nextLine();
      String[] inputs = input.split(" ");
      int[] result = solution(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
      if (result.length == 0) {
        System.out.print(-1);
      } else {
        for (int i = 0; i < result.length; i++) {
          System.out.print( result[i] + " ");
        }
      }
      System.out.println();
    }
  }

  private static int[] solution(int sum, int length) {
    if (length == 1) {
      return new int[]{sum};
    }
    // 等差数列求和公示为：sum = (n * (n-1) / 2) * q + a1*n
    int nA1 = sum - length * (length - 1) / 2;
    if (nA1 % length != 0) {
      return new int[0];
    }
    int[] result = new int[length];
    result[0] = nA1 / length;
    for (int i = 1; i < length; i++) {
      result[i] = result[i - 1] + 1;
    }
    return result;
  }
}