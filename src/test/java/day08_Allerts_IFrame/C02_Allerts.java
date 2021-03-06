package day08_Allerts_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //      https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void acceptAlert() {
        //● Bir metod olusturun: acceptAlert
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //      “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedResult = "You successfully clicked an alert";
        WebElement sonucYazıElementi = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(sonucYazıElementi.getText().equals(expectedResult));
    }

    @Test
    public void dismissAlert() {
        //● Bir metod olusturun: dismissAlert
        //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //      “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String expectedResult = "successfuly";
        WebElement sonucYazıElementi = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertFalse(sonucYazıElementi.getText().contains(expectedResult));
    }

    @Test
    public void sendKeysAlert() {
        //● Bir metod olusturun: sendKeysAlert
        //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //      OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("gülşen genç");
        driver.switchTo().alert().accept();
        WebElement sonucYazıElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String sonucYazsısıStr=sonucYazıElementi.getText();
        String expectedResult="gülşen genç";
        Assert.assertTrue(sonucYazsısıStr.contains(expectedResult));


    }

    }
