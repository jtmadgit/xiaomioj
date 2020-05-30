package com.tree;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      int n = Integer.valueOf(in.nextLine().trim());
      String[][] input = new String[n][n];
      for (int i = 0; i < n; i++) {
        String inputStr = in.nextLine();
        String[] inputArray = inputStr.split(" ");
        for (int j = 0; j < n; j++) {
          input[i][j] = inputArray[j];
        }
      }
      rotation(input);
    }
  }

  public static void rotation(String[][] input) {
    int n = input.length;
    for (int j = 0; j < n / 2; j++) {
      for (int i = 0; i < n - 1; i++) {
        String current = input[j][i], origin;
        int rotationX = i, rotationY = j;
        do {
          // 坐标偏移量
          Double offset = Double.valueOf(n - 1) / 2;
          // 偏移后的坐标
          Double offsetStartX = rotationX - offset, offsetStartY = rotationY - offset;

          Double temp = offsetStartX;
          offsetStartX = -offsetStartY;
          offsetStartY = temp;
          offsetStartX += offset;
          offsetStartY += offset;
          rotationX = offsetStartX.intValue();
          rotationY = offsetStartY.intValue();
          origin = input[rotationY][rotationX];
          input[rotationY][rotationX] = current;
          current = origin;
        } while (rotationX != i || rotationY != j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(input[i][j] + " ");
      }
      System.out.println();
    }
  }


}
