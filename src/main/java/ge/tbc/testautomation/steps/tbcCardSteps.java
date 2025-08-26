package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.tbcCardPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static ge.tbc.testautomation.constants.Consts.CARDS_URL;
import static ge.tbc.testautomation.constants.Consts.CARD_LOGIN;
import static ge.tbc.testautomation.util.Helper.extractQrFromCanvas;
import static org.testng.Assert.assertNotNull;

public class tbcCardSteps extends CommonSteps {
    tbcCardPage page = new tbcCardPage();

    private String currentQrText;

    public String extractQrCodeFromCanvas() {
        String qrText = extractQrFromCanvas(page.canvas);
        System.out.println("📌 Decoded QR: " + qrText);
        this.currentQrText = qrText; // Store for chaining
        return qrText;
    }

    public tbcCardSteps validateQrCodeExtraction(String qrText) {
        assertNotNull(qrText, "QR code should be decoded");
        return this;
    }

    public tbcCardSteps navigateToQrUrl(String qrUrl) {
        open(qrUrl);
        return this;
    }

    public tbcCardSteps validateUrlRedirection() {
        webdriver().shouldHave(urlContaining(CARD_LOGIN));
        return this;
    }


    public tbcCardSteps getNextCard(){

        page.nextCard.shouldBe(Condition.visible)
                .shouldBe(Condition.exist)
                .click();


        return this;
    }
    public tbcCardSteps navigateToCardsPage() {
       page.getTbcCard.shouldBe(Condition.exist)
               .shouldBe(Condition.visible)
               .click();
        return this;
    }

    public tbcCardSteps clickCardButton() {
        page.getCardButton.click();
        return this;
    }


    public tbcCardSteps validateOffers() {
        page.offers.forEach(element -> {
            executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            element.shouldBe(Condition.clickable)
                    .click();
            page.OfferDescription.should(Condition.appear);
            element.click();
        });

    return this;
    }
}
