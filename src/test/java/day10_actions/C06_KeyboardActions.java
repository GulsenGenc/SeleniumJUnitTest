package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebook anasayfaya gıdıp
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        // isim kutusunu locate edip,
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak formu doldurun
        Actions actions = new Actions(driver);
        actions.click(isimKutusu).
                sendKeys("Gülşen").
                sendKeys(Keys.TAB).
                sendKeys("Genç").
                sendKeys(Keys.TAB).
                sendKeys("gulsengenctuncer@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("gulsengenctuncer@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("yasamak_icin_beslen").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").   sendKeys(Keys.TAB).
                sendKeys("Mar").   sendKeys(Keys.TAB).
                sendKeys("1993").   sendKeys(Keys.TAB).   sendKeys(Keys.TAB).
               click(driver.findElement(By.xpath("//input[@value='1']"))). sendKeys(Keys.TAB).
                sendKeys(Keys.TAB). sendKeys(Keys.TAB). sendKeys(Keys.TAB).
                click(driver.findElement(By.xpath("//button[@name='websubmit']"))).perform();



        Thread.sleep(5000);
    }
}
