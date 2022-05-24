package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_webtables extends TestBase {

    @Test
    public void webTableTesti() {
        //● login( ) metodun oluşturun ve oturum açın.
        girisYap();
        //● table( ) metodu oluşturun
        tablee();

        //● printRows( ) metodu oluşturun //tr
        printRows();

    }

    private void printRows() {
        //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> tumSatırlar=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satır sayısı :"+tumSatırlar.size());
        //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w:tumSatırlar
             ) {
            System.out.println(w.getText());
        }
        //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement w: cellList
             ) {
            System.out.println(w.getText());
        }
    }

    private void tablee() {

        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBaslıklarıListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sütün sayısı : " + sutunBaslıklarıListesi.size());

        for (WebElement w:sutunBaslıklarıListesi
             ) {
            System.out.println("başlıklar->"+w.getText());
        }

        //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz

        //email başlığındaki tüm elementleri (sutun) konsolda yazdırın
        //önce email başlığının kacıncı sutunda oldugunu bulurum.
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size() ; i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSutunListesi=
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each: emailSutunListesi) {
            System.out.println(each.getText());
        }
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


        /*
        ***Action class yardımı ile username ve password kutucuklarına klavye hareketı ıle geçme-->

          Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
         */
    }
}
