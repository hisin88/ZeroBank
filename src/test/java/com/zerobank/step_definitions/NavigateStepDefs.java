package com.zerobank.step_definitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NavigateStepDefs {

    @Given("the user navigates to Account Summary page")
    public void the_user_navigates_to_Account_Summary_page() {

        Driver.get().findElement(By.cssSelector("#online-banking")).click();

        Driver.get().findElement(By.cssSelector("#account_summary_link")).click();

    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
    String locator = "//a[contains(.,'"+accountType+"')]";
    Driver.get().findElement(By.xpath(locator)).click();
    BrowserUtils.waitFor(1);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        WebElement dropdownElement = Driver.get().findElement(By.cssSelector("#aa_accountId"));
        Select accountDropDown = new Select(dropdownElement);
        String actualAccount = accountDropDown.getFirstSelectedOption().getText();
        String expectedAccount = string;
        Assert.assertTrue(actualAccount.contains(expectedAccount));
    }
}
