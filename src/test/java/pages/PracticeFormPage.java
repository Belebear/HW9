package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            stateCityWrapper = $("#stateCity-wrapper"),
            uploadPicture = $("#uploadPicture"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();


    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setSubjectInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public PracticeFormPage setStateCityWrapper(String value, String name) {
        switch (value) {
            case "Select State":
                stateCityWrapper.$(byText(value)).click();
                stateCityWrapper.$(byText(name)).click();
                break;
            case "Select City":
                stateCityWrapper.$(byText(value)).click();
                stateCityWrapper.$(byText(name)).click();
                break;
        }
        return this;
    }

    public PracticeFormPage setUploadPicture() {
        uploadPicture.uploadFromClasspath("testFile.png");

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubmit() {
        submit.click();

        return this;
    }

    public PracticeFormPage checkMinResultTable(String key) {
        resultComponent.checkMinResult(key);

        return this;
    }

    public PracticeFormPage checkResultTable(String key, String value) {
        resultComponent.checkResult(key, value);

        return this;
    }

    public PracticeFormPage checkRedBorderColor() {
        firstName.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        lastName.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        genterWrapper.$(byText("Male")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        genterWrapper.$(byText("Female")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        genterWrapper.$(byText("Other")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        userNumber.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

}
