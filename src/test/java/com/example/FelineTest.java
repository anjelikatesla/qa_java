package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {
    private final Feline feline;

    private final int expectedKittensCount;

    public FelineTest(int expectedKittensCount) {
        this.expectedKittensCount = expectedKittensCount;
        this.feline = new Feline();
    }

    @Parameterized.Parameters
    public static Object[][] dataForKittensCount() {
        return new Object[][]{
                {-3},
                {4},
                {0},
        };
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensWithCount() {
        int actual = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, actual);
    }
}