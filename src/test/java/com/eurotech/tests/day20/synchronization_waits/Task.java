package com.eurotech.tests.day20.synchronization_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class Task {
    /**
     * Go to https://demoqa.com/dynamic-properties
     * Get the text of the button "Will enable 5 second"
     * Get the text of the button "Visible after 5 second"
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testWait() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/dynamic-properties");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        System.out.println("Will Enable = " + driver.findElement(By.id("enableAfter")).getText());

        WebElement visibleAfter = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        System.out.println("visibleAfter.getText() = " + visibleAfter.getText());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
