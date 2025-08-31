package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.AtmBranchesPage;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.matchText;
import static ge.tbc.testautomation.constants.Consts.*;
import static ge.tbc.testautomation.util.Helper.isCurrentTimeWithinStandardHours;
import static ge.tbc.testautomation.util.Helper.isKnownEmpty;


@Slf4j
public class AtmBranchesSteps extends CommonSteps {



    private AtmBranchesPage atmpPage =new AtmBranchesPage();

    // ============ SEARCH FUNCTIONALITY ============
    public AtmBranchesSteps clickSearchField() {
        atmpPage.searchField
                .should(Condition.exist)
                .click();
        return this;
    }
    public AtmBranchesSteps enterFilterWord(String filter) {
        atmpPage.searchField.sendKeys(filter);
        return this;
    }
    public AtmBranchesSteps verifySearchResults(String filter) {
        if (isKnownEmpty(filter)) {
            atmpPage.mapPins.shouldBe(CollectionCondition.empty);
        } else {
            atmpPage.mapPins.shouldBe(CollectionCondition.sizeGreaterThan(0));
        }
        return this;
    }


    // ============ WORKING HOURS FILTERING ============

    public AtmBranchesSteps clickWorkingHoursButton(String workingHours) {
        atmpPage.workingHoursButton(workingHours)
                .shouldBe(Condition.exist)
                .should(Condition.clickable)
                .click();
        return this;
    }
    public AtmBranchesSteps verifyWorkingHoursResults(String workingHours) {
        if (workingHours.equals(ANYTIME)) {
            atmpPage.objectDescription.forEach(element -> {
                element.should(matchText(ANYTIME));
            });
        }
        else if (workingHours.equals(OPEN_NOW) && isCurrentTimeWithinStandardHours()) {
            atmpPage.objectDescription.forEach(element -> {
                element.should(matchText(STANDARD_HOURS));
            });
        }
        else {
            atmpPage.objectDescription.should(CollectionCondition.empty);
        }
        return this;
    }
    public AtmBranchesSteps verifyAnytimeResults() {
        atmpPage.objectDescription.forEach(element -> {
            element.should(matchText(ANYTIME));
        });
        return this;
    }

    public AtmBranchesSteps verifyOpenNowResults() {
        atmpPage.objectDescription.forEach(element -> {
            element.should(matchText(STANDARD_HOURS));
        });
        return this;
    }


    // ============ CATEGORY FILTERING ============
    public AtmBranchesSteps clickCategoryFilter(String categoryObject){
        atmpPage.CategoryButton(categoryObject)
                .should(Condition.exist)
                .should(Condition.clickable)
                .click();

        return this;
    }
    public AtmBranchesSteps BranchAtmSpecificFilter(String object){
        atmpPage.CategoryButton(object)
                .should(Condition.exist)
                .should(Condition.clickable)
                .click();

        if(object.equals(CATEGORY_ATM_BUTTON)){
            atmpPage.objectCategory.forEach(element -> {
                element.shouldHave(Condition.text(CATEGORY_ATM)); //every bankomat has category of bankomati
            });
        }
        else {
            atmpPage.objectCategory.forEach(element -> {
                element.shouldNotHave(Condition.text(CATEGORY_ATM)); //but any branch in category has its address
                element.should(matchText("[1-9]+"));//address always contains numbers...
            });
        }
        return this;
    }

    public AtmBranchesSteps openCityDropdown() {
        atmpPage.dropdownButton.shouldBe(Condition.clickable).click();
        log.info("Opened city dropdown");
        return this;
    }
    public AtmBranchesSteps selectCity(String cityName) {
        atmpPage.chooseCityButton(cityName).shouldBe(Condition.clickable).click();
        log.info("Selected city: {}", cityName);
        return this;
    }
    public AtmBranchesSteps verifyFilterResults(String cityName) {
        if (isKnownEmpty(cityName)) {
            atmpPage.mapPins.shouldBe(CollectionCondition.empty);
        } else {
            atmpPage.mapPins.shouldBe(CollectionCondition.sizeGreaterThan(0));
        }
        return this;
    }

    public AtmBranchesSteps verifyNoResultsFound() {
        atmpPage.objectDescription.should(CollectionCondition.empty);
        return this;
    }
    public AtmBranchesSteps validateFilterResults(String categoryObject){
        if(categoryObject.equals(CATEGORY_ATM)){
            atmpPage.objectCategory.forEach(element -> {
                element.shouldHave(Condition.text(CATEGORY_ATM)); //every bankomat has category of bankomati
            });
        }
        else {
            atmpPage.objectCategory.forEach(element -> {
                element.shouldNotHave(Condition.text(CATEGORY_ATM)); //but any branch in category has its address
                element.should(matchText("[1-9]+"));//address always contains numbers...
            });
        }
        return this;
    }
}
