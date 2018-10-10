package com.uonagent.cryptobsu.analyzer

import com.uonagent.cryptobsu.language.Language
import com.uonagent.cryptobsu.utils.GCD
import com.uonagent.cryptobsu.utils.makeString

class VigenereAnalyzer(val language: Language) : Analyzer<Char> {

    override fun hack(cipherText: List<Char>): List<List<Char>> {
        val upperBound = 4

        val filtered = cipherText
                .asSequence()
                .filter { language.containsCharacter(it) }
                .map { it.toUpperCase() }
                .toList()
        val lProcess = lProcces(filtered, upperBound)
        val gcdArr = mutableMapOf<Int, Int>()

        var l = 1

        val aaa = lProcess.values
        val a = arrayListOf<Int>()
        for (i in aaa) {
            val g = GCD.gcd(i)
            if (gcdArr[g] == null) {
                gcdArr[g] = 0
            }
            gcdArr[g] = (gcdArr[g]!! + 1)
        }

        val sortedGCD = gcdArr
                .toList()
                .sortedWith(compareBy { it.second })

        val ans = arrayListOf<List<Char>>()

        var i = sortedGCD.size - 1
        while (i > -1) {
            var t = sortedGCD[i].first
            --i
        }

        return ans
    }

    fun hack(cipherText: String) = hack(cipherText.toList()).map { it.makeString() }

    private fun lProcces(cipherText: List<Char>, upperBound: Int): Map<List<Char>, List<Int>> {
        val map = hashMapOf<List<Char>, MutableList<Int>>()
        var l = 2
        val size = cipherText.size
        while (l < upperBound) {
            var i = 0
            while (i <= size - l * 2) {
                val sub = cipherText.subList(i, i + l)
                if (!map.containsKey(sub)) {
                    map[sub] = arrayListOf(i)
                    var j = i + l
                    while (j <= size - l) {
                        val copySub = cipherText.subList(j, j + l)
                        var areEqual = true
                        for (index in sub.indices) {
                            if (sub[index] != copySub[index]) {
                                areEqual = false
                                break
                            }
                        }
                        if (areEqual) {
                            map[sub]!!.add(j)
                        }
                        ++j
                    }
                }
                ++i
            }
            ++l
        }
        return map
                .filter { it.value.size > 1 }
    }
}