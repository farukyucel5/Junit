package Day07_Drpdown_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class C01_HandleDropDown {


    WebDriver driver;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        //ilgili ayarları yapıp
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        //arama kutusu yanındaki dropdown menüden book seçin
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select  select=new Select(dropdown);
        select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);
        //select.selectByVisibleText();

        //dropdown menüden books seçildiğini test edin
        String actualSecilenOption=select.getFirstSelectedOption().getText();
        String expected="Books";
        Assert.assertEquals(actualSecilenOption,expected);
        List<WebElement> options= select.getOptions();
        int numberOfOptions=options.size();
        int expectedNumber=28;
        Assert.assertEquals(numberOfOptions,expectedNumber);

        for (WebElement each:options) {
            System.out.println(each.getText());
        }

        //arama kutusuna java yazıp arattırın
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("java", Keys.ENTER);

        // title'in java içerip içermediğini test edin

        String expectedword="java";
        String actual=driver.getTitle();
        Assert.assertTrue(actual.contains(expectedword));


    }
}
