package webtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonHighlightTest {

        ChromeOptions options;
        WebDriver driver;
        String search;

        @BeforeMethod
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
            options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);

            driver.get("https://amazon.com");

            search = "some search";
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }

        @Test
        public void HighlighTest(){
            By navBarBox = By.id("nav-search-bar-form");
            By navBarInput = By.id("twotabsearchtextbox");

            driver.findElement(navBarInput);
            driver.findElement(navBarInput).sendKeys(search);
            String color = driver.findElement(navBarBox).getCssValue("border-color");
            String textInBox = driver.findElement(navBarInput).getAttribute("value");

            Assert.assertEquals(color, "rgb(15, 17, 17)");
        }
    }

