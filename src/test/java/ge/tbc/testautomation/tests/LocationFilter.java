package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.util.RetryAnalyzer;
import ge.tbc.testautomation.util.RetryCount;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.constants.Consts.*;

public class LocationFilter extends BaseTest {
    AtmBranchesSteps mapSteps=new AtmBranchesSteps();




    @Test(description="Location Search Filter [SCRUM-T1]",
            retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 3)
    public void LocationFilter() {
        //commonSteps
        mapSteps.cookiesAccept()
                .acordionButtonClick()
                .atmButtonClick()
                .validateMapPageRedirection();
        //atmBranchesSteps
        mapSteps.clickSearchField()
                .enterFilterWord(FILTER_WORD)
                .verifySearchResults(FILTER_WORD);

    }
    @Test(description=" Location Filter Dropdown City Selection (exclusive for desktop) [SCRUM-T9]",
            retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 3)
    public void LocationFilterDropDown(){
        //coomonSteps
        mapSteps.cookiesAccept()
                .acordionButtonClick()
                .atmButtonClick()
                .validateMapPageRedirection();
        //atmBranchSteps
        mapSteps.openCityDropdown()
                .selectCity(CITY_WITH_1_ATM)
                .verifyFilterResults(CITY_WITH_1_ATM);

    }

    @Test(description = "ATM/Branch Tabs and Sub-tabs Filtering [SCRUM-T5]",
    retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 3)
    public void TabsAndSubtabs() {
        //commonSteps
        mapSteps.cookiesAccept()
                .acordionButtonClick()
                .atmButtonClick()
                .validateMapPageRedirection();
        //atmBranchSteps
        mapSteps.BranchAtmSpecificFilter(CATEGORY_ATM_BUTTON)
                .validateFilterResults(CATEGORY_ATM)
                .clickWorkingHoursButton(ANYTIME)
                .verifyWorkingHoursResults(ANYTIME);


    }
}
