package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreditPage  extends CommonPage{

    public SelenideElement allCookies=$x("//div[@class='cookie-side-window active']//div[@class='buttonline']//a[@id='acceptAllCookies']");
    public SelenideElement creditAmountField=$x("//input[@id='standard-calculator-amount']");
    public SelenideElement creditAmount=$x("//span[@id='standard-calculator-result-amount']");

    public SelenideElement monthAmountField=$x("//input[@id='standard-calculator-period']");
    public SelenideElement monthAmount=$x("//span[@id='standard-calculator-result-period']");

    public SelenideElement percent(String percent) {
        return $x(String.format("//div[@class='result']//div[@class='value' and contains(text(),'%s')]",percent));
    }
    public SelenideElement actualPayment=$x("//span[@id='standard-calculator-result-payment']");

    public SelenideElement request=$x("//button[@id='request-standart-loan']");
}
