package com.dlg.auth.stepdefs;

import com.dlg.auth.ApplicationPages.testScriptDemoPage;
import com.dlg.auth.WebConnector.webconnector;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class testScriptOrderSteps {
    webconnector wc=new webconnector();
    private final testScriptDemoPage testScriptDemoPage;
    private String scenDesc;

    public testScriptOrderSteps() {
        this.testScriptDemoPage = new testScriptDemoPage();
    }

    @Before
    public void before(Scenario scenario) {
        this.scenDesc = scenario.getName();
        if (!scenDesc.contains("API")) {
            wc.setUpDriver();
        }
    }

    @After
    public void after(Scenario scenario) {
        if (!scenDesc.contains("API")) {
           wc.closeDriver(scenario);
        }
    }

    @BeforeStep
    public void beforeStep() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Given("I open the site")
    public void iOpenTheSite() throws IOException, InvalidFormatException, InterruptedException {
        this.testScriptDemoPage.goToLoginPage();
    }

    @Given("I add four different products to my wish list")
    public void iAddFourDifferentProductsToMyWishList() throws Exception {
        this.testScriptDemoPage.addFourProductsToMyWishlist();
    }

    @When("I view my wishlist table")
    public void iViewMyWishlistTable() throws Exception {
        this.testScriptDemoPage.viewMyWishListTable();
    }

    @Then("I find total four selected items in my Wishlist")
    public void iFindTotalFourSelectedItemsInMyWishlist() {
        this.testScriptDemoPage.FindProductsInWishList();
    }

    @When("I search for lowest price product")
    public void iSearchForLowestPriceProduct() {
        this.testScriptDemoPage.lowestPriceInWishList();
    }

    @And("I am able to add the lowest price item to my cart")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() {
        this.testScriptDemoPage.addProductToMyCart();
    }

    @Then("I am able to verify the item in my cart")
    public void iAmAbleToVerifyTheItemInMyCart() {
        this.testScriptDemoPage.verifyProductInMyCart();

    }
}
