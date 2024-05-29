package core.pages;

public enum PageType {
    MAIN ("Главная страница"),
    WELCOME ("Страница приветствия"),
    AUTH ("Страница авторизации");

    private String value;

    PageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
