package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gayathri on 9/17/2017.
 */
public class LoginPage {

    @FindBy(id = "txtUsername")
    WebElement txtuserName;

    @FindBy(id = "txtPassword")
    WebElement txtpassword;

    @FindBy(id = "btnLogin")
    WebElement btnLogin;


    @FindBy(id = "spanMessage")
    WebElement spnMessage;

    public void typeUserName(String userName) {

        txtuserName.sendKeys(userName);

    }

    public void typePassword(String password) {

        txtpassword.sendKeys(password);
    }


    public void clickLogin() {
        btnLogin.click();

    }

    public void login(String userName, String password) {

        typeUserName(userName);
        typePassword(password);
        clickLogin();

    }

    public String getMessage() {

        return spnMessage.getText();


    }
}
