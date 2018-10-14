package com.uonagent.cryptobsu.algorithm

import com.uonagent.cryptobsu.language.English
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CeasarTest {

    private val s = "a Bc XZ@   "
    private val k = 1
    private val ceasar = Ceasar(k, English)

    @Test
    fun encrypt() {
        val res = ceasar.encrypt(s)
        val exp = "BCDYA"
        assertEquals(exp, res)
    }

    @Test
    fun decrypt() {
        val res = ceasar.decrypt(s)
        val exp = "ZABWY"
        assertEquals(exp, res)
    }
}