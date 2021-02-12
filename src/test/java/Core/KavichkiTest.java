package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class KavichkiTest {

    public static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        driver = Common.getDriver();
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, testName = "getTextFromTable")
    public void getTextFromTable() throws InterruptedException {
        Common.getUrl(driver,"https://checkme.kavichki.com/");
        String text = Common.getTextFromKavichki(driver, 1, 2);
        
        //*[@id="bubble-87"]/div/div/div[2]
        //*[@id="waffle-rich-text-editor"]
        //*[@id="waffle-rich-text-editor"]

    }
}
