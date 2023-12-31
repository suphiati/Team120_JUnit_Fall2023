package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.security.Key;

public class C04_KeyboardActions extends TestBase {

    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);

        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).sendKeys("71").sendKeys(Keys.ENTER).perform();

        String expectedIcerik= "Samsung A71";
        String actualSonucYazisi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        bekle(2);
    }
}
