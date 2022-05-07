package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class Task {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebElement text = driver.findElement(By.id("userNumber-label"));
        System.out.println("text.getText() = " + text.getText());

        driver.close();

    }
}
