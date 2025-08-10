import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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

    }


}
