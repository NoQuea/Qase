package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



public class BaseTest {

    String email, password;


    @BeforeMethod
    public void setUp(){
//        Configuration.headless = true;
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;
        Configuration.browserCapabilities = new ChromeOptions();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        getWebDriver().quit();
    }
}
