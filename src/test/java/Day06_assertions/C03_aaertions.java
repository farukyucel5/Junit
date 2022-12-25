package Day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_aaertions {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");

        String expectedKelime="Amazon";
        String actualKelime=driver.getTitle();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
    }
    @Test
    public  void test02(){

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella", Keys.ENTER);
        String expectedKelime="Nutella";
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String str=sonucYazisi.getText();

        Assert.assertTrue(str.contains(expectedKelime));
    }
    @Test

    public void test03(){
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String str=sonucYazisi.getText();

        System.out.println(str);

        String[] strArr=str.split(" ");
        String urunAdedi=strArr[2];
        int actualintegerAdedi=Integer.parseInt(urunAdedi);

        int expected=50;

        Assert.assertTrue(actualintegerAdedi>expected);
    }

}
