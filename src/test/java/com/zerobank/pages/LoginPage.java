package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }


   @FindBy(xpath = "//input[@id='user_login']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement pass;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement button;

    public void login(String Uname){
        name.sendKeys(ConfigurationReader.get(Uname));
        String Upass = Uname+"_password";
        pass.sendKeys(ConfigurationReader.get(Upass));
        button.click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//button[@id='primary-button']")).click();
    }
}
