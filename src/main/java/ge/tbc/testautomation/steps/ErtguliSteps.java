package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import ge.tbc.testautomation.pages.ErtguliPage;
import ge.tbc.testautomation.util.Helper;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.util.Helper.closeTab;


public class ErtguliSteps extends CommonSteps{

    ErtguliPage ertguliPage=new ErtguliPage();
    private Faker faker = new Faker();


    // ============ FORM HANDLING ============
    public ErtguliSteps validateInputFields() {

        ertguliPage.NameInput.shouldBe(Condition.exist);
        ertguliPage.idNumber.shouldBe(Condition.exist);
        ertguliPage.phoneNumber.shouldBe(Condition.exist);
        return this;
    }

    public ErtguliSteps fillForm() {
        String fullName = faker.name().fullName();
        String idNumber = faker.number().digits(11);
        String phoneNumber = faker.number().digits(9);

        // Fill the form fields
        ertguliPage.NameInput.setValue(fullName);
        ertguliPage.idNumber.setValue(idNumber);
        ertguliPage.phoneNumber.setValue(phoneNumber);

        return this;
    }

    public ErtguliSteps submitRequest() {
        ertguliPage.submitRequest.shouldBe(Condition.clickable)
                .click();
        return this;
    }

    public ErtguliSteps clickSubscribe() {


        closeTab(); //helper, helps driver to concentrate on new tab
        ertguliPage.subscribeSParent.scrollIntoView(true);

        ertguliPage.subscribe.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .click();
        return this;
    }
    // ============ SUBSCRIPTION PROCESS ============
    public ErtguliSteps clickRequestCard() {

        ertguliPage.requestErtguli.scrollIntoView(true)
                .should(Condition.visible)
                .click();

        return this;
    }

    public ErtguliSteps scrollABitForElementToAppear() {

        Long originalScrollY = (Long) executeJavaScript("return window.scrollY;");

        executeJavaScript(
                "arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});",
                ertguliPage.scrollElement
        );

        ertguliPage.requestErtguli.should(Condition.appear);

        executeJavaScript("window.scrollTo(0, arguments[0]);", originalScrollY);

        return this;
    }
}
