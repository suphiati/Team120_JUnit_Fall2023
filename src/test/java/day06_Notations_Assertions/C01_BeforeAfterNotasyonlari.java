package day06_Notations_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {

    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin

    WebDriver driver;
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void amazonTest(){
        // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
        setup();

        driver.get("https://www.amazon.com");
        String expectedUrlIcerik= "amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon Testi PASSED");
        }else {
            System.out.println("Amazon Testi FAILED");
        }
        ReusableMethods.bekle(2);//bunları daha sonra silebilirsin geçikmeler olmasın testler çabuk bitsin diye

        driver.close();


    }
    @Test
    public void wiseTest(){
        // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
        setup();
        driver.get("https://www.wisequarter.com");
        String expectedTitleIcerik="Wise";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter Testi PASSED");
        }else {
            System.out.println("Wisequarter Testi FAILED");
        }
        ReusableMethods.bekle(2);
        driver.close();

    }

    @Test
    public void youtubeTest() {

        // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
        setup();
        driver.get("https://www.youtube.com");
        String expectedTitleIcerik="best";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Youtube Testi PASSED");
        }else {
            System.out.println("Youtube Testi FAILED");
        }
        ReusableMethods.bekle(2);
        driver.close();
    }


}

