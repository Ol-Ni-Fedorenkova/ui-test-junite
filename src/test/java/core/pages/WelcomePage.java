package core.pages;

import core.elements.BaseElement;
import core.elements.Button;
import core.elements.Input;
import core.elements.Locators;
import core.utils.DriverManager;
import core.utils.Messages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WelcomePage extends BasePage {

    private Button toAuthPageBtn;
    private Input searchByNameInp;
    private Button searchBtn;

    @Override
    public BaseElement getElement(String name) {
        switch (name) {
            case "Личный кабинет":
                return new Button(name, Locators.BUTTON_LINK.getValue());
            case "Поиск по названию":
                return new Input(name, Locators.INPUT_PLACEHOLDER.getValue());
            case "Найти":
                return new Button(name, Locators.BUTTON.getValue());
            default:
                throw new AssertionError(String.format(Messages.MESSAGE_ERROR_NOT_INSTANCE_ELEMENT_ON_PAGE.getValue(), PageType.WELCOME.name(), name));
        }
    }

    @Override
    public void checkLoadPage() {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
        wait.until(ExpectedConditions.visibilityOf(getElement("Личный кабинет").getElement()));
    }

    public BaseElement getToAuthPageBtn() {
        return getElement("Личный кабинет");
    }

    public BaseElement getSearchByNameInp() {
        return getElement("Поиск по названию");
    }

    public BaseElement getSearchBtn() {
        return getElement("Найти");
    }
}
