package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class accountSummaryStepDefs {
    @Then("The page should have the title {string}")
    public void the_page_should_have_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("verify",actualTitle,expectedTitle);
    }

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> accountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummary().actualAccountTypes);
        Assert.assertEquals(accountTypes,actualAccountTypes);
        //   for (int i = 1; i <= 4; i++) {
        //       actualAccountTypes.add(Driver.get().findElement(By.xpath("(//h2)["+i+"]")).getText());  }
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> tableColumns) {
        List<String> actualtableColumns = BrowserUtils.getElementsText(new AccountSummary().actualColumnNames);
         Assert.assertEquals(tableColumns,actualtableColumns);
        // for (int i = 1; i <= 3; i++) {
        //     actualtableColumns.add(Driver.get().findElement(By.xpath("(//thead)[3]/tr/th["+i+"]")).getText()); }

    }

    @Given("the user navigates to Account Activity page")
    public void the_user_navigates_to_Account_Activity_page() {
        Driver.get().findElement(By.cssSelector("#online-banking")).click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.id("account_activity_link")).click();

    }

    @Then("In the Account drop down option should be {string}")
    public void in_the_Account_drop_down_option_should_be(String expectedOption) {
        String actualOption=new AccountActivityPage().accountOptions().get(0).getText();
        Assert.assertEquals("verify first option",actualOption,expectedOption);
    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(new AccountActivityPage().accountOptions());
        Assert.assertEquals(expectedOptions,actualOptions);
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(new AccountActivityPage().accountColumnNames);
        Assert.assertEquals(expectedColumns,actualColumns);

    }



}
