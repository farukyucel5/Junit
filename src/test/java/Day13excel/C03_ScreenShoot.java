package Day13excel;

import Utilities.ReuseableMethods;
import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class C03_ScreenShoot extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazona git nutella yaz arat ve sayfanın ekran görüntüsünü al

        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        WebElement aramasonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expected="Nutella";
        String actual=aramasonucElementi.getText();

        Assert.assertTrue(actual.contains(expected));


        ReuseableMethods.screenShoot(driver);
    }
    @Test
    public void test02(){
        driver.get("https://wisequarter.com/");
        String expectedUrl="https://wisequarter.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        ReuseableMethods.screenShoot(driver);

    }
    @Test
    public void test03IstenenElemanSS() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        WebElement aramasonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expected="Nutella";
        String actual=aramasonucElementi.getText();

        Assert.assertTrue(actual.contains(expected));
        //arama sonuç elementinin screenshoot'ını alın

       ReuseableMethods.elementSS(aramasonucElementi);


    }




}
