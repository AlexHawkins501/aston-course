package com.alex;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialNgTest {

    @Test
    public void testFactorial() {
        long actual = FactorialNg.factorial(5);
        long expected = 120;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative(){
        FactorialNg.factorial(-10);
    }

}