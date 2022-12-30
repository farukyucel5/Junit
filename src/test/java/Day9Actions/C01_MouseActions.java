package Day9Actions;

import Utilities.ReuseableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C01_MouseActions extends TestBase {

    @Test
    public void test01() {
        //1- Yeni bir class olusturalim: MouseActions1

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin

        Actions actions= new Actions(driver);

        WebElement ciziliAlanElementi= driver.findElement(By.xpath("//*[@id='hot-spot']"));

        actions.contextClick(ciziliAlanElementi).perform();
        ReuseableMethods.waiting(2);
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim

        String ilkSayfaWHD= driver.getWindowHandle(); // CDwindow-F9742959E8FD03F25B0419B7B70EE203
        System.out.println(ilkSayfaWHD);
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> ikiSayfaninWHDSeti = driver.getWindowHandles();

        String ikinciSayfaWHD="";

        for (String eachWHD: ikiSayfaninWHDSeti
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD= eachWHD;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);

        String expectedYenisayfaYazi="Elemental Selenium";
        String actualYeniSayfaYazi= driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYenisayfaYazi,actualYeniSayfaYazi);
      //daha sonrailk sayfaya dönün ve o sayfada olduğunuzu test edin
        driver.switchTo().window(ilkSayfaWHD);

        WebElement powerElement= driver.findElement(By.xpath("//*[text()='Powered by ']"));
        Assert.assertTrue(powerElement.isDisplayed());

        ReuseableMethods.waiting(4);

    }



}
