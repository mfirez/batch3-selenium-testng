package com.eurotech.tests.day24.testBase_basePage;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {


    @Test
    public void loginTest() throws InterruptedException {


        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage= new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        String email= ConfigurationReader.get("usernameTeacher");
        String password= ConfigurationReader.get("passwordTeacher");

        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtnLoginPage.click();

        String expectedText="Welcome Eurotech"; //test case e baslamadan once bize credentials olarak bize verilecek
        String actualText= dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText,expectedText);
        System.out.println("dashboardPage.welcomeMessage.getText() = " + dashboardPage.welcomeMessage.getText());

    }

    @Test
    public void loginWithTeacher() {
        LoginPage loginPage = new LoginPage();
        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.loginTeacher();
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),"Welcome Eurotech");
    }

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();
        loginPage.login(ConfigurationReader.get("usernameDeveloper"),ConfigurationReader.get("passwordDeveloper"));
        loginPage.loginBtnLoginPage.click();
    }




        /*

        configuration.properties in icerisini degistirdik o yüzden artik calismadi

        browser = chrome
        url = https://www.saucedemo.com/
        username = standard_user
        password = secret_sauce

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys(ConfigurationReader.get("username"));
        Thread.sleep(2000);

        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
        Thread.sleep(2000);

        loginPage.loginButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));


         */


        /*
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));


        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


         */



}
