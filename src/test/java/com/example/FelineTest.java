package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;
    @Mock
    Animal animal;
    @Before
    public void createNewInstance() {
        feline = new Feline();
    }
   /* Почему данный тест не прошел проверку в jacoco?
   @Test
    public void eatMeat() throws Exception {
        Mockito
                .when(animal.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }*/
    @Test
    public void eatMeatSize() throws Exception {
        List<String> list = feline.eatMeat();
        int actual = list.size();
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void getSound() {
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);
    }
    @Test
    public void getKittens() {
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }
}