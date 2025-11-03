package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private SelenideElement tableResponsive = $(".table-responsive");

    public void checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkMinResult(String key) {
        tableResponsive.$(byText(key)).parent().lastChild().shouldBe(empty);
    }
}
