package com.eurotech.tests.day20.synchronization_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class ImplicitlyWaitExample {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @Test
    public void threadSleepExample() throws InterruptedException {

        /*
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebElement element = driver.findElement(By.cssSelector("#finish>h4"));

        System.out.println("element.getText() = " + element.getText());

        bu calismadi anlamadik
         */

    }

    @Test
    public void implicitlyWait() {

        // implicitlyWait kendisinden sonra gelen!!!!! her driver.findelement icin bekler öncesi icin gecerli degildir

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));---> before method un icine attik

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebElement itsGone = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println("itsGone.getText() = " + itsGone.getText());
    }

    @Test
    public void implicitlyWait2() {

        // implicitlyWait kendisinden sonra gelen!!!!! her driver.findelement icin bekler öncesi icin gecerli degildir

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); ---> before method un icine attik

        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        WebElement itsGone = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println("itsEnable.getText() = " + itsGone.getText());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
