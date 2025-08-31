package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import ge.tbc.testautomation.pages.CommonPage;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;

import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static ge.tbc.testautomation.constants.Consts.*;

public class CommonSteps {
    CommonPage page=new CommonPage();

    // ============ NAVIGATION METHODS ============

    public  CommonSteps NavigateLoans(){
        page.loansLink .should(Condition.exist)
                .shouldBe(Condition.visible)
                .click();

        return this;
    }

    public CommonSteps navigateToCardsPage() {
        page.getTbcCard.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .click();
        return this;
    }


    // ============ URL VALIDATION METHODS ============
    public CommonSteps validateLoansRedirection(){
        webdriver().shouldHave(urlContaining(LOANS_URL));
        return this;
    }
    public CommonSteps validateCardsRedirection() {
        webdriver().shouldHave(urlContaining(CARDS_URL));
    return this;
    }

    public CommonSteps  validateMapPageRedirection() {
        webdriver().shouldHave(urlContaining(ATM_URL));
        return this;

    }
    public CommonSteps cardRedirectValidation() {
        webdriver().shouldHave(urlContaining(ERTGULI_URL));


        return this;
    }

    public CommonSteps cookiesAccept(){
        try {
            page.cookieAction.should(Condition.exist, Duration.ofSeconds(2)).click();
        } catch (ElementNotFound | TimeoutException e) {
        }
        return this;
    }


    public CommonSteps SearchClick() {
        page.SearchIcon.should(Condition.visible)
                .shouldBe(Condition.clickable)
                .click();


        return this;
    }
    public CommonSteps  acordionButtonClick () {
        page.cardionButton.shouldBe(Condition.visible).click();
        return this;
    }
    public CommonSteps  atmButtonClick () {

        page.atmBranchPageRedirect.shouldBe(Condition.visible)
                .shouldBe(Condition.clickable).click();

        return this;

    }
    public CommonSteps searchValidation() {
        page.searchHeader.should(Condition.exist).should(Condition.visible);
        page.searchInputField.should(Condition.exist).should(Condition.clickable);

        return this;
    }
    public CommonSteps searchWord(String word) {
        page.searchInputField.click();
        page.searchInputField.sendKeys(word);

        return this;
    }
    public CommonSteps SearchValidation(String word){
        page.searchResults.forEach(element -> {
            element.shouldBe(Condition.exist)
                    .shouldBe(Condition.visible)
                    .shouldBe(Condition.partialText(word));
        });

    return this;
    }

    public CommonSteps searchResultClick(String Elemnt) {
        page.ourSearchChoice(Elemnt).shouldBe(Condition.exist)
                .shouldBe(Condition.clickable)
                .click();
        return this;
    }


}
