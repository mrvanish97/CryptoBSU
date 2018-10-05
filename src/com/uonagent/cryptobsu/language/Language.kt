package com.uonagent.cryptobsu.language

import java.io.Serializable

private const val NO_SUCH_CHAR_FOUND_EXCEPTION = "No such char found in this language"
private const val OUT_OF_ALPHABET = "Given position is incorrect for this language"

abstract class Language internal constructor() : Serializable {

    protected abstract val alphabetArray: Array<Char>
    protected abstract val frequencyArray: Array<Double>

    abstract val languageName: String
    open val alphabet get() = alphabetArray.asList()

    open val alphabetSize get() = alphabetArray.size

    protected fun checkFields() {

    }

    val frequencies get() = frequencyArray.toList()

    open fun characterFrequency(char: Char): Double {
        val index = alphabetArray.indexOf(char.toUpperCase())
        if (index == -1) {
            throw IllegalArgumentException(NO_SUCH_CHAR_FOUND_EXCEPTION)
        }
        return frequencyArray[index]
    }

    open fun containsCharacter(char: Char) : Boolean{
        return alphabetArray.contains(char.toUpperCase())
    }

    fun getCharacterPosition(char: Char): Int {
        val index = alphabet.indexOf(char.toUpperCase())
        if (index == -1) throw IllegalArgumentException(NO_SUCH_CHAR_FOUND_EXCEPTION)
        return index + 1
    }

    fun getCharacterByPosition(position: Int): Char {
        if (position !in 1..alphabetSize) throw IllegalArgumentException(OUT_OF_ALPHABET)
        return alphabetArray[position - 1]
    }
}