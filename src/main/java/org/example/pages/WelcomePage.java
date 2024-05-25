package org.example.pages;

import dev.failsafe.internal.util.Assert;
import org.example.elements.BaseElement;
import org.example.elements.Button;
import org.example.elements.Locators;
import org.example.utils.DriverManager;
import org.example.utils.Messages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WelcomePage extends BasePage{

    @Override
    public BaseElement getElement(String name) {
        switch (name){
            case "Личный кабинет":
                return new Button(name, Locators.BUTTON_LINK.getValue());
            default: throw new AssertionError(String.format(Messages.MESSAGE_ERROR_NOT_INSTANCE_ELEMENT_ON_PAGE.getValue(), PageType.WELCOME.name(), name));
        }
    }

    @Override
    public void checkLoadPage() {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
        wait.until(ExpectedConditions.visibilityOf(getElement("Личный кабинет").getElement()));
    }
}
