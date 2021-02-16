package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(linkText = "Find Transactions")
    public WebElement FindTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr")
    public List<WebElement> rows;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy (id = "aa_type")
    public WebElement type;

    @FindBy (id = "aa_accountId")
    public WebElement showTransactionsAccount;

    public List<WebElement> accountOptions(){
    Select accountsDropDown = new Select(showTransactionsAccount);
    List<WebElement> options = accountsDropDown.getOptions();
    return options;
    }

    @FindBy (xpath = "//thead/tr/th")
    public List<WebElement> accountColumnNames;

    public int[] numberedDate (String str){
        String [] date = str.split("-");
        int [] Date = new int[3];
        for (int i = 0; i < 3 ; i++) {
            Date[i] = Integer.parseInt(date[i]);
        }
        return Date;
    }

    public boolean fitsIn(String str1, String str2){
        boolean flag = true;
        for (int i = 1; i <= rows.size(); i++) {
            String dateString = Driver.get().findElement(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr["+i+"]/td[1]")).getText();
            for (int j = 0; j < 3 ; j++) {
              if (!(numberedDate(dateString)[j] >= numberedDate(str1)[j] && numberedDate(dateString)[j] <= numberedDate(str2)[j])){
               flag = false;
              } }
        }
    return flag;
    }
    public boolean isSorted(){
        boolean flag=true;
        int [] arr = new int[rows.size()];
        label:
     for (int j = 0; j < 3 ; j++){
        for (int i = 1; i <= rows.size() ; i++) {
String dateString = Driver.get().findElement(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr["+i+"]/td[1]")).getText();
            arr[i-1] = numberedDate(dateString)[j];
        }
        int first = arr[0];
        for (int i = 1; i < rows.size(); i++) {
            if (!(first >= arr[i])){
                flag = false;
                break label;
            }
        }
     }
        return flag;
    }

    public boolean contains(String str1){
        boolean flag = false;
        for (int i = 1; i <= rows.size(); i++) {
            String dateString = Driver.get().findElement(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr["+i+"]/td[1]")).getText();
                if (numberedDate(dateString)[0] >= numberedDate(str1)[0] && numberedDate(dateString)[0] <= numberedDate(str1)[0]){
                    if (numberedDate(dateString)[1] >= numberedDate(str1)[1] && numberedDate(dateString)[1] <= numberedDate(str1)[1]){
                        if (numberedDate(dateString)[2] >= numberedDate(str1)[2] && numberedDate(dateString)[2] <= numberedDate(str1)[2]){
                            flag = true;
                        }
                    }
                }

        }
        return flag;
    }

    public boolean columnBlank(int column){
        String check = "";
        for (int i = 1; i <= rows.size(); i++) {
            String locator = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr["+i+"]/td["+column+"]";
            check+=Driver.get().findElement(By.xpath(locator)).getText();
        }
        return check.isEmpty();
  }
  public void selectType (String selection){
      Select typeSelect = new Select(type);
        typeSelect.selectByVisibleText(selection);
  }
}
