package Day08_window_handling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedSayfaYazisi="Opening a new window";
        String actualSayfaYazisi=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actualSayfaYazisi,expectedSayfaYazisi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle= "The Internet";
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();

        Thread.sleep(3000);

         /*
               Kontrolsuz acilan tab'a gecis yapmak icin
               1- ilk sayfada iken o sayfanin WHD alip kaydedin
               2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
                  acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
               3- su anda elimizde 2 elementli bir Set var,
                  elementlerden bir tanesi 1.sayfanin WHD
                  1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
               4- bu sekilde 2.sayfanin WHD elde edildikten sonra
                  WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
         */

        Set<String> tumWHDegerleriSeti= driver.getWindowHandles();

        String ikinciSayfaWHD="";
        for (String eachWhd: tumWHDegerleriSeti
        ) {
            if (!eachWhd.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWHD=eachWhd;
            }
        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedNewSayfaTitle="New Window";
        String actualNewSayfaTitle= driver.getTitle();

        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedYeniSayfaYazi="New Window";
        String actualYenisayfaYazi= driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedYeniSayfaYazi,actualYenisayfaYazi);

        //● Bir önceki pencereye geri döndükten sonra
        // sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


        Thread.sleep(3000);


    }
}
