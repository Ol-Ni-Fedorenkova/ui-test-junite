package example.pages;

import example.elements.BaseElement;
import example.elements.Locators;
import example.utils.DriverManager;
import example.utils.Messages;
import example.elements.Button;
import example.elements.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AuthPage extends BasePage{
    @Override
    public BaseElement getElement(String name) {
        switch (name){
            case "Логин":
                return new Input("Login", Locators.INPUT_ID.getValue());
            case "Пароль":
                return new Input("Password", Locators.INPUT_ID.getValue());
            case "Вход":
                return new Button(name, Locators.BUTTON.getValue());
            default: throw new AssertionError(String.format(Messages.MESSAGE_ERROR_NOT_INSTANCE_ELEMENT_ON_PAGE.getValue(), PageType.AUTH.name(), name));
        }
    }

    @Override
    public void checkLoadPage() {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
        wait.until(ExpectedConditions.visibilityOf(getElement("Логин").getElement()));
    }
}
