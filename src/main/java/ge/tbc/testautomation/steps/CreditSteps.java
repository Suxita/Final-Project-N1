package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.CreditPage;
import ge.tbc.testautomation.pages.LoansPage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static ge.tbc.testautomation.constants.Consts.*;

public class CreditSteps extends loansSteps {

    CreditPage creditPage=new CreditPage();

    // ============ CREDIT ACTIONS ============
    public CreditSteps acceptAllCookies() {

        creditPage.allCookies.shouldBe(Condition.clickable).should(Condition.visible)
                .click();
        return this;
    }
    public CreditSteps validateExistenceOfCreditInput(){
        creditPage.creditAmountField
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible);

        creditPage.monthAmountField
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible);
        return this;
    }

    public CreditSteps enterData(){
        executeJavaScript("window.scrollTo(0, arguments[0]);",
                creditPage.monthAmountField.getRect().y);

        creditPage.monthAmountField.clear();
        creditPage.monthAmountField.sendKeys(CREDIT_MONTH_DURATION);

        return this;
    }

    public CreditSteps validatePercent(){

        creditPage.percent(EFFECTIVE_PERCENT_STRING)
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible);
        creditPage.percent(EFFECTIVE_PERCENT_STRING)
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .shouldHave(text(EFFECTIVE_PERCENT_STRING));

        creditPage.percent(PERCENT_STRING)
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible);
        creditPage.percent(PERCENT_STRING)
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .shouldHave(text(PERCENT_STRING));


        return this;
    }
    public CreditSteps requestCredit(){

        sleep(2000); //for proper loading
        executeJavaScript("window.scrollTo(0, arguments[0]);", creditPage.request.getRect().y);

        creditPage.request.shouldBe(Condition.exist)
                .shouldBe(Condition.clickable)
                .click();

        return this;
    }

    // ============ CALCULATION UTILITIES ============
    public CreditSteps validateMonthlyFeeFormula(){
        int P = Integer.parseInt(creditPage.creditAmount.text().trim());
        double n = Double.parseDouble(creditPage.monthAmount.text().trim());

        double r = (PERCENT / 100.0) / MONTH_AMOUNT;

        double PMT = P * (r * Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);

        String actualPaymentText = creditPage.actualPayment.text().trim();
        double actualPayment = Double.parseDouble(actualPaymentText);

        System.out.println("Calculated PMT: " + String.format("%.2f", PMT));
        System.out.println("Actual Payment: " + actualPayment);
        System.out.println("Difference: " + Math.abs(PMT - actualPayment));

        Assert.assertTrue(isPmtWithinTolerance(PMT, actualPayment),
                "PMT calculation mismatch. Expected: " + String.format("%.2f", PMT) +
                                ", Actual: " + actualPayment);
        return this;
    }

    public boolean isPmtWithinTolerance(double calculatedPmt, double displayedPmt) {
        double tolerance = 1.0; // Allow 1 unit difference (you can adjust this)
        boolean isWithinTolerance = Math.abs(calculatedPmt - displayedPmt) <= tolerance;


        return isWithinTolerance;
    }


}
