package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

@BeforeAll
    public static void setUp() {
        Configuration.browserSize = "2560 1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
