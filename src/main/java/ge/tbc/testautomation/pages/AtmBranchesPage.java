package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.steps.CommonSteps;

import static com.codeborne.selenide.Selenide.*;

public class AtmBranchesPage extends CommonPage {


    public SelenideElement mapComponent=$x("//google-map[@mapid='ATM_BRANCHES_MAP']");
    public ElementsCollection atmAndBranchList=$$(".tbcx-pw-atm-branches-section__list");


    public ElementsCollection mapPins=$$(".atm-branches-map-marker__background");
    //dropdown
    public SelenideElement dropdownButton=$("tbcx-dropdown-selector i");
    public SelenideElement chooseCityButton(String label){
        return $x(String.format("//div[contains(@class, 'popover-item__title') and text()='%s']", label));
    }

    //search
    public SelenideElement searchField=$("tbcx-search-input div input");



    //filterButtons
    public SelenideElement workingHoursButton(String hours){
           return  $x(String.format("//label//span[text()=' %s ']", hours));
    }
    public SelenideElement CategoryButton(String label){
        return $x(String.format("//button//span[contains(text(), '%s')]",label));
    }
    public ElementsCollection objectCategory=$$("tbcx-pw-atm-branches-section__list-item-label");
    //working hours
    public ElementsCollection objectDescription=$$x("//div[@class='tbcx-pw-atm-branches-section__list-item-description']");

}