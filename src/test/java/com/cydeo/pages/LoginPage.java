package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "g")
    public WebElement log;

    @FindBy(name = "f")
    public WebElement getLog;



    @FindBy(name = "f")
    public WebElement getAS;

}
