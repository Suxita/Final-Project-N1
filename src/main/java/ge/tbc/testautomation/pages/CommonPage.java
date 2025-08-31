package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.constants.Consts.GE_NAV_PERSONAL;

public class CommonPage {
    //NAVIGATION
    public SelenideElement engPersonal=$x(String.format("//div[contains(text(), '%s')]", GE_NAV_PERSONAL));

    public SelenideElement mapLink=$x("//a[@href='/ka/atms&branches']");
    public ElementsCollection quickmenu= $$(".tbcx-pw-mega-menu-quick-acitons-item");
    public SelenideElement cookieAction=$x("//app-cookie-consent//div[contains(@class, 'tbcx-pw-cookie-consent')]//div//button[normalize-space(text())='თანხმობა']");
    public SelenideElement cookieAgree=$x("//div[contains(@class,'tbcx-pw-cookie-consent__actions')]//button[text()=' თანხმობა ']");

    public SelenideElement mobileHamburgerMenu=$x("//button[contains(@class, 'hamburger-menu')]");


    public SelenideElement  cardionButton=$x("//tbcx-icon[contains(text(),'kebab-menu-vertical-outlined')]");
    public SelenideElement  atmBranchPageRedirect=$x("//a[@href='/ka/atms&branches']//app-quick-action-button");

    public SelenideElement getTbcCard=$x("//div[@class='tbcx-pw-cta-section__info']//tbcx-pw-link//a//button[contains(text(),'ვრცლად')]");
    public SelenideElement loansLink=$x("//a[@href='/ka/loans']");


    public SelenideElement SearchIcon= $x("//button[contains(@class,'tbcx-pw-search__button')]");

    public SelenideElement searchHeader=$x("//h2[contains(@class,'global-search__top-content')]");
    public SelenideElement searchInputField=$x("//div[contains(@class,'input-with-label label-exists')]//input");
    public ElementsCollection searchResults=$$x("//h3[@class='search-result-item__title']");
    public SelenideElement ourSearchChoice(String choice){
        return $x(String.format("//h3[@class='search-result-item__title' and contains(text(),'%s')]/following-sibling::tbcx-pw-button",
                choice));

    }
}
