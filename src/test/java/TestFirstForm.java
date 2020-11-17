import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestFirstForm {
    @Test
    void fillFormTest() {
        String url = "https://demoqa.com/automation-practice-form",
                firstName = "Svetlana",
                lastName = "Drankovich",
                userEmail = "Drankovich@gmail.com",
                gender = "Female",
                userNumber = "1234567890",
                subject = "English",
                currentAddress = "St.Petersburg";

        File file = new File("src/test/java/resources/test.jpg");

        open(url);
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(userEmail);
        $(byText(gender)).click();
        $("#userNumber").val(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(1);
        $(".react-datepicker__year-select").selectOption("2020");
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(subject);
        $$("#react-select-2-option-0").findBy(text(subject)).click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").scrollTo().setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText("Rajasthan")).click();
        $(byText("Select City")).click();
        $(byText("Jaipur")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following::td[1]").shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']/following::td[1]").shouldHave(text(userEmail));
        $x("//td[text()='Gender']/following::td[1]").shouldHave(text(gender));
        $x("//td[text()='Mobile']/following::td[1]").shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']/following::td[1]").shouldNot(empty);
        $x("//td[text()='Subjects']/following::td[1]").shouldHave(text(subject));
        $x("//td[text()='Hobbies']/following::td[1]").shouldNot(empty);
        $x("//td[text()='Picture']/following::td[1]").shouldNot(empty);
        $x("//td[text()='Address']/following::td[1]").shouldHave(text(currentAddress));
        $x("//td[text()='State and City']/following::td[1]").shouldNot(empty);

    }

}
