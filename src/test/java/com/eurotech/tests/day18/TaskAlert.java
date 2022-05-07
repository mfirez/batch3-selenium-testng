package com.eurotech.tests.day18;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class TaskAlert {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.cssSelector("#alertButton")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
