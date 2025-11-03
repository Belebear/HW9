package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    @Tag("simple")
    void fillFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserEmail(userEmail)
                .setSubjectInput(subjects)
                .setUserNumber(userNumber)
                .setHobbiesWrapper(hobbies)
                .setStateCityWrapper("Select State", state)
                .setStateCityWrapper("Select City", city)
                .setCurrentAddress(address)
                .setUploadPicture()
                .setDateOfBirth(day, month, year)
                .setSubmit();

        practiceFormPage.checkResultTable("Student Name", firstName + " " + lastName)
                .checkResultTable("Student Email", userEmail)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", userNumber)
                .checkResultTable("Date of Birth", day + " " + month + "," + year)
                .checkResultTable("Subjects", subjects)
                .checkResultTable("Hobbies", hobbies)
                .checkResultTable("Picture", "testFile.png")
                .checkResultTable("Address", address)
                .checkResultTable("State and City", state + " " + city);
    }

    @Test
    @Tag("simple")
    void minFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setSubmit();

        practiceFormPage.checkResultTable("Student Name", firstName + " " + lastName)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", userNumber)
                .checkResultTable("Date of Birth", LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH)));

        practiceFormPage.checkMinResultTable("Subjects")
                .checkMinResultTable("Hobbies")
                .checkMinResultTable("Picture")
                .checkMinResultTable("Address")
                .checkMinResultTable("Student Email")
                .checkMinResultTable("State and City");
    }

    @Test
    @Tag("simple")
    void emptyFormTest() {
        practiceFormPage.openPage()
                .setSubmit()
                .checkRedBorderColor();
    }
}
