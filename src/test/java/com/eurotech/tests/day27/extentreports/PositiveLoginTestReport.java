package com.eurotech.tests.day27.extentreports;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTestReport extends TestBase {


    @Test
    public void loginAsTeacher(){

        // Name of the Test
        extentLogger  = report.createTest("Positive Login Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage= new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        String email= ConfigurationReader.get("usernameTeacher");
        String password= ConfigurationReader.get("passwordTeacher");

        loginPage.emailInput.sendKeys(email);
        extentLogger.info("Entering valid username");
        loginPage.passwordInput.sendKeys(password);
        extentLogger.info("Entering valid password");
        loginPage.loginBtnLoginPage.click();
        extentLogger.info("click on the login button");

        String expectedText="Welcome Eurotech"; //test case e baslamadan once bize credentials olarak bize verilecek
        String actualText= dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText,expectedText);
        System.out.println("dashboardPage.welcomeMessage.getText() = " + dashboardPage.welcomeMessage.getText());

        extentLogger.pass("Positive Login Test is passed");

    }
}
