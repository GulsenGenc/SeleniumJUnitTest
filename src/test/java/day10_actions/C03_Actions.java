package day10_actions;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedYazı="You selected a context menu";
        String actualYazı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazı,actualYazı);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        Set<String> handleSeti=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String w:handleSeti
             ) {
            if (!w.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=w;
            }
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        WebElement yazıElementi= driver.findElement(By.tagName("h1"));
        Assert.assertEquals("Elemental Selenium",yazıElementi.getText());


    }}
