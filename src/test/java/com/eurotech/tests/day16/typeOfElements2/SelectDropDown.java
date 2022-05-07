package com.eurotech.tests.day16.typeOfElements2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class SelectDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        WebElement colorDropDown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        //select classindan obje olusturduk
        Select colorList = new Select(colorDropDown);

        // select classina bagli tüm elementleri list olarak döndürür.
        List<WebElement> options = colorList.getOptions();

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }

        //verify that default(ilk secili renk ne mesela,hangisini secili yaparsakta o gelir) colorList

        String expectedOption = "Red";
        String actualOption = colorList.getFirstSelectedOption().getText();

        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption, expectedOption, "verify that default colorList is RED");

        // Select class i kullanarak elemente nasil tiklanir
        // 1 - using visible text

        Thread.sleep(2000);
        colorList.selectByVisibleText("Purple");
        expectedOption = "Purple";
        actualOption = colorList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colorList is PURPLE");

        //2-select using index

        Thread.sleep(2000);
        colorList.selectByIndex(1);
        expectedOption = "Blue";
        actualOption = colorList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colorList is Blue");

        // 3 - select by value 1.52

        Thread.sleep(2000);
        colorList.selectByValue("8");
        expectedOption="Indigo";
        actualOption=colorList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colorList is Indigo");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
