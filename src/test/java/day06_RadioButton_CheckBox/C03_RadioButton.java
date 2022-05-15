package day06_RadioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //1. Bir class oluşturun : RadioButtonTest
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //a-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //b-“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //c-“radio buttons” elementlerini locate edin
        WebElement kadınRadıoButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekRadıoButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelRadıoButton=driver.findElement(By.xpath("//input[@value='-1']"));
        Thread.sleep(3000);
        //d-Secili degilse cinsiyet butonundan size uygun olani secin
        if (!kadınRadıoButton.isSelected()){
            kadınRadıoButton.click();
        }
        Thread.sleep(3000);

    }

}
