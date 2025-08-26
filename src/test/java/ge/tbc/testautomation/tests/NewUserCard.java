package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.CreditSteps;
import ge.tbc.testautomation.steps.ErtguliSteps;
import ge.tbc.testautomation.steps.loansSteps;
import ge.tbc.testautomation.steps.tbcCardSteps;
import ge.tbc.testautomation.util.RetryAnalyzer;
import ge.tbc.testautomation.util.RetryCount;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.constants.Consts.SEARCH_CHOICE;
import static ge.tbc.testautomation.constants.Consts.SEARCH_WORD;

public class NewUserCard extends BaseTest {
    tbcCardSteps cardSteps= new tbcCardSteps();
    ErtguliSteps ertguliSteps=new ErtguliSteps();

    @Test(description="Not Authorised User Getting New Standard Tbc Card [SCRUM-T6]",
            retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 3)
    public void userStandardCardTest(){

        //commonSteps
        cardSteps.cookiesAccept().
                navigateToCardsPage().
                validateCardsRedirection();
        //tbcCardsSteps
        cardSteps.validateOffers()
                .clickCardButton();

        String qrText = cardSteps.extractQrCodeFromCanvas();

        cardSteps.validateQrCodeExtraction(qrText)
                .navigateToQrUrl(qrText)
                .validateUrlRedirection();
    }

    @Test(description="\"ერთგული\" card application after searching [SCRUM-T7]",
            retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 3)
    public void userErtguliCardTest(){
        //commonSteps
        ertguliSteps.cookiesAccept().
                SearchClick()
                .searchValidation()
                .searchWord(SEARCH_WORD)
                .SearchValidation(SEARCH_WORD)
                .searchResultClick(SEARCH_CHOICE)
                .cardRedirectValidation();

        //ertguliSteps
        ertguliSteps.clickSubscribe()
                .scrollABitForElementToAppear()
                .clickRequestCard()
                .validateInputFields()
                .fillForm()
                .submitRequest();
    }
}
