package com.eurotech.tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class XpathLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.de/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Apple");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        String result =driver.findElement(By.xpath("//span[contains(text(),'Ergebnissen')]")).getText();

        System.out.println("result = " + result);


        Thread.sleep(2000);
        driver.close();



    }
}
