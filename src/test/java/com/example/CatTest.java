package com.example;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
    public class CatTest{
    private Cat cat;
    @Mock
    Feline feline;

    @Before
    public void createNewInstance() {
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception  {
        Mockito
                .when(feline.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}

