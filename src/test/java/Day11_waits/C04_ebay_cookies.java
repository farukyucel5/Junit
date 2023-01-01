package Day11_waits;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C04_ebay_cookies extends TestBase {
    @Test
    public void ebay(){
        driver.get("https://wisequarter.com/");

        Set<Cookie> ebayCookies= driver.manage().getCookies();
        for (Cookie each:ebayCookies){
            System.out.println("=================================================");
            System.out.println(each);

        }
        System.out.println("=========New version of the ebay with new cookies============");
        Cookie mycookie=new Cookie("my best item ","Lenovo ThinkPad");
        driver.manage().addCookie(mycookie);

        ebayCookies= driver.manage().getCookies();
        for (Cookie each:ebayCookies){
            System.out.println("=================================================");
            System.out.println(each);

        }


    }
}
