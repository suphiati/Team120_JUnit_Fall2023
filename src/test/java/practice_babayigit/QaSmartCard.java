package practice_babayigit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class QaSmartCard {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://qa.smartcardlink.com/");

        //2- sign In basalım
         driver.findElement(By.linkText("Sign In")).click();
        //3- email adresini girellim
        driver.findElement(By.name("email")).sendKeys("suphi.celikoz@gmail.com");

        //4- şifremizi girelim
        driver.findElement(By.name("password")).sendKeys("123456Suphi.");

        //5- Login'e basalım
       // driver.findElement(By.xpath("//button[@type='submit']")).click();

        //6- create new account'a basalım
        driver.findElement(By.linkText("Create an Account")).click();

        //7- first name, last name, email gir
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Suphi Atılım");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Çeliköz");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("atilim_88@hotmail.com");

        //8- password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456Suphi.");
        driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("123456Suphi.");

      /*
      ********* zaten bir hesap varsa buraya tıklar***

        driver.findElement(By.linkText("Sign in here")).click();
        */
       //9-Koşul kabul
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        //10-giris yap
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //ReusableMethods.bekle(3);
        //driver.close();

    }
}
