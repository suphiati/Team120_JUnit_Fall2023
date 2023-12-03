package practice_babayigit;
import org.junit.Ignore;
import org.junit.Test;

public class P01 {

        /*
            @BeforeClass ------> Sadece 1 kere çalışıyor
            @Before  ----------> Her testten önce bir kere çalışır
            @After   ---------->Her testin sonunda bir kere çalışır
            @AfterClass   ------> Tüm testler bitince bir kere çalışır
            @Test   ------------>Test kodlarının yer aldığı kısımdır.

         */

    @Test
    public void test08(){
        System.out.println("Ahmet");
    }

    @Test
    public void test01(){
        System.out.println("Resul");
    }

    @Test
    public void test13(){
        System.out.println("Nergiz");
    }


}
