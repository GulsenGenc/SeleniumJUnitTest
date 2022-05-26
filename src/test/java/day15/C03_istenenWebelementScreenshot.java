package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_istenenWebelementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        //amazona gidip Nutella aratalım
        //sonuc sayısının oldugu webelementın fotografını cekelım
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYazıElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File sonucYazıElementScreenshot=new File("target/ekranGoruntuleri/sonucyazısıSS.jpeg");
        File temp=sonucYazıElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYazıElementScreenshot);
    }
}

