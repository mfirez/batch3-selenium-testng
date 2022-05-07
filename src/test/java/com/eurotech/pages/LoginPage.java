package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement usernameInput;

    //@FindBy(xpath = "//input[@data-test='username']")   xpath de olur mesela
    //public WebElement getUsernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

   @FindBy(css = ".submit-button.btn_action")
    public WebElement loginButton;

   /* @FindAll({
            @FindBy(id = "login-button"), // ikisinden birisini(daha fazlada ekleyebiliriz) bul locate et demek üstteki login buttonu iptal ettik tabi
            @FindBy(name = "login-button")
    })
    public WebElement loginButton;

    */

   // @FindBys({
     //       @FindBy(id = "login-button"), // ikisinide  bul locate et demek (iki sartida sagla)
      //      @FindBy(name = "login-button")
   // })
    //public WebElement loginButton;


}
