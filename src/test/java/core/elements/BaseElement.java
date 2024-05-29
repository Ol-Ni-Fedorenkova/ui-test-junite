package core.elements;

import core.utils.DriverManager;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
public abstract class BaseElement {

    private String locator;
    private String name;

    public BaseElement(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public WebElement getElement() {
        return DriverManager.getDriver().findElement(By.xpath(getLocator()));
    }

    private String getLocator() {
        return String.format(locator, getName());
    }

    public void click() {
        getElement().click();
    }

    public void fillField(String value) {
        getElement().clear();
        getElement().sendKeys(value);
    }
}
