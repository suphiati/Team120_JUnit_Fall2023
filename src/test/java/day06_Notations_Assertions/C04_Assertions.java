package day06_Notations_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Assertions {

    // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna "Java" yazıp aratın ve sonucun Java içerdiğini test edin

    /*
    JUnit test method'ları içinde yapılan testlerin
    failed veya passed olduğunu bize raporlar

    Ancak bu raporlama, kodlar sorunsuz çalışıp bittiyse PASSED,
    exception ile karşılaşırsa FAILED olarak gerçekleşir

    Ayrıca JUnit test method'ları içinde yapılan testleri değil
    method'ları raporlar

    JUnit bu iş için Assertion class'ı oluşturmuştur.

    Bir test method'unun içinde
    birden fazla assertion varsa
    bu assertion'lardan bir tanesi FAILED olursa
    kodun çalışması o satırda durur
    geriye kalan assertion'lar kontrol edilmemiş olur

    Eğer bir class çalıştığında
    tüm assertion'ların mutlaka gözden geçirilmesini istiyorsak
    her assertion için ayrı test methodu oluşturabiliriz

    test method'larının ismi de
    yapyığı iş ile uyumlu olursa
    konsolda neyin çalışıp neyin çalışmadığını
    kolayca görebiliriz


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
        String expectedTitleIcerik="Amazon";
        String actualTitle=driver.getTitle();

        Assert.assertTrue("Title Amazon içermiyor",actualTitle.contains(expectedTitleIcerik));
        System.out.println("Bu satir, test passed olursa çalışır, test failed olursa çalışmaz");



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

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));




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

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));


    }
}
