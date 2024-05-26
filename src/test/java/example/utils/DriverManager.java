package example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        String remoteUrl = "http://192.168.1.9:4444/wd/hub";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("window-size=1920x1080");
        options.setCapability("browserVersion", "125.0");
//        options.setCapability("enableVNC", "false");
//        options.setCapability("selenoid:options", "Test");
        if (DRIVER.get() == null) {
//            WebDriverManager.chromedriver().setup();
            try {
                DRIVER.set(new RemoteWebDriver(new URL(remoteUrl), options));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
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
