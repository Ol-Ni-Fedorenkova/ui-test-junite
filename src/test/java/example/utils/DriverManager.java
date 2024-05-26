package example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            WebDriverManager.chromedriver().setup();
            DRIVER.set(new ChromeDriver());
        }
        return DRIVER.get();
    }

    public static void driverKill() {
        if(DRIVER.get()!=null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }


}
