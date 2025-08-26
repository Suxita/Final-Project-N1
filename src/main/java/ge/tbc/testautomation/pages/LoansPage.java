package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.steps.CommonSteps;

import static com.codeborne.selenide.Selenide.$x;

public class LoansPage extends CommonPage {
    public SelenideElement wannaCreditButton=$x("//a[@href='https://tbcbank.onelink.me/YiId/ularj23r']");
    public  SelenideElement overdraftLink=$x("//a[@href='/ka/loans/overdraft']");

}
