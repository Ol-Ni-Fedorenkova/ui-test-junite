package org.example.elements;

public enum Locators {
    BUTTON_LINK(".//a[normalize-space(text())='%s']"),
    BUTTON_ID(".//span[@id='%s']"),
    BUTTON(".//button[normalize-space(text())='%s']"),
    INPUT_ID(".//input[@id='%s']");
    String value;

    Locators(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
