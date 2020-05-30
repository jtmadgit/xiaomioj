package com.leetcode;

/**
 * 数据中心索引
 *
 * @author JTMAD
 * @date 2020-05-27-17:15
 */
public class ArrayCenterIndex {

  public static void main(String args[]) {
    System.out.println(solution(new int[]{1, -1, 1}));
  }

  private static int solution(int[] nums) {
    for(int i=0;i<nums.length;i++) {
      if(isCenterIndex(nums, i)) {
        return i;
      }
    }
    return -1;
  }

  private static boolean isCenterIndex(int[] nums, int current) {
    int prevSum = 0, afterSum = 0;
    for(int i=0;i<nums.length;i++) {
      if (i < current) {
        prevSum += nums[i];
      } else if (i > current) {
        afterSum += nums[i];
      }
    }
    return prevSum == afterSum;
  }

}
