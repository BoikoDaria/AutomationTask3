package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class FirstTests {

    public static WebDriver driver;

    @BeforeClass
    public static void startup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String basePath = new File("").getAbsolutePath();
        driver.get("file://" + basePath + "/calc.html");
    }

    @AfterClass
    public static void cleanup() {
        driver.quit();
    }
}
