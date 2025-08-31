package ge.tbc.testautomation.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.steps.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.constants.Consts.BASE_URL;

public class BaseTest {
    private WebDriver driver;


    @BeforeClass
    @Parameters({"browserType", "deviceType"})
    public void setUp(@Optional("chrome") String browserType, @Optional("mobile") String deviceType) {
        Configuration.headless = false;
        Configuration.baseUrl = BASE_URL;
        Configuration.savePageSource = true;

        Configuration.timeout = 10000;
        if (browserType.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        WebDriverRunner.setWebDriver(driver);

        if (deviceType.equals("desktop")) {
            driver.manage().window().maximize();
        } else if (deviceType.equals("mobile")) {

            driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 669));
        }

    }

    @BeforeMethod
    public void openPage() {
        open("/ka");

    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}