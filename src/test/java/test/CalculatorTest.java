package test;

import objects.CalculatorObjects;
import org.junit.*;

public class CalculatorTest extends FirstTests {

    CalculatorObjects calculator;

    @Before
    public void openCalc () {
        calculator = new CalculatorObjects(driver);
    }

    @After
    public void calcClean () {
        calculator.click_clean();
    }

    @Test
    public void additionTest (){
        calculator.click_3();
        calculator.click_add();
        calculator.click_9();
        calculator.click_equal();
        Assert.assertEquals("12", calculator.click_result());
    }

    @Test
    public void subtractionTest(){
        calculator.click_9();
        calculator.click_subst();
        calculator.click_6();
        calculator.click_equal();
        Assert.assertEquals("3", calculator.click_result());
    }

    @Test
    public void multiplyTest(){
        calculator.click_5();
        calculator.click_multiply();
        calculator.click_6();
        calculator.click_equal();
        Assert.assertEquals("30", calculator.click_result());
    }

    @Test
    public void divisionTest(){
        calculator.click_9();
        calculator.click_divide();
        calculator.click_3();
        calculator.click_equal();
        Assert.assertEquals("3", calculator.click_result());
    }
    @Test
    public void useDotTest (){
        calculator.click_3();
        calculator.click_dot();
        calculator.click_1();
        calculator.click_add();
        calculator.click_5();
        calculator.click_equal();
        Assert.assertEquals("8.1", calculator.click_result());
    }
    @Test
    public void useCleanTest (){
        calculator.click_4();
        calculator.click_add();
        calculator.click_5();
        calculator.click_clean();
        Assert.assertEquals("", calculator.click_result());
    }
}
