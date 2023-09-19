package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

   private Feline feline;

    @Before
    public void createNewInstance() {
        feline = new Feline();
    }

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

    @Test
    public void getKittensCount(){
        int actual = feline.getKittens(2);
        assertEquals(2, actual);
    }
}