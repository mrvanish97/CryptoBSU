package com.uonagent.cryptobsu.analyzer

import com.uonagent.cryptobsu.language.Language

class CeasarAnalyzer(val language: Language) : Analyzer<Char> {
    override fun hack(cipherText: List<Char>, eps: Double): List<List<Char>> {
        val size = language.alphabetSize
        val expectedFrequency = language.frequencies
        val actualFrequency = IntArray(size)
        cipherText
                .asSequence()
                .filter { language.containsCharacter(it) }
                .forEach { ++actualFrequency[language.getCharacterPosition(it) - 1] }
        val chiSquareResult = DoubleArray(size)
        var chiSquare: Double
        for (i in 0 until size) {
            chiSquare = 0.0
            for (j in 0 until size) {
                chiSquare += Math.pow(
                        (actualFrequency[(j + i) % size].toDouble() / size) - expectedFrequency[j], 2.0) /
                        expectedFrequency[j]
            }
            chiSquareResult[i] = chiSquare
        }
        var minIndex = -1
        var min = Double.MAX_VALUE
        for (i in 0 until size) {
            if (chiSquareResult[i] < min) {
                min = chiSquareResult[i]
                minIndex = i
            }
        }
        return arrayListOf(arrayListOf(language.getCharacterByPosition(minIndex + 1)))
    }

    fun hack(cipherText: String): Int {
        return try {
            language.getCharacterPosition(hack(cipherText.toList(), 0.0)[0][0]) - 1
        } catch (e: IndexOutOfBoundsException) {
            -1
        }
    }
}