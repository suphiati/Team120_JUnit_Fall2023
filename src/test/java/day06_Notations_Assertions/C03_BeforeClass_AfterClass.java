package day06_Notations_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {

     // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
   // 3- Arama kutusuna "Java" yazıp aratın ve sonucun Java içerdiğini test edin

    /*
    Bize verilen görevde, oluşturulacak farklı test methodları
    aynı web sayfasında oluyorsa, her method'unda yeniden driver oluşturup
    sonunda kapatmak yerine,

    Tüm @Test method'larından önce 1 kere driver oluşturup
    tüm @Test methodlarını çalıştırıp, en son driver'ı kapatmak
    daha mantıklı olur

    @BeforeClase ve @AfterClass notasyonları kullanıldığında
    DİKKAT etmemiz gereken konu
    bu notasyonları kullanan methodların
    STATIC olarak işaretlenmesinin ZORUNLU olmasıdır
     */

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void titleTest(){
        // 1- Title'in Amazon icerdigini test edin
        String ecpectedTitleIcerik="Amazon";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(ecpectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
        }

    }

    @Test
    public void nutellaTest(){
        // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        ReusableMethods.bekle(2);

        WebElement sonucYaziElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik="Nutella";
        String actualSonucYazisi=sonucYaziElementi.getText();

        if (actualSonucYazisi.contains(expectedSonucIcerik)){
            System.out.println("Nutella testi PASSED");
        }else {
            System.out.println("Nutella testi FAILED");
        }


    }

    @Test
    public void JavaTest(){
        // 3- Arama kutusuna "Java" yazıp aratın ve sonucun Java içerdiğini test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        ReusableMethods.bekle(2);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik="Java";
        String actualSonucYazisi=sonucYaziElementi.getText();

        if (actualSonucYazisi.contains(expectedSonucIcerik)){
            System.out.println("Java testi PASSED");
        }else {
            System.out.println("Java testi FAILED");
        }
    }

}
