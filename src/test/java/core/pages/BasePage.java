package core.pages;

import core.elements.BaseElement;

public abstract class BasePage {

    public abstract BaseElement getElement(String name);

    public abstract void checkLoadPage();

}
