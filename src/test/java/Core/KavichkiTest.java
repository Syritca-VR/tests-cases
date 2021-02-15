package Core;

import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class KavichkiTest {

    public static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        driver = Common.getGoogleDriver();
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, testName = "getTextFromTable")
    public void getTextFromTable() throws InterruptedException, IOException, GeneralSecurityException {
        String spreadsheetId = "1hEkv8JKKDO91mUuNC7L1u1HDzi1HbDsjqQ8hoMxH6RY";
        Common.getUrl(driver,"https://checkme.kavichki.com/");
        String text = Common.getTextFromKavichki(driver, 1, 1);
        GoogleAuthorizeUtil.sendTextToGoogleTable(spreadsheetId, "E1", text);
        Thread.sleep(3000);
        ValueRange data = GoogleAuthorizeUtil.getDataFromGoogleTable(spreadsheetId, "A1", "A2", 1);
        System.out.println(data);
    }
}
