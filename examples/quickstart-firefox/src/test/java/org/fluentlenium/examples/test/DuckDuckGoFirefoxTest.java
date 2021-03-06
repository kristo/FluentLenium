package org.fluentlenium.examples.test;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.examples.pages.DuckDuckMainPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DuckDuckGoFirefoxTest extends FluentTest {

    private static final String PATH_TO_GECKO_DRIVER = "C:\\drivers\\geckodriver.exe";
    private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";

    @Page
    private DuckDuckMainPage duckDuckMainPage;

    @BeforeClass
    public static void setup() {
        if (System.getProperty(GECKO_DRIVER_PROPERTY) == null) {
            System.setProperty(GECKO_DRIVER_PROPERTY, PATH_TO_GECKO_DRIVER);
        }
    }

    @Override
    public WebDriver newWebDriver() {
        return new FirefoxDriver();
    }

    @Test
    public void titleOfDuckDuckGoShouldContainSearchQueryName() {
        String searchPhrase = "searchPhrase";

        goTo(duckDuckMainPage)
                .typeSearchPhraseIn(searchPhrase)
                .submitSearchForm()
                .assertIsPhrasePresentInTheResults(searchPhrase);
    }

}