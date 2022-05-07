package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class Calismalar {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Mehmet Firez");

        WebElement eMail = driver.findElement(By.id("userEmail"));
        eMail.sendKeys("example@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Osterwiesenstr. 55, 70794 Filderstadt");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Karacatepe Sk. No:3");

        Thread.sleep(2000);

        driver.findElement(By.id("submit")).click();

        //driver.close();

    }
}
