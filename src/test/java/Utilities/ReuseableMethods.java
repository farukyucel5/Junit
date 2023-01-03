package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReuseableMethods {
    public static void waiting(long second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void screenShoot(WebDriver driver) {

        TakesScreenshot tss= (TakesScreenshot) driver;
         //her resmi ayrı ayrı kaydetmesi için tarih ekliyoruz
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/pagess"+tarih+".jpeg";
        File pageSS=new File(dosyaYolu);
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,pageSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReuseableMethods.waiting(4);
    }

    public static void elementSS(WebElement aramasonucElementi) {
        //geçici dosya oluştur ve element üzerinden ss al

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/elementSS"+tarih+".jpeg";
        File elementss=new File(dosyaYolu);

        File gecici =aramasonucElementi.getScreenshotAs(OutputType.FILE);

        //gecici dosyayı hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici,elementss);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
