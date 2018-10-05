package com.uonagent.cryptobsu.algorithm

interface SymmetricKey<E> {
    val key: List<E>
    fun encrypt(array: List<E>): List<E>
    fun decrypt(array: List<E>): List<E>
    fun make(array: List<E>, isEncryption: Boolean): List<E>
}