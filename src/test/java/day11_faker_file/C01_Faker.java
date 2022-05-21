package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    //facebook görevini fake isimlerle yapalım

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
        Faker faker = new Faker();
        String fakerEmail = faker.internet().emailAddress();
        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakerEmail).
                sendKeys(Keys.TAB).
                sendKeys(fakerEmail).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").sendKeys(Keys.TAB).
                sendKeys("Mar").sendKeys(Keys.TAB).
                sendKeys("1993").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                click(driver.findElement(By.xpath("//input[@value='1']"))).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                click(driver.findElement(By.xpath("//button[@name='websubmit']"))).perform();


        Thread.sleep(5000);
    }
}
