package core.steps;

import core.pages.BasePage;
import core.pages.MainPage;

public class MainPageSteps extends BaseSteps{
    private MainPage mainPage;

    public void setMainPage(BasePage mainPage) {
        this.mainPage = (MainPage) mainPage;
    }
}
