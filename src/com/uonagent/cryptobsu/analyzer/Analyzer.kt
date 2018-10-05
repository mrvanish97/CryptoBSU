package com.uonagent.cryptobsu.analyzer

interface Analyzer<E> {
    fun hack(cipherText: List<E>, eps: Double) : List<List<E>>
}