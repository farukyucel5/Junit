package Day07_Drpdown_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    // Gerekli ayarlamalari yapip
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    // Ilgili method'lari kullanin

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        String expectedText="I am a JS Confirm";
        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals(actualText,expectedText);
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        String actualSonucYazisi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"))
                .getText();


        String expectedSonucYazisi="You clicked: Cancel";

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        // Cikan prompt ekranina "Faruk" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Faruk");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        // Cikan sonuc yazisinin faruk icerdigini test edelim

        WebElement text=driver.findElement(By.xpath("//p[@id='result']"));
        String strText= text.getText();

        Assert.assertTrue(strText.contains("Faruk"));
    }

}
