package com.eurotech.tests.day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method2 {
    public static void main(String[] args) {

        //---> //*[@attribute='value']

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@placeholder='Wohin reisen Sie?']")).sendKeys("Griechische Inseln");
        driver.findElement(By.xpath("//*[@class='sb-searchbox__button ']")).click();







    }
}
