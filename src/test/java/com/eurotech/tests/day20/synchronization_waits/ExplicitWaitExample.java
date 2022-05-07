package com.eurotech.tests.day20.synchronization_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class ExplicitWaitExample {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void explicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebElement halloText = new WebDriverWait(driver,Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='Hello World!']")));
        System.out.println("halloText.getText() = " + halloText.getText());

    }

    @Test
    public void explicitWait2() {

        driver.get("https://google.com/ncr");
        driver.findElement(By.xpath("//div[text()='I agree']")).click();

        driver.findElement(By.name("q")).sendKeys("peynir" + Keys.ENTER);

        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        // Print the first result
        System.out.println("firstResult.getText() = " + firstResult.getText());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
