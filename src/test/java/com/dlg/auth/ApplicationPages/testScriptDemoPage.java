package com.dlg.auth.ApplicationPages;

import com.dlg.auth.WebConnector.webconnector;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testScriptDemoPage {
    webconnector wc = new webconnector();


    public void goToLoginPage() throws InvalidFormatException, IOException, InterruptedException {
        String URL=wc.getSpecificColumnData(wc.path,"sheet1", "URL");
        webconnector.driver.get(URL);
        System.out.println(URL);
        Thread.sleep(300);
        wc.waitForCondition("PageLoad","",60);
        Thread.sleep(3000);
    }

    public void addFourProductsToMyWishlist() throws Exception {
        if(acceptPerf()) {
            wc.PerformActionOnElement("perf_label","Click","");
        }
        try {
            wc.waitForPageLoad(100);
            wc.PerformActionOnElement("Watches_product","ScrollToElement","");
            wc.PerformActionOnElement("Watches_product","Click","");
            wc.PerformActionOnElement("ProductOne_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("AddProductsToWishlist_product","Click","");
            wc.waitForPageLoad(100);
            wc.PerformActionOnElement("HomeLink_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("ProductThree_product","ScrollToElement","");
            Thread.sleep(300);
            wc.PerformActionOnElement("ProductThree_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("AddProductsToWishlist_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("HomeLink_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("Watches_product","ScrollToElement","");
            wc.PerformActionOnElement("Watches_product","Click","");
            wc.PerformActionOnElement("ProductTwo_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("ProductTwoSelect_product","SelectByIndex","1");
            Thread.sleep(300);
            wc.PerformActionOnElement("AddProductsToWishlist_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("HomeLink_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("Watches_product","ScrollToElement","");
            wc.PerformActionOnElement("Watches_product","Click","");
            wc.PerformActionOnElement("ProductTwo_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("ProductTwoSelect_product","SelectByIndex","2");
            Thread.sleep(300);
            wc.PerformActionOnElement("AddProductsToWishlist_product","Click","");
            Thread.sleep(300);
            wc.PerformActionOnElement("HomeLink_product","Click","");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Four Products are not added to the wishlist" );
        }
    }
    public void viewMyWishListTable() throws Exception {

        try {
            wc.PerformActionOnElement("WishLishIcon_product","Click","");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Wishlist table is not viewed" );
        }
    }

    public boolean acceptPerf() {

        boolean accept =false;
        try {
            accept= wc.FindAnElement("perf_label").isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Perf accepted" );
        }
        return accept;
    }

    public void FindProductsInWishList() {
        try {
            wc.conditionCheck("Displayed","WishLishTable_product",20);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("products are not viewed in the table" );
        }
    }

    public void lowestPriceInWishList() {
        try {
            wc.selectLowPriceProductfElement();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("unable to select low price product" );
        }
    }
    public void addProductToMyCart() {
        try {
            wc.PerformActionOnElement("AddToCart_product","Click","");
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("unable to select low price product" );
        }
    }

    public void verifyProductInMyCart() {
        try {
            wc.conditionCheck("Displayed","ProductIntoMyCart_product",20);
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("unable to select low price product" );
        }
    }
}
