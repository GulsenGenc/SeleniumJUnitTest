package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidip screenshot alalım
        driver.get("https://www.amazon.com");

        TakesScreenshot ts= (TakesScreenshot) driver;

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        String tarih = date.format(dtf);

        File tumSayfaResim= new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");
        File geciciDosya= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumSayfaResim);
    }
}
