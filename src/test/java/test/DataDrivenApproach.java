package test;

import objects.CalculatorObjects;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DataDrivenApproach extends FirstTests {

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;


    private static CalculatorObjects calculator;

    @BeforeClass
    public static void openCalc() {
        calculator = new CalculatorObjects(driver);
    }

    @After
    public void clearCalc() {
        calculator.click_clean();
    }

    @Test
    public void calculatorDataDriven() {
        Assert.assertEquals(expected, calculator.calculate(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"3+5", "8"},
                {"100+250", "350"},
                {"100/2", "50"},
                {"230-30", "200"},
                {"0-14", "-14"},
                {"5.03+2.001", "7.031000000000001"},
                {"78413x69856", "5477618528"},
                {"256901/236", "1088.5635593220338"},
                {"12413/-6956", "-1.784502587694077"},
                {"6.13+0.13", "6.26"},
        });

    }
}
