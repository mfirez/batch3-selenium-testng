package com.eurotech.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.de/?hl=de");

        String tittle = driver.getTitle();

        Thread.sleep(2000);

        //calistigimiz, üzerinde oldugumuz sayfayi kapatir
        driver.close();

        //bütün pencereleri kapatir
        //driver.quit();

    }
}
