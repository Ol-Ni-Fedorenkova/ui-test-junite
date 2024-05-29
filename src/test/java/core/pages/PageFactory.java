package core.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PageFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public BasePage getPage(PageType pageType) {
        switch (pageType) {
            case AUTH:
                return new AuthPage();
            case MAIN:
                return new MainPage();
            case WELCOME:
                return new WelcomePage();
            default:
                LOGGER.error("Не удалось определить страницу");
                throw new AssertionError("Не удалось определить страницу");
        }
    }
}
