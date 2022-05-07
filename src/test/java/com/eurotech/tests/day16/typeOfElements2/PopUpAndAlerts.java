package com.eurotech.tests.day16.typeOfElements2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class PopUpAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void popUp() throws InterruptedException {
        driver.get("https://www.primefaces.org/primeng/confirmpopup");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[text()='Confirm'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='Yes']")).click();
    }

    @Test
    public void alert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        alert.sendKeys("Eurotech");
        Thread.sleep(1000);
        alert.accept();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
