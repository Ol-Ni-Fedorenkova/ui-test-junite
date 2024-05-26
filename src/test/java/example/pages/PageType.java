package example.pages;

public enum PageType {
    MAIN ("Главная страница"),//TODO Добавить нормальные имена для страниц (для отображения в отчете)
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
