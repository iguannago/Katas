package com.katas.fizzbuzz

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FizzBuzz27Test {

    @Test
    internal fun `given 1 returns 1`() {
        val fizzBuzz27 = FizzBuzz27()

        Assertions.assertEquals("1", fizzBuzz27.play(1))
    }
}