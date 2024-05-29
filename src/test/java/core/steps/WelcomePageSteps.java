package core.steps;

import core.pages.BasePage;
import core.pages.PageType;
import core.pages.WelcomePage;
import io.qameta.allure.Step;

public class WelcomePageSteps extends BaseSteps {
    private WelcomePage welcomePage;

    public WelcomePageSteps setWelcomePage(BasePage welcomePage) {
        this.welcomePage = (WelcomePage) welcomePage;
        return this;
    }

    @Step("Переходим на страницу авторизации")
    public AuthPageSteps toAuthPage() {
        click(welcomePage.getToAuthPageBtn());
        AuthPageSteps authPageSteps = new AuthPageSteps();
        this.loadPage(PageType.AUTH);
        authPageSteps.setAuthPage(super.getPage());
        return authPageSteps;
    }

    @Step("Поиск по названию \"{value}\"")
    public WelcomePageSteps searchByName(String value) {
        welcomePage.getSearchByNameInp().fillField(value);
        welcomePage.getSearchBtn().click();
        return this;
    }
}
