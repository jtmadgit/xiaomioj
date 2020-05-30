package com.test.exam;

import java.util.Scanner;

/**
 * 翻转文章片段
 *
 * @author JTMAD
 * @date 2020-05-30-18:01
 */
public class Flip {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      String content = in.nextLine();
      String start = in.nextLine();
      String end = in.nextLine();
      System.out.println(solution(content, Integer.parseInt(start), Integer.parseInt(end)));
    }
  }

  private static String solution(String content, int start, int end) {
    String[] split = content.split(" ");
    int length = split.length;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < start; i++) {
      builder.append(split[i]);
      builder.append(" ");
    }
    for (int i = end; i >= start; i--) {
      builder.append(split[i]);
      builder.append(" ");
    }
    for (int i = end + 1; i < length; i++) {
      builder.append(split[i]);
      builder.append(" ");
    }
    return builder.toString();
  }
}
