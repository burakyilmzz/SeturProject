import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Project extends TestBase{

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.setur.com.tr/");
        String seturUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.setur.com.tr/",seturUrl);
        WebElement defaultTabi = driver.findElement(By.xpath("//*[@class='sc-bde938b1-0 kLxiFo']"));
        boolean defaultMu = defaultTabi.isDisplayed();
        Assert.assertTrue(defaultMu);

        driver.findElement(By.xpath("//*[@class='show-element']")).click();
        bekle(1);
        driver.findElement(By.xpath("//*[text()='Tümüne izin ver']")).click();
        defaultTabi.sendKeys("Antalya");
        bekle(1);
        driver.findElement(By.xpath("(//*[@class='sc-1afe4354-1 fbrbek'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='sc-2941b94a-3 bQWuSI'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Ne Kadar Kalacaksınız?']")).click();
        for (int i = 0; i < 8; i++) {
            driver.findElement(By.xpath("//*[@class='sc-944eaa42-0 knyBPu sc-60054658-2 hcCnTV']")).click();
            Thread.sleep(300);
        }
        driver.findElement(By.xpath("(//span[text()='1'])[2]")).click();
        bekle(1);
        driver.findElement(By.xpath("(//span[text()='8'])[2]")).click();
        driver.findElement(By.xpath("//*[@class='sc-3b53cbe9-16 hAKxX']")).click();
        bekle(1);
        driver.findElement(By.xpath("(//*[@viewBox='0 0 20 21'])[1]")).click();
        bekle(1);
        driver.findElement(By.xpath("//*[text()='Ara']")).click();
        bekle(2);
        String antalyaUrl = driver.getCurrentUrl();
        Assert.assertTrue(antalyaUrl.contains("antalya"));
        bekle(2);

        Random random = new Random();
        int randomIndex = random.nextInt(61)+1;

        driver.findElement(By.xpath("//*[text()='Daha Fazla Göster']")).click();

        WebElement ilceButonlari = driver.findElement(By.xpath("(//*[@class='sc-a099436b-5 fpUDla'])["+randomIndex+"]"));
        ilceButonlari.click();

        List<WebElement> ilceListesi = driver.findElements(By.xpath("//*[@class='sc-57b11d2f-4 vvBFk']"));

        WebElement secilmisIlce = ilceListesi.get(randomIndex-1);
        String tekIlce =secilmisIlce.getText();
        String [] parts = tekIlce.split(" ");
        String yaziSayacStr = tekIlce.replaceAll("[^0-9]", "");
        int yaziSayac = Integer.parseInt(yaziSayacStr);
        bekle(2);

        System.out.println("Secilen filtre index: " + randomIndex);
        System.out.println("Yanindaki sayi: " + yaziSayacStr);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0, -1600)");

        if (yaziSayac > 20){
            WebElement aramadakiSayi = driver.findElement(By.xpath("(//*[@class='sc-b01e5b98-3 vbSmO'])[1]"));
            String strAramadakiSayi = aramadakiSayi.getText();
            int sonuctakiSayi = Integer.parseInt(strAramadakiSayi);
            System.out.println("Sonuctaki Sayi: "+ sonuctakiSayi);

            Assert.assertEquals(sonuctakiSayi,yaziSayac);


        }






    }


}
