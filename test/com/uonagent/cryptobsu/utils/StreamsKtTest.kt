package com.uonagent.cryptobsu.utils

import org.junit.jupiter.api.Test

internal class StreamsKtTest {

    private val arr = arrayListOf(1, 2, 3, 4, 5, 6)

    private fun kek(range: Int): List<List<Int>> {
        return arr.asSequence().splitEveryNth(range).toList()
    }

    @Test
    fun splitEveryNth() {
        for (range in 1..13) {
            println(kek(range))
        }
    }

    @Test
    fun collectEveryNth() {
        for (range in 1..10) {
            println(kek(range).asSequence().collectEveryNth(range).toList())
        }
    }
}