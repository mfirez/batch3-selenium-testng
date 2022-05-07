package com.eurotech.tests.day15.typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class CheckBoxDemo {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());

        WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        checkBox2.click();
        Assert.assertFalse(checkBox2.isSelected());


    }
}
