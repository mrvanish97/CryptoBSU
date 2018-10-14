package com.uonagent.cryptobsu.algorithm

import com.uonagent.cryptobsu.language.English
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class VigenereTest {

    private val orig = " @ a ZB C  : "
    private val decrypted = "AZBC"
    private val key = "Baz"
    private val encrypted = "BZAD"

    private val v = Vigenere(key, English)

    @Test
    fun encrypt() {
        assertEquals(encrypted, v.encrypt(orig))
    }

    @Test
    fun decrypt() {
        assertEquals(decrypted, v.decrypt(encrypted))
    }
}