package webtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonIphoneSearchTest {
    ChromeOptions options;
    WebDriver driver;
    String search;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://amazon.com");

        search = "iPhone";
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void minMaxTest() throws InterruptedException {
        By navBarInput = By.id("twotabsearchtextbox");
        By chkBoxMin = By.id("low-price");
        By chkBoxMax = By.id("high-price");
        By btnGo = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
        By itemPrice = By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-13']//span[@class='a-price']//span[@class='a-price-whole']");
        By pagination = By.xpath("//div[@class='a-section a-text-center s-pagination-container']//span[@class='s-pagination-strip']//a[text()='2']");

        driver.findElement(navBarInput);
        driver.findElement(navBarInput).sendKeys(search, Keys.ENTER);
        driver.findElement(chkBoxMin).sendKeys("100");
        driver.findElement(chkBoxMax).sendKeys("150");
        driver.findElement(btnGo).click();
        Thread.sleep(3000);
        driver.findElement(pagination).click();
        Thread.sleep(3000);
        String firstItemPrice = driver.findElement(itemPrice).getText();
        Float floatPrice = Float.valueOf(firstItemPrice);

        Assert.assertTrue(floatPrice > 200 && floatPrice < 500, "Not in a range");




    }
}