package com.eurotech.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.de/?hl=de");

        String titl = driver.getTitle();
        System.out.println("titl = " + titl);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSearch = driver.getPageSource();// bütün html yapisini verir
        System.out.println("pageSearch = " + pageSearch);

        driver.close();

    }
}
