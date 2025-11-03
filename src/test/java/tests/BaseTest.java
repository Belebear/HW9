package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

@BeforeAll
    public static void setUp() {
        Configuration.browserSize = "2560 1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

@BeforeEach
public void addAllureListener() {
    SelenideLogger.addListener("allure", new AllureSelenide());
}

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
