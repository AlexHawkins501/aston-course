package com.alex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialJunitTest {

    @Test
    void testFactorial() {
        assertEquals(1, FactorialJunit.factorial(0));
        assertEquals(1, FactorialJunit.factorial(1));
        assertEquals(2, FactorialJunit.factorial(2));
        assertEquals(6, FactorialJunit.factorial(3));
        assertEquals(24, FactorialJunit.factorial(4));
        assertEquals(120, FactorialJunit.factorial(5));
    }

    @Test
    void testNegativeFactorial() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> FactorialJunit.factorial(-5));
    }

}