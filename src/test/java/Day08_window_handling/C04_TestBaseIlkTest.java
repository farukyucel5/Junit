package Day08_window_handling;

import Utilities.ReuseableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C04_TestBaseIlkTest extends TestBase {
    @Test
    public void test01(){

        // amazon'a gidin
        driver.get("https://www.amazon.com");

        // amazon'a gittiginizi test edin

        String expectedKelime= "amazon";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));

        ReuseableMethods.waiting(3);
    }
}
