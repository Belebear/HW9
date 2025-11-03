package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PracticeFormTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Maxim")
                .setLastName("Barkalov")
                .setGender("Male")
                .setUserEmail("akjfg@mail.ru")
                .setSubjectInput("Ma")
                .setUserNumber("1231231231")
                .setHobbiesWrapper("Reading")
                .setStateCityWrapper("Select State")
                .setStateCityWrapper("Select City")
                .setCurrentAddress("aksjdh")
                .setUploadPicture()
                .setDateOfBirth("21", "July", "1997")
                .setSubmit();

        practiceFormPage.checkResultTable("Student Name", "Maxim Barkalov")
                .checkResultTable("Student Email", "akjfg@mail.ru")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "1231231231")
                .checkResultTable("Date of Birth", "21 July,1997")
                .checkResultTable("Subjects", "Maths")
                .checkResultTable("Hobbies", "Reading")
                .checkResultTable("Picture", "testFile.png")
                .checkResultTable("Address", "aksjdh")
                .checkResultTable("State and City", "Rajasthan Jaiselmer");
    }

    @Test
    void minFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Maxim")
                .setLastName("Barkalov")
                .setGender("Male")
                .setUserNumber("1231231231")
                .setSubmit();

        practiceFormPage.checkResultTable("Student Name", "Maxim Barkalov")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "1231231231")
                .checkResultTable("Date of Birth", LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH)));

        practiceFormPage.checkMinResultTable("Subjects")
                .checkMinResultTable("Hobbies")
                .checkMinResultTable("Picture")
                .checkMinResultTable("Address")
                .checkMinResultTable("Student Email")
                .checkMinResultTable("State and City");
    }

    @Test
    void emptyFormTest() {
        practiceFormPage.openPage()
                .setSubmit()
                .checkRedBorderColor();
    }
}