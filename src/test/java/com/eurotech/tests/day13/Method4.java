package com.eurotech.tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class Method4 {
    //---> //tagName[contains(text(),'text in herhangi bir bölümü')]

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.t-systems-mms.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Ausgewählte Cookies')]")).click();

        driver.findElement(By.xpath("//a[text()='Expertise']")).click();

        List<WebElement> expertiseDropDownList = driver.findElements(By.xpath("//a[text()='Expertise']/.."));

        for (WebElement webElement : expertiseDropDownList) {
            System.out.println(webElement.getText());
        }



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
