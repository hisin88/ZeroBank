package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummary extends BasePage{

    @FindBy (xpath = "//h2")
    public List<WebElement> actualAccountTypes;

    @FindBy (xpath = "(//thead)[3]/tr/th")
    public List<WebElement> actualColumnNames;

}
