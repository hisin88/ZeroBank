package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Locale;

public class ActivityStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new BasePage().AccountActivity.click();
        new AccountActivityPage().FindTransactions.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String str1, String str2) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDate.clear();
        accountActivityPage.toDate.clear();
        accountActivityPage.fromDate.sendKeys(str1);
        accountActivityPage.toDate.sendKeys(str2);
        }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().submit.click();
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String str1, String str2) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Assert.assertTrue(accountActivityPage.fitsIn(str1,str2)); }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(new AccountActivityPage().isSorted());  }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String str1) {
        Assert.assertFalse(new AccountActivityPage().contains(str1));  }

    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        String description = str.toUpperCase(Locale.ROOT);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.descriptionBox.clear();
        accountActivityPage.descriptionBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
       AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (int i = 0; i < accountActivityPage.rows.size(); i++) {
             Assert.assertTrue(accountActivityPage.rows.get(i).getText().contains(description));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (int i = 0; i < accountActivityPage.rows.size(); i++) {
            Assert.assertFalse(accountActivityPage.rows.get(i).getText().contains(description));
        }
    }
    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertFalse(new AccountActivityPage().columnBlank(3));

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertFalse(new AccountActivityPage().columnBlank(4));
    }

    @When("user selects type {string}")
    public void user_selects_type(String selection) {
        new AccountActivityPage().selectType(selection);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertTrue(new AccountActivityPage().columnBlank(4));
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue(new AccountActivityPage().columnBlank(3));
    }

}
