package com.eurotech.tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class Method5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get("https://demo.aspnetawesome.com/");

        driver.findElement(By.xpath("(//div[@class='o-cptn'])[4]")).click();

        List<WebElement> fruitList = driver.findElements(By.xpath("(//div[@class='o-igit'])[1]/../../.."));

        System.out.println(fruitList.size());

        for (WebElement webElement : fruitList) {
            System.out.println(webElement.getText());
        }



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
