package practice_babayigit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
//1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
//3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
//4. Password alanina “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
//5. Sign in buttonuna tiklayin
        WebElement signInButonu= driver.findElement(By.xpath("//input[@name='submit']"));
        signInButonu.click();
//6. Back tusu ile sayfaya donun
        driver.navigate().back();
//7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
//8. amount kismina yatirmak istediginiz herhangi bir miktari yazi
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");
//9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
//10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
//11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement confirmText= driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (confirmText.isDisplayed()){
            System.out.println("İlgili Onay Yazısı Görülmüştür.");
        }else{
            System.out.println("İlgili Onay Yazısı Görülmemiştir.");
        }


    }

}