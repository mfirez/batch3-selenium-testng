package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//p[text()=' Welcome ']")
    public WebElement welcomeMessage;

    @FindBy(className = "nav__menu-item")
    public List<WebElement> dashboardMenus;

    @FindBy(xpath = "//a[text()='All Posts']")
    public WebElement allPostsMenu;

    @FindBy(xpath = "//a[text()='Developers']")
    public WebElement developersMenu;

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountMenu;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutBtn;

    @FindBy(xpath = "//*[text()='Edit Profile']")
    public WebElement editProfile;

    @FindBy(xpath = "//td[contains(text(),'Microsoft ')]/../td[2]")
    public WebElement usersTitle;

    @FindBy(xpath = "//a[text()='Create Profile']")
    public WebElement createProfileBtn;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement selectDropDown;

    @FindBy(xpath = "//input[@name='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@name='location']")
    public WebElement location;

    @FindBy(xpath = "//input[@name='skills']")
    public WebElement skills;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement sendBtn;

    @FindBy(xpath = "//div[text()='Profile Updated']")
    public WebElement profileUpdated;

    @FindBy(xpath = "//a[text()='Go Back']")
    public WebElement goBackBtn;

    @FindBy(xpath = "//a[@data-for='edit-experience-btn']")
    public WebElement addExperience;

    @FindBy(xpath = "//input[@placeholder='* Job Title']")
    public WebElement jobTittle;

    @FindBy(xpath = "//input[@placeholder='* Company']")
    public WebElement jobCompany;



    @Test
    public void navigateToMenu(String menuName) {

        WebElement menu =   Driver.get().findElement(By.xpath("//a[text()='" + menuName + "']"));

        menu.click();
    }

    public String getTitle(String companyName){
        String title = Driver.get().findElement(By.xpath("//td[contains(text(),'"+companyName+"')]/../td[2]")).getText();
        return title;
    }

    public String getCompany(String usersTitle){
        String text = Driver.get().findElement(By.xpath("//td[contains(text(),'" + usersTitle + "')]/../td[1]")).getText();
        return text;
    }

}
