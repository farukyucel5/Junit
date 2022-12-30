package Day10FileinputOutput;

import Utilities.ReuseableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. Facebookd.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='Facebookd.png']")).click();
        ReuseableMethods.waiting(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // Test icin oncelikle dosyanin indirildiginde dosyaYolu ne olacak bunu olusturmaliyiz
        String dosyaYolu= System.getProperty("user.home")+ "\\Downloads\\Facebookd.png";
        // Bir dosyanin bilgisayarimizda var oldugunu (exist) test etmek icin
        // Java'daki Files class'indan yardim alacagiz
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void test02(){
        // Masaustunde Vocabulary.txt dosyasi oldugunu test edin
        // dinamik dosya yolu olusturalim
        String dosyaYolu= System.getProperty("user.home")+ "\\OneDrive\\Masaüstü\\Vocabulary.txt";
        // Assert edelim
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
