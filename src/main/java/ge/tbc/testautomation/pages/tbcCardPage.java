package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class tbcCardPage extends CommonPage {

    public SelenideElement getCardButton= $(".primary.size-m.ng-star-inserted.state-initial");
    public SelenideElement canvas = $("canvas.tbcx-pw-app-download-banner-popup__qr");
    public ElementsCollection offers=$$("app-tariff-tab-body button");
    public SelenideElement OfferDescription=$("tbc-accordion__wrapper ng-tns-c2478649229-397 ng-trigger ng-trigger-containerFade ng-star-inserted");

    public SelenideElement nextCard=$x("//button[contains(@class,'tbcx-pw-tab-menu__item') and contains(@class,'active')]  " +
            "/following-sibling::button[contains(@class,'tbcx-pw-tab-menu__item')]");
}
