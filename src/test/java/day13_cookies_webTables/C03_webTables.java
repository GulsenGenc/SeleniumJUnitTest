package day13_cookies_webTables;

import day05_JUnit.C02;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_webTables extends TestBase {

    @Test
    public void dinamikYazici() {
        // onceki class'daki adrese gidip
        // girisYap method'unu kullanarak sayafaya giris yapin
        // input olarak verilen satir sayisi ve sutun sayisi'na sahip
        // cell'deki text'i yazdirin

        int satır = 4;
        int sutun = 4;

        girisYap();
        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satır+"]//td["+sutun+"]"));
        System.out.println(arananCell.getText());

    }

    public void girisYap() {
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        //            ○ Username : manager
        //            ○ Password : Manager1!

        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();
        driver.findElement(By.xpath("//input[@class='form-control required']")).sendKeys("manager");
        driver.findElement(By.xpath("//input[@class='form-control required password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();

    }}
