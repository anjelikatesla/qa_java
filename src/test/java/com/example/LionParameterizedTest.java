package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;

    private Lion lion;

    private final String sex;

    private final boolean expectedHaveMane;

    @Parameterized.Parameters
    public static Object[][] dataForManeTest() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    public LionParameterizedTest(String sex, boolean expectedHaveMane) {
        this.sex = sex;
        this.expectedHaveMane = expectedHaveMane;
    }

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(sex, feline);
    }

    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void testDoesHaveMane() {
        boolean actual = lion.doesHaveMane();
        assertEquals(expectedHaveMane, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}