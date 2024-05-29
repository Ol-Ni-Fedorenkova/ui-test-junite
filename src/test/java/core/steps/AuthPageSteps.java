package core.steps;

import core.objects.User;
import core.pages.AuthPage;
import core.pages.BasePage;
import core.pages.PageType;
import io.qameta.allure.Step;

public class AuthPageSteps extends BaseSteps{

    private AuthPage authPage;

    public AuthPageSteps setAuthPage(BasePage authPage) {
        this.authPage = (AuthPage) authPage;
        return this;
    }

    @Step("авторизуемся корректными данными")
    public MainPageSteps submitCorrect(User user) {
        submit(user);
        MainPageSteps pageSteps = new MainPageSteps();
        this.loadPage(PageType.MAIN);
        pageSteps.setPage(super.getPage());
        return pageSteps;
    }

    @Step("авторизуемся некорректными данными")
    public AuthPageSteps submitError() {
        User user = new User("FDGE");
        submit(user);
        return this;
    }

    private void submit(User user) {
        fillField(authPage.getLoginInp(), user.getLogin());
        fillField(authPage.getPasswordInp(), user.getPassword());
        click(authPage.getSubmitBtn());
    }
}
