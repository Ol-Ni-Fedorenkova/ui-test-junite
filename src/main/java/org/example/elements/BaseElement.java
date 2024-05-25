package org.example.elements;

import lombok.Data;
import org.example.utils.DriverManager;
import org.example.utils.PropertiesManager;
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
