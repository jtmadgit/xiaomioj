package com.test.exam;

import java.util.Scanner;

/**
 * 消消乐数组
 *
 * @author JTMAD
 * @date 2020-05-30-18:49
 */
public class XiaoXiaoLeArray {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      int yWidth = Integer.parseInt(in.nextLine());
      String[][] matrix = new String[yWidth][];
      for (int i = 0; i < yWidth; i++) {
        String input = in.nextLine();
        matrix[i] = input.split(",");
      }
      int solutionCount = Integer.parseInt(in.nextLine());
      String[][] solutionMatrix = new String[solutionCount][];
      for (int i = 0; i < solutionCount; i++) {
        String input = in.nextLine();
        solutionMatrix[i] = input.split(",");
      }
      System.out.println(solution(matrix, solutionMatrix));
    }
  }

  private static String solution(String[][] matrix, String[][] solutionMatrix) {
    String result = "OK";
    int solutionCount = solutionMatrix.length;
    int[][] dealMatrix = dealMatrix(matrix);
    for (int i = 0; i < solutionCount; i++) {
      String[] currentStep = solutionMatrix[i];
      int startX = Integer.parseInt(currentStep[0]), startY = Integer.parseInt(currentStep[1]);
      int endX = Integer.parseInt(currentStep[2]), endY = Integer.parseInt(currentStep[3]);
      if (dealMatrix[startY + 1][startX + 1] != dealMatrix[endY + 1][endX + 1]) {
        return String.valueOf(i);
      }
      if (!go(dealMatrix, startX + 1, startY + 1, endX + 1, endY + 1)) {
        return String.valueOf(i);
      } else {
        dealMatrix[startY + 1][startX + 1] = 0;
        dealMatrix[endY + 1][endX + 1] = 0;
      }
    }
    return result;
  }

  private static int[][] dealMatrix(String[][] matrix) {
    int yWidth = matrix.length, xWidth = 0;
    if (yWidth > 0) {
      xWidth = matrix[0].length;
    }
    int[][] newMatrix = new int[yWidth + 2][xWidth + 2];
    for (int i = 0; i < yWidth; i++) {
      for (int j = 0; j < xWidth; j++) {
        newMatrix[i + 1][j + 1] = Integer.parseInt(matrix[i][j]);
      }
    }
    return newMatrix;

  }

  private static boolean judge(int[][] matrix, int startX, int startY, int endX, int endY,
      int direction, int stepCount) {
    if (stepCount > 3) {
      // 超过3步，放弃W
      return false;
    } else if (startX == endX && startY == endY) {
      // 成功到达
      return true;
    } else if (matrix[startY][startX] != 0) {
      // 此路不通，放弃
      return false;
    } else {
      boolean up = false, down = false, left = false, right = false;
      if (startX < matrix[0].length - 1) {
        right = judge(matrix, startX + 1, startY, endX, endY, 4,
            4 == direction ? stepCount : stepCount + 1);
      }
      if (startX > 0) {
        left = judge(matrix, startX - 1, startY, endX, endY, 3,
            3 == direction ? stepCount : stepCount + 1);
      }
      if (startY < matrix.length - 1) {
        up = judge(matrix, startX, startY + 1, endX, endY, 2,
            2 == direction ? stepCount : stepCount + 1);
      }
      if (startY > 0) {
        down = judge(matrix, startX, startY - 1, endX, endY, 1,
            1 == direction ? stepCount : stepCount + 1);
      }
      return up || down || left || right;
    }
  }

  private static boolean go(int[][] matrix, int startX, int startY, int endX, int endY) {
    boolean up = false, down = false, left = false, right = false;
    int stepCount = 1;
    if (startX < matrix[0].length - 1) {
      right = judge(matrix, startX + 1, startY, endX, endY, 4, stepCount);
    }
    if (startX > 0) {
      left = judge(matrix, startX - 1, startY, endX, endY, 3, stepCount);
    }
    if (startY < matrix.length - 1) {
      down = judge(matrix, startX, startY + 1, endX, endY, 2, stepCount);
    }
    if (startY > 0) {
      up = judge(matrix, startX, startY - 1, endX, endY, 1, stepCount);
    }
    return up || down || left || right;
  }
}
