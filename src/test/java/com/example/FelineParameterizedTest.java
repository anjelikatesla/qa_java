package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final Feline feline;

    public FelineParameterizedTest(int expectedKittensCount) {
        this.expectedKittensCount = expectedKittensCount;
        this.feline = new Feline();
    }
    private final int expectedKittensCount;

    @Parameterized.Parameters
    public static Object[][] dataForKittensCount() {
        return new Object[][]{
                {-3},
                {4},
                {0},
        };
    }

    @Test
    public void testGetKittensWithCount() {
        int actual = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, actual);
    }
}