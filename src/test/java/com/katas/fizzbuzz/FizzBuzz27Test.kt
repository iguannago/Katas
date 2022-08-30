package com.katas.fizzbuzz

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FizzBuzz27Test {

    private val fizzBuzz27 = FizzBuzz27()

    @ParameterizedTest
    @CsvSource(value = [
        "1,1"
    ])
    internal fun `given 1 returns 1`(expectedOutcome: String, input: Int) {
        Assertions.assertEquals(expectedOutcome, fizzBuzz27.play(input))
    }
}