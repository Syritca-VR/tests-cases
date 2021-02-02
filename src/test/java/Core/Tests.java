package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Tests {

    public static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, testName = "openYandexMarket")
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(4000);
        String googleUrl = driver.getCurrentUrl();
        assert googleUrl.equals("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("яндекс маркет");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]")).click();
        Thread.sleep(3000);
        String marketLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3/span")).getText();
        assert marketLink.startsWith("Яндекс.Маркет");
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3/span")).click();
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
        driver.findElement(By.xpath("//*[@id=\"header-search\"]")).sendKeys("пылесосы");
        driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div._2lRCim4LLL > noindex > div > div > div._1GYM8vbLKv > div._2zPWBCw2Ic > div > form > div > div:nth-child(2) > button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[1]/div/div[2]/div[1]/div/div/div[1]/a/div[2]")).click();
        Thread.sleep(3000);
        Actions scroll = new Actions(driver);
        WebElement onlyInSale = driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[4]/div/div/fieldset/div/label/div"));
        scroll.moveToElement(onlyInSale).release().perform();
        onlyInSale.click();
        driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[3]/div/div/fieldset/ul/li[11]/div/a/label/div")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[3]/div/div/fieldset/footer/button")).click();
        driver.findElement(By.xpath("//*[@id=\"7893318-suggester\"]")).sendKeys("polaris");
        driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[3]/div/div/fieldset/ul/li/div/a/label/div")).click();
        driver.findElement(By.xpath("//*[@id=\"glpriceto\"]")).sendKeys("6001");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/div/ul"));
        Thread.sleep(3000);
        WebElement showAll = driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[3]/div/div/a/span"));
        scroll.moveToElement(showAll).release().perform();
        showAll.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/div/div/div[3]/div/div/a[2]")).click();
        Thread.sleep(3000);
        scroll.moveToElement(driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[4]/div/div/fieldset/div/label/div"))).release().perform();
        Thread.sleep(5000);
    }
}
