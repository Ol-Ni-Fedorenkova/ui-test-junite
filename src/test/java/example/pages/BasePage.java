package example.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import example.elements.BaseElement;

public abstract class BasePage {
    protected static final Logger LOGGER = LogManager.getLogger();

    public abstract BaseElement getElement(String name);
    public abstract void checkLoadPage();

    @Step("загрузка страницы {name}")
    public BasePage loadPage (PageType name) {
        BasePage page = new PageFactory().getPage(name);
        page.checkLoadPage();
        return page;
    }

    @Step("нажимаем на {name}")
    public BasePage click(String name) {
        this.getElement(name).click();
        return this;
    }

    @Step("в поле {name} вводим значение {value}")
    public BasePage fillField(String name, String value) {
        this.getElement(name).fillField(value);
        return this;
    }

}
