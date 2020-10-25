package com.hsb.algorithm;

/**
 *
 * 1. 暴力解题：分析复杂度的上下限。
 * 2。问题类型：分析无效操作处理，分析问题类型，针对特定的问题类型使用特定的算法思维解题，这些算法思维能够有效避免
 *             无效操作。问题类型一般有排序，查找等，算法思维一般有排序，二分查找，分而治之，动态规划，递归等。
 * 3。时空转换：选择合理的数据结构来减少数据操作，通常是以空间换时间，如哈希表的key的查找
 *
 * 针对数字型的题目，可以尝试使用数学计算的方式去解题。
 *
 * -123 -1234 -12345 i>0 i->l-i l-1/2
 * 123 1234 i>=0 i->l-1-i l-1/2
 * @author gyq
 * @date 2020/10/25
 */
class Task {
    public static int reverse(int x) {
        String str = new StringBuilder(x + "").reverse().toString();
        str = str.replace("-","");
        if(x<0){
            str = "-" + str;
        }
        long result = Long.parseLong(str);
        if(x>Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }
        char[] chars = "".toCharArray();
        return (int)result;
    }

    public int reverse2(int x) {
        long result = 0;
        while(x !=0 ){
            int pop = x % 10;
            result = result *10 + pop;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(Task.reverse(Integer.MIN_VALUE));
    }
}


