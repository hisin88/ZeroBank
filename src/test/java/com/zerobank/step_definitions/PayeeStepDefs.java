package com.zerobank.step_definitions;

import com.zerobank.pages.PayeePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class PayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        Driver.get().findElement(By.cssSelector("#online-banking")).click();
        Driver.get().findElement(By.id("pay_bills_link")).click();
        new PayeePage().AddNewPayee.click();
        BrowserUtils.waitFor(2);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeDetails) {
        for(String key : payeeDetails.keySet() ) {
            String locator = "np_new_"+key.toLowerCase();
            Driver.get().findElement(By.id(locator)).sendKeys(payeeDetails.get(key));
       }
        new PayeePage().addButton.click();
        BrowserUtils.waitFor(1);
 }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
String actualMessage = Driver.get().findElement(By.xpath("//div[@id='alert_content']")).getText();
        Assert.assertTrue(actualMessage.contains(string));
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        Driver.get().findElement(By.cssSelector("#online-banking")).click();
        Driver.get().findElement(By.id("pay_bills_link")).click();
        new PayeePage().PFC.click();
        BrowserUtils.waitFor(2);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Assert.assertTrue(new PayeePage().isContained(dataTable));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

       new PayeePage().calculateButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String expected="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expected,alert.getText());
        BrowserUtils.waitFor(1);
        alert.accept();
    }

}
