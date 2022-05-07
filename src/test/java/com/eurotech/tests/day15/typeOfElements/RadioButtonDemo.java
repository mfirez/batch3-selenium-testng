package com.eurotech.tests.day15.typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class RadioButtonDemo {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("(//div[@class='o-chk '])[2]")).click();
        WebElement legumes = driver.findElement(By.xpath("//div[text()='Legumes']"));//normalde default olarak secili oldugu icin true olmaliydi aslinda ama test 2 deki sitede true verdi
        WebElement vegetables = driver.findElement(By.xpath("//div[text()='Vegetables']/../div[1]"));

        System.out.println("legumes.isSelected() = " + legumes.isSelected());
        System.out.println("vegetables.isSelected() = " + vegetables.isSelected());
        driver.close();

    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        System.out.println("element.isSelected() = " + element.isSelected());

        WebElement element2 = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));

        System.out.println("element2.isSelected() = " + element2.isSelected());


        Assert.assertFalse(element.isSelected());

        WebElement element3 = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        System.out.println("element2.isSelected() = " + element3.isSelected());

        Assert.assertTrue(element3.isSelected());


        driver.close();


    }
}
