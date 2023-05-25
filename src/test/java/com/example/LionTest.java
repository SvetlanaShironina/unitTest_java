package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    @Mock
    Feline feline;
    private static final String VALID_SEX_MALE = "Самец";

    @Test(expected = Exception.class)
    public void checkExceptionCreateLion() throws Exception {
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
