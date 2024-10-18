package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    @Test
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFoods = List.of("Трава", "Различные растения");
        assertEquals(expectedFoods, animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodErrorMessageTest() {
        Animal animal = new Animal();
        String errorMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Мышь"));
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}
