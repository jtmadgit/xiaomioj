package com.algorithm.illustration;

import java.util.HashMap;
import java.util.Map;

/**
 * 背包问题，动态规划
 *
 * @create majintao
 * @date 2019-12-09-11:30
 */
public class KnapsackProblem {

  public static void main(String[] args) {
    Map<String, Map<String, Integer>> data = new HashMap();
    Map<String, Integer> water = new HashMap();
    water.put("weight", 3);
    water.put("value", 10);
    data.put("water", water);
    Map<String, Integer> book = new HashMap();
    book.put("weight", 1);
    book.put("value", 3);
    data.put("book", book);
    Map<String, Integer> food = new HashMap();
    food.put("weight", 2);
    food.put("value", 9);
    data.put("food", food);
    Map<String, Integer> jack = new HashMap();
    jack.put("weight", 2);
    jack.put("value", 5);
    data.put("jack", jack);
    Map<String, Integer> camera = new HashMap();
    camera.put("weight", 1);
    camera.put("value", 6);
    data.put("camera", camera);
    test(data, 6);
  }

  public static void test(Map<String, Map<String, Integer>> data, Integer volume) {
    Integer size = data.size();
    String[] keys = new String[size];
    data.keySet().toArray(keys);
    Integer[][] cell = new Integer[size][volume];
    String[][] desc = new String[size][volume];
    for (int i = 0; i < size; i++) {
      String key = keys[i];
      Map<String, Integer> current = data.get(key);
      Integer weight = current.get("weight");
      Integer value = current.get("value");
      for (int j = 0; j < volume; j++) {
        if (i < 1) {
          if (j + 1 >= weight) {
            cell[i][j] = value;
            desc[i][j] = key;
          } else {
            cell[i][j] = 0;
            desc[i][j] = "";
          }
        }else {
          if (j + 1 >= weight) {
            Integer last = cell[i - 1][j];String lastDesc = desc[i - 1][j];
            Integer calc = value; String calcDesc = key;
            if (j + 1 > weight) {
              calc += cell[i - 1][j - weight];
              calcDesc += "," + desc[i - 1][j - weight];
            }
            cell[i][j] = calc > last ? calc : last;
            desc[i][j] = calc > last ? calcDesc : lastDesc;
          } else {
            cell[i][j] = cell[i - 1][j];
            desc[i][j] = desc[i - 1][j];
          }
        }
      }
    }
    System.out.println("最大价值为：" + cell[size-1][volume-1]);
    System.out.println("最大价值组合为：" + desc[size-1][volume-1]);
  }

}
