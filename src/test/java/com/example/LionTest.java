package com.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    @Mock
    Feline feline;
    @Rule
    public ExpectedException thrown  = ExpectedException.none();
    private static final String VALID_SEX_MALE = "Самец";
    private static final String INVALID_SEX_FEMALE = "Самка";
    private static final String EXCEPTION_MESSAGE = "Используйте допустимые значения пола животного - самец или самка";

    @Test
    public void checkCreateLionSexMale() throws Exception {
        Lion lion = new Lion(VALID_SEX_MALE, feline);
        assertEquals(true, lion.doesHaveMane());
    }
    @Test
    public void checkCreateLionSexFemale() throws Exception {
        Lion lion = new Lion(INVALID_SEX_FEMALE, feline);
        assertEquals(false, lion.doesHaveMane());
    }
    @Test
    public void checkExceptionCreateLion() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage(EXCEPTION_MESSAGE);
        new Lion(null, feline);
    }
    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(VALID_SEX_MALE, feline);
        Mockito
                .when(feline.getKittens())
                .thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }
    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(VALID_SEX_MALE, feline);
        Mockito
                .when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
