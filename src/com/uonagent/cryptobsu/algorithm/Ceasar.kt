package com.uonagent.cryptobsu.algorithm

import com.uonagent.cryptobsu.language.Language
import com.uonagent.cryptobsu.utils.makeString

class Ceasar(key: Int, val language: Language) : SymmetricKey<Char> {

    constructor(char: Char, language: Language) : this(language.getCharacterPosition(char) - 1, language)

    private val k: Int
    private val keyArr = ArrayList<Char>(1)

    init {
        k = normalizeK(key)
        keyArr.add(language.getCharacterByPosition(k + 1))
    }

    override val key: List<Char>
        get() = keyArr

    private fun normalizeK(k: Int) = when {
        k >= language.alphabetSize -> k % language.alphabetSize
        k < 0 -> language.alphabetSize + k
        else -> k
    }

    override fun encrypt(array: List<Char>): List<Char> {
        return process(array, k)
    }

    override fun decrypt(array: List<Char>): List<Char> {
        return process(array, -k)
    }

    override fun make(array: List<Char>, isEncryption: Boolean): List<Char> =
            if (isEncryption) process(array, k) else process(array, -k)

    fun encrypt(string: String) = encrypt(string.toList()).makeString()
    fun decrypt(string: String) = decrypt(string.toList()).makeString()
    fun make(string: String, isEncryption: Boolean) = make(string.toList(), isEncryption).makeString()

    private fun process(array: List<Char>, k: Int): List<Char> {
        return array
                .asSequence()
                .filter { language.containsCharacter(it) }
                .map { transform(it, k) }
                .toList()
    }

    private val transform: (Char, Int) -> Char = { c, shift ->
        val pos = language.getCharacterPosition(c) - 1
        var newPos = pos + shift
        newPos = normalizeK(newPos)
        val newC = language.getCharacterByPosition(newPos + 1)
        newC
    }
}