package com.eurotech.tests.day26.ProjectObjectModel;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardTest extends TestBase {



    @Test
    public void dashboardsMenus() throws InterruptedException {

        /*
         Go to http://www.eurotech.study/
         Enter teacher credentials
         Get the text of Dashboard Menus
         */

        LoginPage loginPage = new LoginPage();

        DashboardPage dashboardPage = new DashboardPage();

        Thread.sleep(2000);
        loginPage.understandBtn.click();
        Thread.sleep(1000);
        loginPage.loginBtnBasePage.click();

        loginPage.emailInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtnLoginPage.click();

        /*
        loginPage.loginTeacher();
            bu da yukarida yaptigimizin hazir methodu utilise atmistik yeni bir class onun icinde bazi gerekli methodlar var
         */

        Thread.sleep(2000);

        List<WebElement> dashboardMenuList = new DashboardPage().dashboardMenus;

        for (WebElement manuName : dashboardMenuList) {
            System.out.println("manuName.getText() = " + manuName.getText());
        }

    }

    @Test
    public void navigateToMenu() throws InterruptedException {

        /**
         Go to http://www.eurotech.study/
         Enter teacher credentials
         Navigate to All Posts menu and then
         Navigate to Developers menu back
         */

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        loginPage.understandBtn.click();
        //Thread.sleep(1000);
        loginPage.loginBtnBasePage.click();

        loginPage.loginTeacher();

//        dashboardPage.allPostsMenu.click();
//        Thread.sleep(1000);
        dashboardPage.navigateToMenu("All Posts");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

//
//        dashboardPage.developersMenu.click();
        dashboardPage.navigateToMenu("Developers");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


//        navigateToMenu("Developers");


        actions.moveToElement(dashboardPage.myAccountMenu).perform();
        //dashboardPage.myAccountMenu.click(); hover over yapmadan da olur belki ama degisebilir

        dashboardPage.logoutBtn.click();

        System.out.println("After Login out = " + driver.getCurrentUrl());


    }


}
