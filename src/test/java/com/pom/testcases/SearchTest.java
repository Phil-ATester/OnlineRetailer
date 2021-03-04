package com.pom.testcases;


import com.pom.pageobjects.CartPage;
import com.pom.pageobjects.HomePage;
import com.pom.pageobjects.ProductSearchPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass{

    @Test
    public void searchTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(1000);
        ProductSearchPage productSearchPage = homePage.search("Printed Chiffon Dress");
        //productSearchPage.getSearchResult();
        Assert.assertTrue(productSearchPage.isResultCorrect("Printed Chiffon Dress"), "Item not found");
    }

    @Test
    public void searchTest2() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(1000);
        ProductSearchPage productSearchPage = homePage.search("T Shirts");
        Assert.assertTrue(productSearchPage.isResultCorrect("T-shirts"), "Item not found");
    }
}
