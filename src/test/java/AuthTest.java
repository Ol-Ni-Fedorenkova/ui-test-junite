import example.pages.PageType;
import example.pages.WelcomePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest {

    @Test
    @Feature("Проверка авторизации")
    public void authTest() {
        new WelcomePage()
                .loadPage(PageType.WELCOME)
                .click("Личный кабинет")
                .loadPage(PageType.AUTH)
                .fillField("Логин", "VIDN-16763")//TODO вынести в проперти
                .fillField("Пароль", "Olgathebest7")
                .click("Вход")
                .loadPage(PageType.MAIN);
    }
}
