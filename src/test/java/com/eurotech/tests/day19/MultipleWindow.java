package com.eurotech.tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.Set;

public class MultipleWindow {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {

        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("Tittle before new window = " + driver.getTitle());

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //driver.findElement(By.linkText("Click Here")).click();

        //bir pencereden digerine gecmek icin kullanilir

        System.out.println("Id of first Tab = " + driver.getWindowHandle());

        String currentTab = driver.getWindowHandle();

        // coklu list oldugu icin set icine attik. Set in özelligi ayni elemandan sadece bir tane oluyordu. list ile yapsak uzayacakti kod

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) { // ikinci actigimiz tab(list icindeki herhangi bir tab aslinda ... iki tane var list icinde ) ilk taba esit degilse yeni window a gec switchto ile

            if (!tab.equals(currentTab)){
                driver.switchTo().window(tab);
            }
        }


        System.out.println("Tittle after new window = " + driver.getTitle());
        System.out.println("Id of second Tab = " + driver.getWindowHandle());

    }


    @Test
    public void multipleWindows2() {

        // go to webpage
        driver.get("https://the-internet.herokuapp.com/windows");

        // get the title of current page
        System.out.println("Title Before New Window = " + driver.getTitle());

        // get the id of current page
        System.out.println("Id of First Window = " + driver.getWindowHandle());

        // click on "Click Here"
        //driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {

            driver.switchTo().window(tab);

            if(driver.getTitle().equals("New Window")) {
                break;
            }

        }
        System.out.println("Title After New Window = " + driver.getTitle());
        System.out.println("Id of Second Tab = " + driver.getWindowHandle());

        //video 2 6.30

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
