package Day07_Drpdown_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Proctice1 {
   static WebDriver driver;
    @BeforeClass
    public static void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        WebElement iframe1=driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe1);

        WebElement innerText=driver.findElement(By.id("sampleHeading"));
        String actual=innerText.getText();
        String expected="This is a sample page";
        Assert.assertEquals(expected,actual);

        System.out.println(actual+"1");

        Thread.sleep(3000);

    }

    @Test
    public void test02() throws InterruptedException {
        driver.switchTo().parentFrame();

        WebElement iframe2= driver.findElement(By.id("frame2"));

        driver.switchTo().frame(iframe2);
        WebElement innerText=driver.findElement(By.id("sampleHeading"));
        String actual=innerText.getText();
        String expected="This is a sample page";
        Assert.assertEquals(expected,actual);

        System.out.println(actual+"2");

        Thread.sleep(3000);


    }
}
