package denemeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_TekrarTesti {

/*
1-C01_TekrarTesti isimli bir class olusturun
2-https://www.google.com/ adresine gidin
3-cookies uyarisini kabul ederek kapatin
4-Sayfa basliginin “Google” ifadesi icerdigini test edin
5-Arama cubuguna “Nutella” yazip aratin
6-Bulunan sonuc sayisini yazdirin
7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8-Sayfayi kapatin
 */

    WebDriver driver;
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void googleTest(){
        // 2-https://www.google.com/ adresine gidin
        setup();

        driver.get("https://www.google.com");
        //3-cookies uyarisini kabul ederek kapatin

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedTitleIcerik= "Google";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Google Testi PASSED");
        }else {
            System.out.println("Google Testi FAILED");
        }
        ReusableMethods.bekle(2);

        //5-Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.name("q"));

        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi=driver.findElement(By.id("result-stats"));
        String sonucSayiIcerigi=sonucSayisi.getText();
        System.out.println("Sonuçlar: "+sonucSayiIcerigi);

        //7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc= sonucSayisi.getText();
        String[] sonucArr=sonuc.split("");
        /*
         //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc = result.getText();
        //Yaklaşık 153.000.000 sonuç bulundu (0,30 saniye)
        String[] sonucArr = sonuc.split(" ");
        String sonucSayisi = sonucArr[1];
        sonucSayisi = sonucSayisi.replace(".", "");
        System.out.println(sonucSayisi); //15300000
        int sonucSayisiInt = Integer.parseInt(sonucSayisi);
        int expectedNumber = 10000000;
        Assert.assertTrue(sonucSayisiInt > expectedNumber);
        // if (sonucNumaraInt > expectedNumber) {
        //     System.out.println("10 milyon testi PASSED");
        // } else {
        //     System.out.println("10 milyon testi FAILED");
         */

        ReusableMethods.bekle(2);

        //8-Sayfayi kapatin
        driver.close();


    }


}
