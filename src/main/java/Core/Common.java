package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Common {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void getUrl(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }

    public static void clickWhenVisible(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public static void inputValue(WebDriver driver, By by, String value) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
        if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
            driver.findElement(by).click();
        driver.findElement(by).sendKeys(value);
    }

    public static boolean CheckElementOnDisplaying(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (driver.findElement(by).isDisplayed()) {
            return true;
        } else return false;
    }

    static String getText(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String str = driver.findElement(by).getText();
        return str;
    }

    static String getTextFromKavichki(WebDriver driver, int row, int column) {
        String str = driver.findElement(By.xpath("//*[@id=\"tbl\"]/tbody/tr[" + row +"]/td[" + column + "]")).getText();
        return str;
    }
}
