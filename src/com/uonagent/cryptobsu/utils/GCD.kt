package com.uonagent.cryptobsu.utils

object GCD {

    fun gcd(numbers: List<Int>): Int {
        var gcd = 1
        var index = 2
        if (numbers.size == 1) {
            gcd = numbers[0]
        }
        if (numbers.size > 1) {
            gcd = euclidGcd(numbers[0], numbers[1])
        }
        while (index < numbers.size) {
            gcd = euclidGcd(gcd, numbers[index])
            index++
        }
        return gcd
    }

    fun euclidGcd(num1V: Int, num2V: Int): Int {
        var num1 = num1V
        var num2 = num2V
        var temp = 0
        while (num2 != 0) {
            temp = num2
            num2 = num1 % num2
            num1 = temp
        }
        num1 = if (num1 < 0) num1 * -1 else num1
        return num1
    }
}