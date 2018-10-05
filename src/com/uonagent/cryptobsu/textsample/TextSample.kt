package com.uonagent.cryptobsu.textsample

import com.uonagent.cryptobsu.language.Language
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

private const val NO_SUCH_CHAR_FOUND_EXCEPTION = "No such char found in this sample"

class TextSample(text: CharArray, private val language: Language) {

    constructor(text: List<Char>, language: Language) : this(text.toCharArray(), language)
    constructor(text: String, language: Language) : this(text.toCharArray(), language)
    constructor(text: Array<Char>, language: Language) : this(text.toCharArray(), language)

    companion object {
        fun cleanup(text: String, language: Language) : CharArray {
            val arr = CharArray(text.length)
            text.forEachIndexed { index, c ->
                if (language.containsCharacter(c)) {
                    arr[index] = c.toUpperCase()
                }
            }
            return arr
        }

        fun cleanup(text: CharArray, language: Language) : CharArray {
            val arr = CharArray(text.size)
            text.forEachIndexed { index, c ->
                if (language.containsCharacter(c)) {
                    arr[index] = c.toUpperCase()
                }
            }
            return arr
        }
    }

    private val counter = Array(language.alphabetSize) { 0 }

    private lateinit var textArr: CharArray

    private val executor = ForkJoinPool()

    init {
        textArr = cleanup(text, language)
        for (i in counter.indices) {
            executor.submit(Finder(language.alphabet[i], textArr, i))
        }
        executor.shutdown()
        executor.awaitTermination(1, TimeUnit.DAYS)
    }

    private inner class Finder(private val char: Char, private val string: CharArray,
                               private val index: Int) : Runnable {
        override fun run() {
            counter[index] = textArr.filter { it == char }.size
        }
    }

    fun characterFrequency(char: Char): Double {
        val index = language.alphabet.indexOf(char.toUpperCase())
        if (index == -1) {
            throw IllegalArgumentException(NO_SUCH_CHAR_FOUND_EXCEPTION)
        }
        return counter[index].toDouble() / textArr.size
    }

    override fun toString(): String {
        return String(textArr)
    }
}