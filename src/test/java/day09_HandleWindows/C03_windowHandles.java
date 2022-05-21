package day09_HandleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
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
        //  driver.quit();
    }

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYazıElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window", sayfadakiYazıElementi.getText());
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle);

        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

             /*
          switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */
        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
        ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan
        ikinci sayfanin woindow handle degeridir deriz
         */
        Set<String> windowHandleSeti = driver.getWindowHandles();
        String ikinciSayfaHandleDgeri="";
        for (String w:windowHandleSeti
             ) {
            if(!w.equals(ilkSayfaHandleDegeri)){
               ikinciSayfaHandleDgeri=w;
            }
        }
        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasii gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaHandleDgeri);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin
        String actualtitle= driver.getTitle();
        Assert.assertEquals("New Window",actualtitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYazıElementi= driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("New Window",ikinciSayfaYazıElementi.getText());

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Assert.assertEquals("The Internet",driver.getTitle());
    }

}
