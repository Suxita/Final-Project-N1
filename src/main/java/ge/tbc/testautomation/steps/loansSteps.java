package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.LoansPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static ge.tbc.testautomation.constants.Consts.CREDIT_URL;
import static ge.tbc.testautomation.constants.Consts.LOANS_URL;
import static ge.tbc.testautomation.util.Helper.closeTab;

public class loansSteps extends CommonSteps{

    LoansPage loansPage=new LoansPage();
    public loansSteps navigateCreditPage(){
        loansPage.wannaCreditButton.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .click();


        return this;

    }

    public loansSteps validateCreditRedirection(){

        closeTab();
        webdriver().shouldHave(urlContaining(CREDIT_URL));
        return this;
    }


}
