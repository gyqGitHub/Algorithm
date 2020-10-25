package com.hsb.medium

/**
 * 1。暴力解法
 * 2。无效操作处理
 * 3。时空转换
 *
 * 1。复杂度分析：暴力解法分析出复杂度上下限
 * 2。定位问题：排序，查找，最优解等，决定采用何种算法思维，不同类型的问题常常对应特定的算法思维(排序算法，二分查找,分而治之，递归迭代，动态规划等)
 * 3。数据操作分析：根据增删查和数据顺序关系选择合适的数据结构来降低时间复杂度，如哈希表判断key是否存在的时间复杂度为O(1)
 */
fun main(args: Array<String>) {
    println("result: ${Solution().longestPalindrome("cbbd")}")
}

/**
 * [b,a,b,a,d]
 * [b,a,b,a]
 * [b,a,b]
 * [b,a]
 * 暴力解法，改用while循环，更易理解
 */
internal class Solution {
    fun longestPalindrome(s: String?): String {
        val length = s!!.length
        if (s == null || length == 0) {
            return ""
        }
        if(length == 1){
            return s
        }
        if(length ==2){
            if(isPalindrome(s,0,1)){
                return s
            }
        }
        for (i in length downTo 1) {
            println("i = $i")
            for (j in 0 ..length-i) {
                println("j = $j")
                if (isPalindrome(s, j, j + i-1)) {
                    return s.substring(j, j + i)
                }
            }
        }
        return s[0].toString()
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        println("start = $start   end = $end")
        var left = start
        var right = end;
        while (left<right){
            if(s[left] != s[right]){
                return false
            }
            left++
            right--
        }
        return true
    }
}