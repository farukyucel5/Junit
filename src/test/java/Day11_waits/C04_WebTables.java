package Day11_waits;

import Utilities.ReuseableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C04_WebTables extends TestBase {
    @Test
    public void test01(){

        // 1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin



        List<WebElement> body=driver.findElements(By.xpath("//tbody"));
        for (WebElement each:body){
            System.out.println(each.getText());
        }

        //4.Web table’daki satir sayisinin 9 oldugunu test edin

        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirlarListesi.size());

        //5.Tum satirlari yazdirin

        for (WebElement eachRow: satirlarListesi) {

            System.out.println(eachRow.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> column=driver.findElements(By.xpath("(//tbody/tr)[1]/td"));
        int actualColumn=column.size();
        int expectedColumn=13;
        Assert.assertEquals(actualColumn,expectedColumn);



        //7. 5.sutunu yazdirin
        System.out.println("==================5.column==========================");
        int count=0;
        for (int i=1;i<9;i+=2) {
            count++;

            String xpath="//tbody/tr["+i+"]/td[5]";
            WebElement column5= driver.findElement(By.xpath(xpath));
            System.out.println(count+".element of the fifth column of the web table "+column5.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


        System.out.println("==================");
        WebElement istenenDataElementi= getElement(5,7);
        System.out.println(istenenDataElementi.getText());

        ReuseableMethods.waiting(3);
    }

    private WebElement getElement(int satir, int sutun) {

        //     //tbody/tr[5]/td[7]

        String dinamikXpath="//tbody/tr["+ satir +"]/td["+ sutun +"]";

        WebElement istenenElement= driver.findElement(By.xpath(dinamikXpath));


        return istenenElement;
    }
    }
