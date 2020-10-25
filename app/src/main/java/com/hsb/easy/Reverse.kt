package com.hsb.easy

import kotlin.math.abs

/**
 *
 * @author gyq
 * @date 2020/10/25
 */
class Reverse {
    fun reverse(x: Int): Int {
        var str: String = x.toString().reversed().replace("-","")
        println(str)
        if(x<0){
            str = "-$str"
        }
        println(str)
        val result = str.toLong()
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0
        }
        return result.toInt()
    }
}

fun main(args: Array<String>) {
    println(Reverse().reverse(-2147483648))
}