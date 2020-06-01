package com.test.exam;

import java.util.Scanner;

public class Exam2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      int count = Integer.parseInt(in.nextLine());
      String[] inputs = new String[count];
      for (int i = 0; i < count; i++) {
        inputs[i] = in.nextLine();
      }
      String[] solution = solution(inputs);
      for (int i = 0; i < solution.length; i++) {
        System.out.println(solution[i]);
      }
    }
  }

  private static String[] solution(String[] inputs) {
    int length = inputs.length;
    String[] dealString = new String[length];
    for (int i = 0; i < length; i++) {
      String current = inputs[i];
      StringBuilder builder = new StringBuilder();
      int strLength = current.length();
      double[] tables = new double[strLength];
      for (int j = 0; j < strLength; j++) {
        double changed = current.charAt(j) + getOffset(j, tables);
        if (changed > 122 ) {
          double floor = Math.floor((changed - 122) / 26);
          if ((changed - 122) / 26 > floor) {
            floor += 1;
          }
          changed -= floor * 26;
        }
        builder.append((char)changed);
      }
      dealString[i] = builder.toString();
    }
    return dealString;
  }

  private static double getOffset(int index, double[] tables) {
    if (index == 0) {
      return 1;
    } else if (index == 1) {
      return 2;
    } else if (index == 2) {
      return 4;
    } else {
      if (tables[index] != 0) {
        return tables[index];
      } else {
        double offset =
            getOffset(index - 1, tables) + getOffset(index - 2, tables) + getOffset(index - 3, tables);
        tables[index] = offset;
        return offset;
      }
    }
  }
}