package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayeePage extends BasePage{

    @FindBy(linkText = "Add New Payee")
   public WebElement AddNewPayee;

    @FindBy(id="add_new_payee")
    public WebElement addButton;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement PFC;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateButton;


    public boolean isContained (List<String> dataTable){
        boolean flag = true;
        WebElement element = Driver.get().findElement(By.id("pc_currency"));
        Select currency = new Select(element);
        List<WebElement> options = currency.getOptions();
        String currencyList="";
        for (WebElement option : options) {
            currencyList+=" "+option.getText();
        }
        for (String money : dataTable) {
            if (!(currencyList.contains(money))){
                flag = false;
            }
        }
        return flag;
    }

}
