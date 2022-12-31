package Day10FileinputOutput;

import Utilities.ReuseableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_File_upload extends TestBase {
    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        /*
             Bu gorevi yapabilmek icin chooseFile butonuna basildiginda
             acilan bilgisayarimizdaki file dosyalarini click yapabilmeemiz gerekir
             ancak Selenium bilgisayarimizdaki dosyalari click yapamaz
             Bunun yerine soyle bir cozum uretilmistir
             1- chooseFile butonunu locate edin
             2- upload edilecek dosyanin dosya yolunu olusturun
             3- chooseFile butonuna sendKeys ile dosya yolunu gonderin
         */

        WebElement chooseFileButonu= driver.findElement(By.xpath("//*[@id='file-upload']"));

        String dosyaYolu= System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Vocabulary.txt";

        chooseFileButonu.sendKeys(dosyaYolu);


        //Upload butonuna basalim.

        driver.findElement(By.xpath("//*[@id='file-submit']")).click();


        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());

        ReuseableMethods.waiting(3);
    }
}
