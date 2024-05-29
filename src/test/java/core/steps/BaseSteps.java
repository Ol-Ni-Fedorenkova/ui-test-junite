package core.steps;

import core.elements.BaseElement;
import core.pages.BasePage;
import core.pages.PageFactory;
import core.pages.PageType;
import core.utils.DriverManager;
import core.utils.PropertiesManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@Data
public class BaseSteps {
    private BasePage page;

    public void setUpDriverSettings() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    public WelcomePageSteps openBaseUrl() {
        WebDriver driver = DriverManager.getDriver();
        String baseUrl = PropertiesManager.getINSTANCE().getProperties().getProperty("base.url");
        driver.get(baseUrl);
        Allure.link(baseUrl, baseUrl);
        WelcomePageSteps pageSteps = new WelcomePageSteps();
        this.loadPage(PageType.WELCOME);
        pageSteps.setWelcomePage(page);
        return pageSteps;
    }

    protected void loadPage(PageType name) {
        Allure.step("загрузка страницы " + name.getValue());
        setPage(new PageFactory().getPage(name));
        getPage().checkLoadPage();
    }

    public void click(BaseElement element) {
        Allure.step(String.format("нажимаем на \"%s\"", element.getName()));
        element.click();
    }

    public void fillField(BaseElement element, String value) {
        Allure.step(String.format("в поле \"%s\" вводим значение \"%s\"", element.getName(), value));
        element.fillField(value);
    }
}
