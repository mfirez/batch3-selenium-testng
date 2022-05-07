package com.eurotech.tests.day15.typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class DisplayedElement {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");



        WebElement helloBtn = driver.findElement(By.xpath("//h4[text()='Hello World!']")); //element burada

        // System.out.println("helloBtn.isDisplayed() = " + helloBtn.isDisplayed());//ancak gorunmuyor

        Assert.assertFalse(helloBtn.isDisplayed());
        //   WebElement startBtn = driver.findElement(By.xpath("//*[text()='Start']"));


        driver.findElement(By.xpath("//*[text()='Start']")).click();
        Thread.sleep(6000);

        String helloText = helloBtn.getText();
        Assert.assertEquals(helloText,"Hello World!");



    }
}
