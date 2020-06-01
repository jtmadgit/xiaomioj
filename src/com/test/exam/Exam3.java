package com.test.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exam3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      String input = in.nextLine();
      System.out.println(solution(input));
    }
  }

  private static String solution(String input) {
    // 2,5不能同时出现
    if (input.indexOf("2") != -1 && input.indexOf("5") != -1) {
      return "-1";
    }
    // 6,9不能同时出现
    if (input.indexOf("6") != -1 && input.indexOf("9") != -1) {
      return "-1";
    }
    String[] split = input.split(",");
    int length = split.length;
    List<Integer> dealInput = new ArrayList();
    int max = 0;
    for (int i = 0; i < length; i++) {
      int current = Integer.parseInt(split[i]);
      if (current < 1 || current > 9) {
        return "-1";
      }
      dealInput.add(current);
      if (current > max) {
        max = current;
      }
    }
    if (input.indexOf("2") != -1) {
      dealInput.add(5);
    } else if (input.indexOf("5") != -1) {
      dealInput.add(2);
    }
    if (input.indexOf("6") != -1) {
      dealInput.add(9);
    } else if (input.indexOf("9") != -1) {
      dealInput.add(6);
    }
    List<Integer> integers = get(dealInput);
    if (integers.size() < max) {
      return "-1";
    }
    integers.sort(Comparator.comparingInt(a -> a));
    return integers.get(max - 1).toString();
  }

  private static List<Integer> get(List<Integer> inputs) {
    int length = inputs.size();
    List<Integer> result = new ArrayList();
    List<Integer> collection = new ArrayList();
    for (int i = 0; i < length; i++) {
      collection.add(inputs.get(i));
    }
    result.addAll(collection);

    for (int i = 1; i < length; i++) {
      collection = extend(collection, inputs);
      result.addAll(collection);
    }

    return result;
  }

  private static List<Integer> extend(List<Integer> collection, List<Integer> inputs) {
    List<Integer> extendCollection = new ArrayList();
    int length = inputs.size();
    for (int i = 0; i < collection.size(); i++) {
      int temp = collection.get(i);
      for (int j = 0; j < length; j++) {
        String current = String.valueOf(inputs.get(j));
        if (String.valueOf(temp).indexOf(current) == -1) {
          int str1 = Integer.parseInt(current + temp);
          int str2 = Integer.parseInt(temp + current);
          if (!extendCollection.contains(str1)) {
            extendCollection.add(str1);
          }
          if (!extendCollection.contains(str2)) {
            extendCollection.add(str2);
          }
        }
      }
    }
    return extendCollection;
  }
}
