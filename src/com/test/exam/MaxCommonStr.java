package com.test.exam;

/**
 * LCS
 * 一个数列S，如果分别是两个或多个已知数列的子序列， 且是所有符合此条件序列中最长的，则 S 称为已知序列的最长公共子序列。
 *
 * 例如：输入两个字符串BDCABA和 ABCBDAB， 字符串 BCBA和BDAB 都是是它们的最长公共子序列，则输出它们的长度4，并打印任意一个子序列. （Note: 不要求连续）
 *
 * @author JTMAD
 * @date 2020-05-21-15:24
 */
public class MaxCommonStr {

  public static void main(String[] args) {
    String result = getMaxCommonStr("BDCABA", "ABCDBAB");
    System.out.println("最长公共子序列:"+ result +", 长度:" + result.length());
  }

  public static String getMaxCommonStr(String aStr, String bStr) {
    int[][] size = new int[aStr.length() + 1][bStr.length() + 1];
    int[][] direction = new int[aStr.length() + 1][bStr.length() + 1];
    for(int i=0; i <bStr.length() + 1; i ++ ) {
      size[0][i] = 0;
    }
    for(int i=0; i <aStr.length() + 1; i ++ ) {
      size[i][0] = 0;
    }
    for (int i = 1; i <= aStr.length(); i++) {
      for(int j = 1; j <= bStr.length(); j++) {
        char aChar = aStr.charAt(i - 1);
        char bChar = bStr.charAt(j - 1);
        if (aChar == bChar) {
          size[i][j] = size[i-1][j-1] + 1;
          direction[i][j] = 0;
        } else if(size[i-1][j] >= size[i][j-1]){
          size[i][j] = size[i-1][j];
          direction[i][j] = 1;
        } else {
          size[i][j] = size[i][j-1];
          direction[i][j] = 2;
        }
      }
    }
    StringBuffer buffer = new StringBuffer();
    int x =aStr.length(), y = bStr.length();
    while (x != 0) {
      int d = direction[x][y];
      if (d == 0 ) {
        buffer.append(bStr.charAt(x));
        x--;y--;
      } else if(d == 1) {
        x--;
      } else {
        y--;
      }
    }
    return buffer.reverse().toString();
  }
}
