package com.eurotech.tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class Frames_IFrames {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testName() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        // frame lere 3 sekilde ulasabiliriz
        // Switch to frame(iframe) using by nameOrId, index no veya normal locator ile
        // nameOrId -----   > driver.switchTo().frame("mce_0_ifr");

        // index no. kac tane frame var ise ve biz kacinciya ulasmak istiyorsak onn index i( 0 dan baslar)
        // index no ----->   driver.switchTo().frame(0);

        // locator
        WebElement frameWebElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameWebElement);


        WebElement textBox = driver.findElement(By.cssSelector("#tinymce"));

        Thread.sleep(2000);
        textBox.clear();
        Thread.sleep(1000);
        textBox.sendKeys("Welcome Here");

        // yukaridakki islemlerle frame in icine girmis olduk eger o frame den cikmazsak asagidaki locator calismaz
        // cünkü o frame in disinda almak istedigimiz text

        // switch back to main HTML
        // sadece bir level üstteki HTML e cikar
        driver.switchTo().parentFrame();

        WebElement header = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println("header.getText() = " + header.getText());

    }

    @Test
    public void iframeTest() {

        // sirayla iniyoruz ulasmak istedigimiz frame e

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        // burda tag name i kullandik cünkü o frame icerisindeyiz  ve orda sadece 1 tane var diger body ler left in disinda
        System.out.println("Text of Left Frame = " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();

        // index no ile ,iddle frame gittik
        driver.switchTo().frame(1);
        System.out.println("Text of Middle Frame  = " + driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println("Text of Right Frame = " + driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText());


        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        // yukaridaki gibi 2 kez geri gidebiliriz yada en bastami main frame e gitmek icinde
        //driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        System.out.println("Text of Bottom Frame  = " + driver.findElement(By.tagName("body")).getText());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
