package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private Lion lion;
    private final String sex;
    private final boolean expected;
    @Mock
    Feline feline;

    public LionParametrizedTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: sex - {0}, doesHaveMane() - {1}")
    public static Object[][] expectedLionIsCreate() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkCreateLionSex() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }
}