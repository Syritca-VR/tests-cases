package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Tests {

    public static WebDriver driver;
    static Properties html_xpath = new Properties();
    static Properties html_selector = new Properties();

    @BeforeMethod
    public static void setUp() throws IOException {
        driver = Common.getGoogleDriver();
        html_xpath.load(new FileInputStream("./locators/html_xpath.properties"));
        html_selector.load(new FileInputStream("./locators/html_selector.properties"));
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, testName = "openYandexMarket")
    public void test1() throws InterruptedException {
        Common.getUrl(driver,"https://www.google.com/");
        String googleUrl = driver.getCurrentUrl();
        Thread.sleep(2000);
        assert googleUrl.equals("https://www.google.com/");
        Common.inputValue(driver, By.cssSelector(html_selector.getProperty("google_input_text")), "яндекс маркет");
        Thread.sleep(3000);
        Common.clickWhenVisible(driver, By.cssSelector(html_selector.getProperty("search_in_google_btn")));
        Thread.sleep(3000);
        String marketLink = driver.findElement(By.xpath(html_xpath.getProperty("yandex_market_link_in_google"))).getText();
        assert marketLink.startsWith("Яндекс.Маркет");
        driver.findElement(By.xpath(html_xpath.getProperty("yandex_market_link_in_google"))).click();
        Thread.sleep(3000);
        String marketUrl = driver.getCurrentUrl();
        assert marketUrl.equals("https://market.yandex.ru/");
    }

    @Test(priority = 2, testName = "searchGoodVacuumCleaner")
    public void test2() throws InterruptedException {
        driver.get("https://market.yandex.ru/");
        Thread.sleep(4000);
        String marketUrl = driver.getCurrentUrl();
        assert marketUrl.equals("https://market.yandex.ru/");
        Thread.sleep(3000);
        Common.inputValue(driver, By.xpath(html_xpath.getProperty("search_on_yandex_market")), "пылесосы");
        Common.clickWhenVisible(driver, By.cssSelector(html_selector.getProperty("yandex_market_search_button")));
        Common.clickWhenVisible(driver, By.xpath(html_xpath.getProperty("yandex_market_vacuum_cleaner_button")));
        Actions scroll = new Actions(driver);
        WebElement onlyInSale = driver.findElement(By.xpath(html_xpath.getProperty("yandex_market_only_in_sale_button")));
        scroll.moveToElement(onlyInSale).release().perform();
        onlyInSale.click();
        Common.clickWhenVisible(driver, By.xpath(html_xpath.getProperty("vitek_vacuum_cleaners_button")));
        Common.clickWhenVisible(driver, By.xpath(html_xpath.getProperty("yandex_market_show_all")));
        Common.inputValue(driver, By.xpath(html_xpath.getProperty("search_brand")), "polaris");
        Common.clickWhenVisible(driver, By.xpath(html_xpath.getProperty("polaris_vacuum_cleaner_button")));
        Common.inputValue(driver, By.xpath(html_xpath.getProperty("yandex_market_set_price")), "6001");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/div/ul"));
        Thread.sleep(3000);
        WebElement showAll = driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[3]/div/div/a/span"));
        scroll.moveToElement(showAll).release().perform();
        showAll.click();
        Thread.sleep(3000);
        Common.clickWhenVisible(driver, By.xpath("/html/body/div[2]/section/div[2]/div/div/div[3]/div/div/a[2]"));
        Thread.sleep(3000);
        scroll.moveToElement(driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[4]/div/div/fieldset/div/label/div"))).release().perform();
        Thread.sleep(5000);
    }
}
