package com.eurotech.tests.day15.typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class AttributeTest {// gettext calismadigi durumlarda alternatif olarak kullanilabilir
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();

        WebElement radioBttn = driver.findElement(By.xpath("(//input[@type='radio'])[10]"));
        System.out.println(radioBttn.getAttribute("type"));
        System.out.println(radioBttn.getAttribute("name"));
        System.out.println(radioBttn.getAttribute("value"));
        System.out.println(radioBttn.getAttribute("outerHTML"));

        driver.close();

    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement userInput = driver.findElement(By.cssSelector("#userName"));
        System.out.println(userInput.getAttribute("type"));
        System.out.println(userInput.getAttribute("placeholder"));
        System.out.println(userInput.getAttribute("id"));
        System.out.println(userInput.getAttribute("class"));
        System.out.println(userInput.getAttribute("outerHTML"));
    }


}
