package webtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHomeWork {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        driver.get("https://amazon.com");


        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='nav-xshop-container']//a[@data-csa-c-slot-id='nav_cs_0']")).click();
        Thread.sleep(2000);
        String newPrice = driver.findElement(By.xpath("//div[@data-deal-id='032e0117']//span[@class='a-price-whole']")).getText();
        Thread.sleep(2000);
        String oldPrice = driver.findElement(By.xpath("//div[@class='a-row a-spacing-micro']//span[@class='a-size-small a-color-secondary']//span[@class='a-price-whole']")).getText();

        driver.quit();

        System.out.println("New price: "+newPrice+" Old price: "+oldPrice);

    }
}
