//package com.example;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//public class LionWrongSexTest {
//    private Feline feline = Mockito.mock(Feline.class);
//
//    @Test
//    public void testLionThrowsException() {
//        Exception exception = Assert.assertThrows(Exception.class, () -> {
//            new Lion(feline, "Неправильный пол");
//        });
//        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
//        String actualMessage = exception.getMessage();
//        Assert.assertTrue(actualMessage.contains(expectedMessage));
//    }
//}
