package com.uonagent.cryptobsu.textsample

import com.uonagent.cryptobsu.language.English
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TextSampleTest {

    @Test
    fun characterFrequency() {
        val s = "  34aaaaA b B-20HSn !" //5 chars size 10 --> 0.5
        val sample = TextSample(s, English)
        val expected = 0.2
        println(sample)
        assertEquals(expected, sample.characterFrequency('b'))
    }
}