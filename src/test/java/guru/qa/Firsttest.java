package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Firsttest {

    @BeforeAll
    static void config() {
        //configParams
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

     @Test
     void fillRegistrationFormTest() {

         open("/automation-practice-form");

        //addsAndFooter
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //values
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89998887766");

        //dateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1990");
        $(".react-datepicker__day.react-datepicker__day--022").click();

        //subjects
        $("#subjectsContainer input").setValue("Physics").pressEnter();

        //hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();

         /*
        $("#uploadPicture").uploadFromClasspath("Panda");
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpeg"));
        $("#uploadPicture").uploadFromClasspath("Panda.JPG");
        */
        //currentAddress
        $("#currentAddress").setValue("111 Moscow");

        //stateAndCity
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        //formSubmit
        $("#submit").click();

        //tests
        $(".modal-content").should(appear);
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text("Ivan@gmail.com"));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text("89998887766"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("22 June,1990"));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text("Physics"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("Panda.jpg"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("111 Moscow"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("Haryana Karnal"));

    }
}
