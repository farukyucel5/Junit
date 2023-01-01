package AmazonPractice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Practice1FeedArrow extends TestBase {
    @Test
    public void feedArrow(){
        driver.get("https://www.amazon.com/");

        driver.findElement(By.xpath("(//div/ul)[1]/li[10]")).click();


    }

}
