package webtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        driver.get("https://amazon.com");

        driver.findElement(By.id("nav-hamburger-menu")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-menu-id='6']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text() = 'Computer Components']")).click();
        Thread.sleep(1000);
        String itemText = driver.findElement(By.xpath("//div[@data-index='1']//h2//a")).getText();
        driver.quit();

        System.out.println(itemText);
    }
}
