package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public  BasePage(){

        PageFactory.initElements(Driver.get(),this);
        // bu sayfadaki element ve methodlain kullanimina izin vermis oluyoruz yukaridaki ifade ile

    }

    @FindBy(linkText = "Developers")
    public WebElement developers;

    @FindBy(linkText = "Login")
    public WebElement loginBtnBasePage;

    @FindBy(xpath = "//span[contains(text(),'Google')]")
    public WebElement signWithGoogle;

    @FindBy(xpath = "//span[contains(text(),'Github')]")
    public WebElement signWithGithub;

    @FindBy(linkText = "Sign Up")
    public WebElement signUp;

    @FindBy(xpath = "//button[text()='I understand']")
    public WebElement understandBtn;


}
