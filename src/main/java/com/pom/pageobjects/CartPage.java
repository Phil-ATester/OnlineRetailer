package com.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage{

    @FindBy (how= How.XPATH, using = " //*[@id='center_column']/p[2]/a[1]")
    private WebElement proceedToCheckOutButton;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public SignInPage clickProceedToCheckout(){
        proceedToCheckOutButton.click();
        return new SignInPage(driver);
    }

    //*[@id="product_2_7_0_451401"]/td[2]/p/a
    public String getProduct(){
        return driver.findElement(By.xpath("//*[@id='product_2_7_0_451401']/td[2]/p/a")).getText();
    }
}
