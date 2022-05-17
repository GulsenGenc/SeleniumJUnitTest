package day07_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farklı test methodu oluşturarark
    aşağıdaki görevleri yapın
    1->Url'in amazon içerdiğini test edin
    2->title in facebook içermediğini test edin
    3->sol üst köşede amazon logosunun gorundugunu test edın
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {

        String arananKelıme = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelıme));
    }

    @Test
    public void test02() {
        String ıstenmeyenKelıme = "facebook";
        String actualTıtle = driver.getTitle();
        Assert.assertFalse(actualTıtle.contains(ıstenmeyenKelıme));
    }

    @Test
    public void test03() {
        WebElement logoElementi = driver.findElement(By.xpath("//a[@aria-label='Amazon']"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
