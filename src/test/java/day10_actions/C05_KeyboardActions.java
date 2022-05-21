package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        //önce arama kutusuna click yapıp
        //sonra harf harf Nutella yazısını yazıralım
        //sonra da enter tusuna basalım

        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).//ilk harfı buyuk yapak için elımızı shifte koyma işlevi
                sendKeys("n").
                keyUp(Keys.SHIFT).//ilk harf için el shıftte ıdı.dıger harfler ıcın el shıftten kaldırılır.
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                perform();
        Thread.sleep(5000);
    }
}
