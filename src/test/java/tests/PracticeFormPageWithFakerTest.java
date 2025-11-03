package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static io.qameta.allure.Allure.step;
import static utils.RandomTestData.*;

public class PracticeFormPageWithFakerTest extends BaseTest {

    String firstName = getFirstName();
    String lastName = getLastName();
    String userEmail = getUserEmail();
    String userNumber = getUserNumber();
    String gender = getGender();
    String address = getAddress();
    String hobbies = getHobbies();
    String subjects = getSubjects();
    String day = getDay();
    String month = getMonth();
    String year = getYear();
    String state = getState();
    String city = getCity(state);

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Заполнение всех форм и провекра их значений в результирующей таблице")
    @Tag("demoqaHW")
    void fillFormTest() {
        step("Открытие страницы demoqa", () -> practiceFormPage.openPage());
        step("Ввод имени", () -> practiceFormPage.setFirstName(firstName));
        step("Ввод фамилии", () -> practiceFormPage.setLastName(lastName));
        step("Выбор пола", () -> practiceFormPage.setGender(gender));
        step("Ввод email", () -> practiceFormPage.setUserEmail(userEmail));
        step("Выбор шокльного предмета", () -> practiceFormPage.setSubjectInput(subjects));
        step("Ввод телефона", () -> practiceFormPage.setUserNumber(userNumber));
        step("Выбор хобби", () -> practiceFormPage.setHobbiesWrapper(hobbies));
        step("Выбор штата", () -> practiceFormPage.setStateCityWrapper("Select State", state));
        step("Выбор города", () -> practiceFormPage.setStateCityWrapper("Select City", city));
        step("Ввод адреса", () -> practiceFormPage.setCurrentAddress(address));
        step("Загрузка картинки", () -> practiceFormPage.setUploadPicture());
        step("Ввод даты рождения", () -> practiceFormPage.setDateOfBirth(day, month, year));
        step("Клик на кнопку подтверждения", () -> practiceFormPage.setSubmit());

        step("Проверка таблицы", () -> practiceFormPage.checkResultTable("Student Name", firstName + " " + lastName)
                .checkResultTable("Student Email", userEmail)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", userNumber)
                .checkResultTable("Date of Birth", day + " " + month + "," + year)
                .checkResultTable("Subjects", subjects)
                .checkResultTable("Hobbies", hobbies)
                .checkResultTable("Picture", "testFile.png")
                .checkResultTable("Address", address)
                .checkResultTable("State and City", state + " " + city));
    }

    @Test
    @DisplayName("Заполнение обязательных полей и провекра их значений в результирующей таблице")
    @Tag("demoqaHW")
    void minFormTest() {
        step("Открытие страницы demoqa", () -> practiceFormPage.openPage());
        step("Ввод имени", () -> practiceFormPage.setFirstName(firstName));
        step("Ввод фамилии", () -> practiceFormPage.setLastName(lastName));
        step("Выбор пола", () -> practiceFormPage.setGender(gender));
        step("Ввод телефона", () -> practiceFormPage.setUserNumber(userNumber));
        step("Клик на кнопку подтверждения", () -> practiceFormPage.setSubmit());

        step("Проверка таблицы", () -> practiceFormPage.checkResultTable("Student Name", firstName + " " + lastName)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", userNumber)
                .checkResultTable("Date of Birth", LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH))));

        step("Проверка таблицы с минимальными значениями", () -> practiceFormPage.checkMinResultTable("Subjects")
                .checkMinResultTable("Hobbies")
                .checkMinResultTable("Picture")
                .checkMinResultTable("Address")
                .checkMinResultTable("Student Email")
                .checkMinResultTable("State and City"));
    }

    @Test
    @DisplayName("валидация обязательного заполнения форм")
    @Tag("demoqaHW")
    void emptyFormTest() {
        step("Открытие страницы demoqa", () -> practiceFormPage.openPage());
        step("Клик на кнопку подтверждения", () -> practiceFormPage.setSubmit());
        step("Проверка валидации", () -> practiceFormPage.checkRedBorderColor());
    }
}
