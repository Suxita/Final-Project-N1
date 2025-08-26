package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.CommonSteps;
import ge.tbc.testautomation.steps.CreditSteps;
import ge.tbc.testautomation.steps.loansSteps;
import ge.tbc.testautomation.util.RetryAnalyzer;
import ge.tbc.testautomation.util.RetryCount;
import org.testng.annotations.Test;

public class userCredit extends BaseTest {

    CreditSteps creditSteps=new CreditSteps();


    @Test(description="Full Credit Application Flow Validation For Unauthorised User [SCRUM-T8]",
            retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 3)
    public void  letsGetIntoDebt(){    //need to put everything on red

        //commonSteps
        creditSteps.cookiesAccept()
                .NavigateLoans()
                .validateLoansRedirection();

        //loanSteps
        creditSteps.navigateCreditPage()
                .validateCreditRedirection();

        //creditSteps
        creditSteps.acceptAllCookies()
                .validateExistenceOfCreditInput()
                .enterData()
                .validatePercent()
                .validateMonthlyFeeFormula()
                .requestCredit();
    }
}
