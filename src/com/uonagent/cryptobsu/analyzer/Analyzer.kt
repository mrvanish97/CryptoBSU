package com.uonagent.cryptobsu.analyzer

interface Analyzer<E> {
    fun hack(cipherText: List<E>) : List<List<E>>
}