package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.manage().window().maximize();

        // bu sekilde komple link almaliyiz locate etmek icin(icinde link olmali)
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();

        Thread.sleep(1000);

        driver.navigate().back();

        // bu sekilde de link olan elementin bir kismini yazsakda yakalar(icinde link olmali)
        driver.findElement(By.partialLinkText("Example 2:")).click();


        Thread.sleep(3000);
        driver.close();

    }
}
