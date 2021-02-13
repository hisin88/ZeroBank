package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class loginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().findElement(By.xpath("//button[@id='signin_button']")).click();
        Driver.get().manage().window().maximize();


    }

    @When("the user enters the user {string}")
    public void the_user_enters_the_user(String name) {
        new LoginPage().login(name); }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        System.out.println(Driver.get().findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]")).getText());
    }

    @Then("the {string} should be able to login")
    public void the_should_be_able_to_login(String name) {
        BrowserUtils.waitFor(1);
        String actualName = Driver.get().findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]")).getText();
        String expectedName = name;
        Assert.assertTrue(actualName.contains(expectedName));
    }

    @When("the user enters the invalid user {string}")
    public void the_user_enters_the_invalid_user(String name) {
        new LoginPage().name.sendKeys(name);
    }

    @When("the user enters the invalid passwords {string}")
    public void the_user_enters_the_invalid_passwords(String pass) {
        new LoginPage().pass.sendKeys(pass);
        new LoginPage().button.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the UnAuthorized user should not be able to login")
    public void the_UnAuthorized_user_should_not_be_able_to_login() {
        Assert.assertTrue(new LoginPage().loginAlert.isDisplayed());
    }

}
