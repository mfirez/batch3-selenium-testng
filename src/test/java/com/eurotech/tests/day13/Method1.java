package com.eurotech.tests.day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Method1 {
    public static void main(String[] args) throws InterruptedException {

        //-- //tagName[@attribute='value']

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.de/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Apple watch");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@id='high-price']")).sendKeys("250");
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none sf-review-stars-group'])[1]")).click();

        Thread.sleep(3000);
        driver.close();


    }
}
