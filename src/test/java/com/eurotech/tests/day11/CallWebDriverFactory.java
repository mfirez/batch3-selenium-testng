package com.eurotech.tests.day11;

import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.de");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.close();

        WebDriver driver1 = WebDriverFactory.getDriver2("edge");
        driver1.get("https://www.google.de");
        driver1.manage().window().maximize();
        Thread.sleep(3000);
        driver1.close();

        WebDriver driver2 = WebDriverFactory.getDriver2("firefox");
        driver2.get("https://www.google.de");
        driver2.manage().window().maximize();
        Thread.sleep(2000);
        driver2.close();

    }
}
