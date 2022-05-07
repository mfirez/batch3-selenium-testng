package com.eurotech.tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testName() {

        driver.get("https://demoqa.com/");

        List<WebElement> categories = driver.findElements(By.cssSelector(".card.mt-4.top-card"));

        System.out.println("categories.size() = " + categories.size());

        for (WebElement category : categories) {
            System.out.println("category.getText() = " + category.getText());
            Assert.assertTrue(category.isDisplayed());// bütün menülerin görünür oldugunu verify etmis olduk tek tek
        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
