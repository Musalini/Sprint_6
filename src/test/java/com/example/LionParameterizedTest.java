package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

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

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(feline, sex);
    }

    @Test
    public void testVerifyLionHasMane() {
        boolean expectedHasMane = hasMane;
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, actualHasMane);
    }
}
