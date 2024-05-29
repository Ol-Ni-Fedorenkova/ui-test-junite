package core.utils;


public enum Messages {
    MESSAGE_ERROR_NOT_INSTANCE_ELEMENT_ON_PAGE("На странице %s не определен элемент с именем %s");
    String value;

    Messages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
