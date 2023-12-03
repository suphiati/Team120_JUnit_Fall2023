package practice_babayigit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P08 {
    public static void main(String[] args) {
        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        //2 ) Nurse  3 farkli relative locator ile locate edin
        //3 ) Relative locator’larin dogru calistigini test edin

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");

        //2 ) Nurse  3 farkli relative locator ile locate edin
        WebElement doctor = driver.findElement(By.xpath("//img[@id='dr_thumb']"));
        WebElement nurse1=driver.findElement(RelativeLocator.with(By.tagName("img")).below(doctor));

        WebElement fireman = driver.findElement(By.xpath("//img[@id='frmn_thumb']"));
        WebElement nurse2=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(fireman));

        //3 ) Relative locator’larin dogru calistigini test edin

        if (nurse1.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

    }
}
