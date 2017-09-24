package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gayathri on 9/17/2017.
 */
public class LandingPage {


    // define the elements
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement lnkLougout;

    @FindBy(id = "welcome")
    WebElement lnkWelcome;
public String getMessage () {

    return lnkWelcome.getText();
}

public void logout(){
    lnkWelcome.click();
    lnkLougout.click();



}

}
