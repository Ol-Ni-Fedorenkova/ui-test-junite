package tests;

import core.steps.BaseSteps;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {
    private final BaseSteps steps = STEPS.get();

    @Test
    @Feature("Проверка страницы преветствия")
    @DisplayName("Пользователь не авторизован. Поиск по названию")
    public void searchTest() {
        steps
                .openBaseUrl()
                .searchByName("Лобовое стекло");
    }
}
