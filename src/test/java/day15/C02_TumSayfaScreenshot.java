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
        LocalDateTime date= LocalDateTime.now();
        File tumSayfaResim=new File("target/ekranGoruntuleri/"+date+".jpeg");

        File gecıcıResım=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecıcıResım,tumSayfaResim);

    }
}
