package com.leetcode;

/**
 * 二位数组对角线遍历
 *
 * @author JTMAD
 * @date 2020-05-28-9:58
 */
public class DiagonalTraversal {

  public static void main(String args[]) {
    int[][] matrix = new int[2][4];
    matrix[0] = new int[]{1, 2, 3, 4};
    matrix[1] = new int[]{5, 6, 7, 8};
    //matrix[2] = new int[]{9, 10, 11, 12};
    //matrix[3] = new int[]{13, 14, 15, 16};
    int[] solution = solution(matrix);
    for (int i = 0; i < solution.length; i++) {
      System.out.print(solution[i] + " ");
    }
  }

  public static int[] solution(int[][] matrix) {
    int m = matrix.length, n = 0;
    if (m != 0) {
      n = matrix[0].length;
    }
    int[] result = new int[m * n];
    int startM = 0, startN = 0;
    for (int i = 0; i < m * n; i++) {
      result[i] = matrix[startM][startN];
      boolean isUp = (startM + startN) % 2 == 0;
      if (isUp && startN == n - 1) {
        startM++;
      } else if (isUp) {
        if (startM > 0) {
          startM--;
        }
        if (startN < n - 1) {
          startN++;
        }
      } else if (!isUp && (startM == m - 1)) {
        startN++;
      } else {
        if (startM < m - 1) {
          startM++;
        }
        if (startN > 0) {
          startN--;
        }
      }
    }
    return result;
  }
}
