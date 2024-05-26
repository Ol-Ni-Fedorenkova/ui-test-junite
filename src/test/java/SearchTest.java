import example.pages.PageType;
import example.pages.WelcomePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    @Test
    @Feature("Проверка страницы преветствия")
    @DisplayName("Пользователь не авторизован. Поиск по названию")
    public void searchTest() {
        new WelcomePage()
                .loadPage(PageType.WELCOME)
                .fillField("Поиск по названию", "Лобовое стекло")
                .click("Найти")
                .loadPage(PageType.WELCOME);
    }
}
