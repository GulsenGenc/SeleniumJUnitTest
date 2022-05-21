package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazona gidp account menüsünden create a list linkine tıkla
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement accountMenu = driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        actions.moveToElement(accountMenu).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(5000);
    }
}
