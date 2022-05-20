package day09_HandleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        //2-Url in amazon içerdiğini test edelim
        String ilkSayfaUrl = driver.getCurrentUrl();
        Assert.assertTrue(ilkSayfaUrl.contains("amazon"));
        //3-yeni bır pencere açıp bestbuy anasayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandleDegeri= driver.getWindowHandle();
        //4-title in Best Buy içerdiğini test edelim.
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Best Buy"));
        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYazıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazıElementi.getText().contains("Java"));
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        // 8- logonun gorundugunu test edelim
        WebElement logoelementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoelementi.isDisplayed());
    }
}
