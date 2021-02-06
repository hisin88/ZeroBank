package com.zerobank.step_definitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class PayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        Driver.get().findElement(By.cssSelector("#online-banking")).click();

        Driver.get().findElement(By.id("pay_bills_link")).click();

        Driver.get().findElement(By.linkText("Add New Payee")).click();
        BrowserUtils.waitFor(2);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeDetails) {
        for(String key : payeeDetails.keySet() ) {
            String locator = "np_new_"+key.toLowerCase();
            Driver.get().findElement(By.id(locator)).sendKeys(payeeDetails.get(key));
       }
        Driver.get().findElement(By.id("add_new_payee")).click();
        BrowserUtils.waitFor(1);
 }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
String actualMessage = Driver.get().findElement(By.xpath("//div[@id='alert_content']")).getText();
        Assert.assertTrue(actualMessage.contains(string));
    }

}
