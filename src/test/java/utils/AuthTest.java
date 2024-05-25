package utils;
import org.example.pages.PageType;
import org.example.pages.WelcomePage;
import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest {

    @Test
    public void authTest() {
        new WelcomePage()
                .loadPage(PageType.WELCOME)
                .click("Личный кабинет")
                .loadPage(PageType.AUTH)
                .fillField("Логин", "VIDN-16763")
                .fillField("Пароль", "Olgathebest7")
                .click("Вход")
                .loadPage(PageType.MAIN);
    }
}
