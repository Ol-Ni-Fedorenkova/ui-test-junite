package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.BaseElement;

public abstract class BasePage {
    protected static final Logger LOGGER = LogManager.getLogger();

    public abstract BaseElement getElement(String name);
    public abstract void checkLoadPage();

    public BasePage loadPage (PageType name) {
        BasePage page = new PageFactory().getPage(name);
        page.checkLoadPage();
        return page;
    }

    public BasePage click(String name) {
        this.getElement(name).click();
        return this;
    }

    public BasePage fillField(String name, String value) {
        this.getElement(name).fillField(value);
        return this;
    }

}
