package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.steps.CommonSteps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ErtguliPage extends CommonPage {
    public SelenideElement requestErtguli=$x("//button[contains(text(),'ზარის მოთხოვნა')]");
    public SelenideElement NameInput=$x("//input[@placeholder='სახელი გვარი']");
    public SelenideElement idNumber=$x("//input[@placeholder='პირადი ნომერი']");
    public SelenideElement phoneNumber=$x("//input[@placeholder='ტელეფონის ნომერი']");
    public SelenideElement submitRequest=$x("//button[@type='submit']");
    public SelenideElement subscribe=$x("//button[text()='გამოიწერე']");
    public SelenideElement subscribeSParent=$x("//ng-component[contains(text(),'დამატებითი')]");

    public SelenideElement scrollElement=$("tbcx-pw-section-title >.tbcx-pw-section-title ");
}
