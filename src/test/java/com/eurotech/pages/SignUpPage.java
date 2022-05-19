package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    @FindBy(xpath = "//input[@name='name']")
    public WebElement signUpName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement signUpEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement signUpPassword;

    @FindBy(xpath = "//input[@name='password2']")
    public WebElement signUpPasswordConfirm;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement signUpRegisterBtn;




}
