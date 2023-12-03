package day05_JUnitFramework;


import org.junit.Ignore;
import org.junit.Test;

public class C02_TestNotasyonu {

    /*
        @Test notasyonu siradan method'lari
        bagimsiz olarak calistirabilmemize imkan tanir
        boylece main method bagimliligi ortadan kalkar
        ve biz istedigimiz testi tek basina
        veya class level'dan toplu olarak calistirabiliriz
        ayrica ilerde gorecegimiz sekilde
        test method'larini belirli gruplara dahil edip
        toplu olarak da calistirabiliriz
        @Test notasyonuna sahip methodlar
        toplu olarak calistirildiginda
        hangi sira ile calisacagina dair bir kural yoktur
        JUnit bu koduda bir yontem gelistirmemistir
        calisma sirasi ONGORULEMEZ ve KONTROL EDILEMEZ
        Eger bir test method'u @ignore olarak isaretlenirse
        Selenium o method'u ignore eder
        calistirmaz
        JUnit bize calisan testlerden
        kacinin PASSED, kacinin FAILED oldugunu verir
        ANCAK JUnit testlerin gecip gecmedigini
        kodlarda bir sorun yasanip yasanmamasina baglar
        kodlar sorunsuz calisirsa, Test PASSED
        bir exception olusursa, Test FAILED
        olarak kaydedilir
     */



    @Test
    public void amazonTest(){
        System.out.println("amazon test çalıştı");
    }

    @Test @Ignore
    public void youtube(){
        System.out.println("youtube test çalıştı");
    }

    @Test
    public void wiseTest(){
        System.out.println("wise test çalıştı");
    }

    @Test
    public void test04(){
        //verilen 2 sayıdan sayi1'in daha büyük olduğunu test edin
        int sayi1= 10;
        int sayi2=5;

        if (sayi1>sayi2){
            System.out.println("Karşılaştırma testi PASSED");
        }else {
            System.out.println("Karşılaştırma testi FAILED");
        }
    }
}
