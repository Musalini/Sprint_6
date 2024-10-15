package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private Feline feline;
    private Lion lion;
    private String sex;
    private boolean hasMane;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(feline, sex);
    }

    @Test
    public void testReturnCorrectNumberOfKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        int actualKittens = lion.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testVerifyLionHasMane() {
        boolean expectedHasMane = hasMane;
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void testReturnCorrectFoodForLion() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testThrowExceptionForInvalidSex() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion(feline, "Некорректное значение пола");
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}