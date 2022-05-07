package com.eurotech.tests.day15.typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class DisableElement {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("#input-example>input"));
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));
        //System.out.println(element.isDisplayed()); böyle de gördük ama Assert kullanmaliyiz

        Assert.assertFalse(element.isEnabled());
        enableButton.click();
        Thread.sleep(6000);
        Assert.assertTrue(element.isEnabled());


        driver.close();
    }

}
