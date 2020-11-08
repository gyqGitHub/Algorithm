package com.hsb.easy

/**
 * 1。暴力解题
 * 2。找出无效处理
 * 3。尝试事件转换，使用合理数据结构
 * 最长公共前缀
 * @author gyq
 * @date 2020/11/8
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String? {
        val length = strs.size
        val commonPrefix = StringBuilder()

        var lastChar = 0.toChar()
        var i = 0
        while (i < length) {
            val prefixLength = commonPrefix.length
            val tempStr = strs[i]

            if (tempStr.length == prefixLength) {
                break
            }
            if (i == 0) {
                lastChar = tempStr[prefixLength]
            }
            if (tempStr[prefixLength] != lastChar) {
                break
            }
            if (i == length - 1) {
                commonPrefix.append(lastChar)
                i = -1
            }
            i++
        }
        return commonPrefix.toString()
    }
}

fun main(args: Array<String>) {
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("flower","flow","flight")))
}

