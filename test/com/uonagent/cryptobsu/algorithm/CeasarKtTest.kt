package com.uonagent.cryptobsu.algorithm

import com.uonagent.cryptobsu.utils.makeString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CeasarKtTest {

    @Test
    fun makeString() {
        val s = "k LL  3 "
        assertEquals(s, s.toList().makeString())
    }
}