package tests;

import core.objects.User;
import core.pages.PageType;
import core.steps.BaseSteps;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest {
    private final BaseSteps steps = STEPS.get();

    @Test
    @Feature("Проверка авторизации")
    @DisplayName("Авторизация. Корректные креды.")
    public void authTest() {
        steps
                .openBaseUrl()
                .toAuthPage()
                .submitCorrect(new User("VIDN-16763"));
    }

    @Test
    @Feature("Проверка авторизации")
    @DisplayName("Авторизация. Некорректные креды.")
    public void authFailTest() {
        steps
                .openBaseUrl()
                .toAuthPage()
                .submitError();
    }
}
