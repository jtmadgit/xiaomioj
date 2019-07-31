package com.online.judge;

import java.util.*;

/**
 * 大数相减
 * 描述
 * 两个长度超出常规整形变量上限的大数相减，请避免使用各语言内置大数处理库，如 Java.math.BigInteger 等。
 *
 * 输入
 * 有 N 行测试数据，每一行有两个代表整数的字符串 a 和 b，长度超过百位。规定 a>=b，a, b > 0。 测试结果可以用 linux 小工具 bc进行测试是否正确。
 *
 * 输出
 * 返回表示结果整数的字符串。
 *
 * @{author} majintao
 * @{create} 2019-07-31-21:55
 */
public class BigIntegerDifference {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] inputArray = line.split("-");
            if (inputArray.length != 2) {
                System.out.println("输入有误");
                continue;
            }
            String[] reduction = inputArray[0].split(""); // 减数
            String[] minuend = inputArray[1].split(""); // 被减数
            int reductionLength = reduction.length;
            int minuendLength = minuend.length;
            String result = "";
            int lastDiff = 0;
            for (int i = minuendLength - 1 , j = reductionLength - 1; j>=0; i--, j--) {
                int reductionLast = Integer.valueOf(reduction[j]);
                if (lastDiff < 0) {
                    reductionLast--;
                }
                if (j >= reductionLength - minuendLength) {
                    int minuendLast = Integer.valueOf(minuend[i]);
                    lastDiff = reductionLast - minuendLast;
                    result = (lastDiff >= 0 ? lastDiff : (10 + lastDiff)) + result;
                } else {
                    lastDiff = 0;
                    result = reductionLast + result;
                }
            }
            if ((int)result.charAt(0) == 48) {
                result = result.substring(1);
            }
            System.out.println(result);
            // System.out.println("answer");
        }

    }
}
