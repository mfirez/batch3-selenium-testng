package com.eurotech.tests.day28.review;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.SignUpPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork extends TestBase {
    /*
            Test1
    -- Create new user
    -- Add new user's configuration properties
            Test2
    -- Login with new user
    -- Edit Profile(Students, learning, city, skills)
    -- Click submit
    -- Verify that Profile Updated
    -- Go Back
    -- Add experiences
    -- Click Submit
            Test3
    -- Verify that all user's info
     */

    @Test
    public void createUser() {

        extentLogger = report.createTest("Create new User");

        SignUpPage signUpPage = new SignUpPage();
        extentLogger.info("Click on Understand Button ");
        signUpPage.understandBtn.click();

        extentLogger.info("Click on SignUp Button");
        signUpPage.signUp.click();

        extentLogger.info("Enter User Name");
        signUpPage.signUpName.sendKeys("Mehmet");

        extentLogger.info("Enter Email Addressee");
        signUpPage.signUpEmail.sendKeys("mehmetfirez@hotmail.com");

        extentLogger.info("Enter Password");
        signUpPage.signUpPassword.sendKeys("mehmet_1903");

        extentLogger.info("Enter Confirm Password");
        signUpPage.signUpPasswordConfirm.sendKeys("mehmet_1903");

        extentLogger.info("Click on Register Button");
        signUpPage.signUpRegisterBtn.click();

        String actualMessage = new DashboardPage().welcomeMessage.getText();
        String expectedMessage = "Welcome Mehmet";

        extentLogger.info("Verify that Message is "+expectedMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.pass("Passed");

    }

    @Test
    public void loginNewUsersAndAddInfo() throws InterruptedException {

        extentLogger = report.createTest("Login with new Users and add Info");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Click understand Button");
        loginPage.understandBtn.click();

        extentLogger.info("Click in the  Base Page on login Button");
        loginPage.loginBtnBasePage.click();

        extentLogger.info("Enter new users email");
        loginPage.emailInput.sendKeys(ConfigurationReader.get("usernameStudent"));

        extentLogger.info("Enter new users password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordStudent"));

        extentLogger.info("Click in the  Login Page on Login Button");
        loginPage.loginBtnLoginPage.click();

        /*
        ilk user olustururken böyle cikiyor sayfa
        dashboardPage.createProfileBtn.click();

         */

        Thread.sleep(2000);

        actions.moveToElement(dashboardPage.myAccountMenu).perform();

        extentLogger.info("Click on Edit Profile Btn");
        dashboardPage.editProfile.click();

        Select select = new Select(dashboardPage.selectDropDown);

        extentLogger.info("Click on Select Options");
        select.selectByVisibleText("Student or Learning");

        extentLogger.info("Enter company name");
        dashboardPage.company.sendKeys("Eurotech");

        extentLogger.info("Enter City");
        dashboardPage.location.sendKeys("Stuttgart");

        extentLogger.info("Enter Skills");
        dashboardPage.skills.sendKeys("Java");

        extentLogger.info("Click Send Button");
        dashboardPage.sendBtn.click();

        String expectedText = "Profile Updated";
        String actualText = dashboardPage.profileUpdated.getText();

        extentLogger.info("Verify that Profile Updated");
        Assert.assertEquals(actualText,expectedText);

        Thread.sleep(2000);
        extentLogger.info("Click Go Back Button");
        dashboardPage.goBackBtn.click();

        extentLogger.info("Click on Add Experience");
        dashboardPage.addExperience.click();

        extentLogger.info("Enter Job Tittle");
        dashboardPage.jobTittle.sendKeys("Software Test Engineer");

        extentLogger.info("Enter Company name");
        dashboardPage.jobCompany.sendKeys("Microsoft");

        Thread.sleep(2000);
        extentLogger.info("Click on Send Button");
        dashboardPage.sendBtn.click();

        extentLogger.pass("Passed");

    }

    @Test
    public void verifyUsersInfo() {

        //use the extent logger

    }


}
