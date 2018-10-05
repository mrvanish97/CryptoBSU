package com.uonagent.cryptobsu.language

private const val BLANK_NAME = "Language name cannot be blank"
private const val EMPTY_ALPHABET = "Alphabet cannot be empty"
private const val EMPTY_FREQUENCY = "Frequency array cannot be empty"
private const val ARRAYS_DOES_NOT_MATCH = "Sizes of both arrays must be equal"
private const val WRONG_FREQUENCY = "Sum of frequencies must be equal 1"

class CustomLanguage(override val languageName: String,
                     override val alphabetArray: Array<Char>,
                     override val frequencyArray: Array<Double>) : Language() {
    init {
        if (languageName.isBlank()) {
            throw IllegalArgumentException(BLANK_NAME)
        }
        if (alphabetArray.isEmpty()) {
            //todo
        }
    }
}