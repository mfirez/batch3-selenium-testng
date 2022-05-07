package com.eurotech.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.de/?hl=de");
        Thread.sleep(1000);

        driver.navigate().to("https://de-de.facebook.com/");

        // bir önceki sayfaya geri gelir
        driver.navigate().back();
        Thread.sleep(2000);

        //geri geldigin sayfaya git(ileri git)
        driver.navigate().forward();
        Thread.sleep(1000);

        //sayfayi yenile
        driver.navigate().refresh();



    }
}
