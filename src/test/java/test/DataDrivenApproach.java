package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.CalculatorObjects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

public class DataDrivenApproach extends FirstTests {

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter
    public String expected;


    CalculatorObjects calculator;

    @Before
    public void openCalc() {
        calculator = new CalculatorObjects(driver);
    }

    @BeforeClass
    public static void startup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String basePath = new File("").getAbsolutePath();
        driver.get("file://" + basePath + "/calc.html");
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
                {"5.03+2.001", "5.031"},
                {"78413*69856", "5477618528"},
                {"256901/236", "1088.5635593220338"},
                {"12413/-6956", "-1.784502587694077"},
                {"6.13+0.13", "6.26"},
        });

    }
}
