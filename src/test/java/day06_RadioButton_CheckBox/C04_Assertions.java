package day06_RadioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public  void test01(){
        /*eğer test methodumuzda hıcbır test yoksa ,test çalıştıktan sonra
        hiçbir problemle karşılaşılmadıgını raporlamak için 'tests passed' yazısı çıkar.

        EĞER TESTLERI İF İLE YAPARSAK TEST FAILED OLSA BILE KODLAR
        PROBLEMSIZ ÇALIŞTIGI İÇİN KOD ÇALIŞMASI BITTIGINDE EKRANIN SOL ALT KISMINDA TEST PASSED YAZACAKTIR.
         */
        driver.get("https://www.amazon.com.tr");
        //url in https://www.facebook.com oldugunu test edin
     //  if (driver.getCurrentUrl().equals("https://www.facebook.com")){
     //      System.out.println("url testi PASSED");
     //  }else{
     //      System.out.println("url testi FAILED");
     //  }

        String expectedUrl="https://www.facebook.com";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farklı",expectedUrl,actualUrl);
        /*
        Assert ıle yaptıgımız testlerde assertion faıled olursa java kodların çalışmasını durdurur ve assert classı bızı
        hata konusunda bılgılendırır.böylece htanın ne oldugunu arastırmamıza gerek kalmadan JUnit bıze raporlamıs olur.
         */
    }
}
