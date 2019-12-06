package com.algorithm.illustration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 狄克斯特拉算法
 *
 * 图算法：用于求加权图的最短消耗及路径
 * 限制：只适用于有向无环图且权值必须大于等于0
 * @author majintao
 * @date 2019-12-06-16:40
 */
public class DixtraAlgorithm {

  public static void main(String[] args) {
    Map<String,Map<String,Integer>> graph = new HashMap();
    Map<String,Integer> neighborA = new HashMap();
    neighborA.put("B", 5);
    neighborA.put("C", 2);
    graph.put("A", neighborA);
    Map<String,Integer> neighborB = new HashMap();
    neighborB.put("E", 4);
    neighborB.put("F", 2);
    graph.put("B", neighborB);
    Map<String,Integer> neighborC = new HashMap();
    neighborC.put("B", 8);
    neighborC.put("F", 7);
    graph.put("C", neighborC);
    Map<String,Integer> neighborE = new HashMap();
    neighborE.put("F", 6);
    neighborE.put("G", 3);
    graph.put("E", neighborE);
    Map<String,Integer> neighborF = new HashMap();
    neighborF.put("G", 1);
    graph.put("F", neighborF);
    Map<String, Integer> costs = new HashMap();
    costs.put("B", 5);
    costs.put("C", 2);
    costs.put("E", Integer.MAX_VALUE);
    costs.put("F", Integer.MAX_VALUE);
    costs.put("G", Integer.MAX_VALUE);
    Map<String, String> parents = new HashMap();
    parents.put("B", "A");
    parents.put("C", "A");
    parents.put("G", "None");

    test(graph, costs, parents);
  }

  public static void test(Map<String,Map<String,Integer>> graph, Map<String, Integer> costs, Map<String, String> parents){
    List<String> processedNodes = new ArrayList();
    String lowestNode = getLowestCostNode(costs, processedNodes);
    while (!"".equals(lowestNode) && graph.containsKey(lowestNode)) {
      Map<String,Integer> neighbor = graph.get(lowestNode);
      Set<String> neighborKeys = neighbor.keySet();
      for(String key : neighborKeys) {
        Integer cost = costs.get(lowestNode) + neighbor.get(key);
        if (cost < costs.get(key)){
          costs.put(key, cost);
          parents.put(key, lowestNode);
        }
      }
      processedNodes.add(lowestNode);
      lowestNode = getLowestCostNode(costs, processedNodes);
    }
    String shortPath = "G";
    String path = parents.get("G");
    while (!"A".equals(path)) {
      shortPath = path + "->" + shortPath;
      path = parents.get(path);
    }
    Integer lowestCost = costs.get("G");
    System.out.println("最短路径为：A->" + shortPath);
    System.out.println("最少消耗为：" + lowestCost);
  }

  public static String getLowestCostNode(Map<String, Integer> costs, List<String> processedNodes){
    Set<String> keys = costs.keySet();
    String lowestNode = "";
    for(String key : keys) {
      if (processedNodes.contains(key)) {
        continue;
      }
      if ("".equals(lowestNode) || costs.get(lowestNode) > costs.get(key)){
        lowestNode = key;
      }
    }
    return lowestNode;
  }
}
