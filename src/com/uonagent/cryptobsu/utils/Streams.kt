package com.uonagent.cryptobsu.utils

private const val RANGE_EXCEPTION = "Range must be greater than 0"

fun <T> Sequence<T>.splitEveryNth(range: Int): Sequence<List<T>> {
    if (range < 1) {
        throw IllegalArgumentException(RANGE_EXCEPTION)
    }
    val arr = ArrayList<List<T>>(range)
    for (i in 0 until range) {
        arr.add(this.filterIndexed { index, _ -> index % range == i }.toList())
    }
    return arr.asSequence()
}

fun <T> Sequence<List<T>>.collectEveryNth(range: Int): Sequence<T> {
    if (range < 1) {
        throw IllegalArgumentException(RANGE_EXCEPTION)
    }
    val arr = arrayListOf<T>()
    val input: List<List<T>> = this.toList()
    for (j in 0 until input[0].size) {
        for (i in 0 until range) {
            try {
                arr.add(input[i][j])
            } catch (e: IndexOutOfBoundsException) {
                break
            }
        }
    }
    return arr.asSequence()
}

fun List<Char>.makeString(): String {
    return this
            .asSequence()
            .joinToString(separator = "")
}