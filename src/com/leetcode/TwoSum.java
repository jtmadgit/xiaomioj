package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 *
 * @author majintao
 * @date 2019-12-10-14:31
 */
public class TwoSum {

  public static void main(String[] args){
    Integer[] nums = new Integer[]{2, 7, 8, 9, 11, 7};
    Integer target = 14;
    Map<Integer,Integer> test = new HashMap();
    test.hashCode();
    for(int i=0;i<16;i++){
      test.put(15 + 16 * i, 2);
    }
    List<Integer> list = new ArrayList();
    list.add(1);
    list.add(1);
    list.add(3);
    list.remove(1);
    Object[] array1 = list.toArray();
    Integer[] array2 = new Integer[3];
    list.toArray(array2);
    twoSum(nums, target);
    twoSum2(nums, target);

  }

  /**
   * 穷举法，暴力破解
   * @param nums
   * @param target
   */
  public static void twoSum(Integer[] nums, Integer target){
    int length = nums.length;
    for(int i=0;i<length;i++){
      int offset = target - nums[i];
      for(int j=i+1;j<length;j++){
        if (nums[j] == offset){
          System.out.println("[" + i + "," + j + "]");
          return;
        }
      }
    }
    System.out.println("无符合条件的输出");
  }

  public static void twoSum2(Integer[] nums, Integer target){
    int length = nums.length;
    Map<Integer, Integer> keyMaps = new HashMap();
    for(int i=0;i<length;i++){
      if (keyMaps.containsKey(nums[i])) {
        System.out.println("[" + keyMaps.get(nums[i]) + "," + i + "]");
        return;
      }
      keyMaps.put(target - nums[i], i);
    }
    System.out.println("无符合条件的输出");
  }
}
