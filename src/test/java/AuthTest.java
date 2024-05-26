import example.pages.AuthPage;
import example.pages.PageType;
import example.pages.WelcomePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest {

    @Test
    @Feature("Проверка авторизации")
    @DisplayName("Авторизация. Корректные креды.")
    public void authTest() {
        new AuthPage()
                .loadPage(PageType.AUTH)
                .fillField("Логин", "VIDN-16763")//TODO вынести в проперти
                .fillField("Пароль", "Olgathebest7")
                .click("Вход")
                .loadPage(PageType.MAIN);
    }

    @Test
    @Feature("Проверка авторизации")
    @DisplayName("Авторизация. Некорректные креды.")
    public void authFailTest() {
        new WelcomePage()
                .loadPage(PageType.WELCOME)
                .click("Личный кабинет")
                .loadPage(PageType.AUTH)
                .fillField("Логин", "FDGE")//TODO вынести в проперти
                .fillField("Пароль", "DKLKFLS")
                .click("Вход")
                .loadPage(PageType.AUTH);
    }
}
