package team05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class day12_sf157 extends TestBase {

    @Test
    public void pdfSayfa157(){

        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        bekle(2);

        // 2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(3);

        // 3.Web table tum body’sini yazdirin
      WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
      System.out.println(tumBodyElementi.getText());

           /*
        <table> ----->Tablo
     B           <thead> ----->Header
     A             <tr> ----->Header row
     S               <th> ----->Header data ====> Sütun yerine data var. Yani 2. satır 5. sütun yerine 2. satır 5. data demiş oluruz
     L               </th>
     I             </tr>
     K           </thead>

     B          <tbody> -----> body
     O           <tr> -----> satır row'u
     D             <td> -----> data
     Y             </td>
                 </tr>
                </tbody>
       </table>
       */

        // 4.Web table’daki satir sayisinin 9 oldugunu test edin
      List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
      int expectedSatirSayisi = 9;
        int actualSatirSayisi = satirlarListesi.size();
      Assert.assertNotEquals(expectedSatirSayisi,actualSatirSayisi);

        // 5.Tum satirlari yazdirin
       for (int i = 0; i < satirlarListesi.size(); i++) {
            System.out.println((i+1) + ".ci satir   :   " + satirlarListesi.get(i).getText());
        }

        // 6. Web table’daki sutun sayisinin 13 olduğunu test edin
       List<WebElement> birinciSatirDataList = driver.findElements(By.xpath("//tr[1]/td"));
        int expectedSutunSayisi= 13;
        int actualSutunSayisi = birinciSatirDataList.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        // 7. 3.sutunu yazdirin
       List<WebElement> ucuncuSutunDataList = driver.findElements(By.xpath("//tr/td[3]"));
       System.out.println("*********** 3.sutun Listesi ***********");
        for (WebElement each : ucuncuSutunDataList
       ) {
            System.out.println(each.getText());
        }


        // 8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("========== method'dan dolayı olusan datalar =========");
        System.out.println(hucredekiBilgi(5, 7));
        System.out.println("============");
        System.out.println(hucredekiBilgi(3,1));
    }
    public String hucredekiBilgi(int satirNo , int sutunNo){

        String dinamikXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }
    }



