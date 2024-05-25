package utils;

import org.example.pages.BasePage;
import org.example.utils.DriverManager;
import org.example.utils.PropertiesManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(PropertiesManager.getINSTANCE().getProperties().getProperty("base.url"));
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.getDriver().quit();
    }

//    public BasePage open() {
//
//    }
}
