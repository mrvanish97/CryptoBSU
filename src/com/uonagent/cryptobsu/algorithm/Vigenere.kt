package com.uonagent.cryptobsu.algorithm

import com.uonagent.cryptobsu.language.Language
import com.uonagent.cryptobsu.textsample.TextSample
import com.uonagent.cryptobsu.utils.collectEveryNth
import com.uonagent.cryptobsu.utils.makeString
import com.uonagent.cryptobsu.utils.splitEveryNth

private const val KEY_SIZE_EXCEPTION = "Key length must be greater than 0"

class Vigenere(key: String, val language: Language) : SymmetricKey<Char> {

    private val encryptSequence = arrayListOf<Ceasar>()
    private val keySize = key.length

    override val key: List<Char>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    init {
        if (keySize < 1) {
            throw IllegalArgumentException(KEY_SIZE_EXCEPTION)
        }
        initEncryptSequence(key)
    }

    override fun encrypt(array: List<Char>): List<Char> {
        return make(array, true)
    }

    override fun decrypt(array: List<Char>): List<Char> {
        return make(array, false)
    }

    fun encrypt(string: String) = encrypt(string.toList()).makeString()
    fun decrypt(string: String) = decrypt(string.toList()).makeString()

    private fun initEncryptSequence(key: String) {
        TextSample
                .cleanup(key, language)
                .forEach { encryptSequence.add(Ceasar(language.getCharacterPosition(it) - 1, language)) }
    }

    override fun make(array: List<Char>, isEncryption: Boolean): List<Char> {
        return array
                .asSequence()
                .filter { language.containsCharacter(it) }
                .splitEveryNth(keySize)
                .mapIndexed { index, list -> encryptSequence[index].make(list, isEncryption) }
                .collectEveryNth(keySize)
                .toList()
    }

    fun make(string: String, isEncryption: Boolean) = make(string.toList(), isEncryption).makeString()
}
