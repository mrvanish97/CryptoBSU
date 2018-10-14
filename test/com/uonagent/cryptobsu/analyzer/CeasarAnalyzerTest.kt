package com.uonagent.cryptobsu.analyzer

import com.uonagent.cryptobsu.algorithm.Ceasar
import com.uonagent.cryptobsu.language.English
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CeasarAnalyzerTest {

    private val k = 3

    private val s = "Then, use a container like a hat or a shoe to transport water from your water source to the boiling pit until it’s full"

    private val ceasar = Ceasar(k, English)

    private val encr = ceasar.encrypt(s)
    private val orig = ceasar.decrypt(encr)

    private val ceasarAnalyzer = CeasarAnalyzer(English)

    @Test
    fun hack() {
        val hackedKey = ceasarAnalyzer.hack(encr)
        println(hackedKey)
        val superCeasar = Ceasar(hackedKey, English)
        val actual = superCeasar.decrypt(encr)
        println(actual)
        assertEquals(orig, actual)
    }

    @Test
    fun hack1() {
    }
}