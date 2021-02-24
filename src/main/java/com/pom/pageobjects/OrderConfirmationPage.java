package com.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage{

    public OrderConfirmationPage (WebDriver driver){
        super(driver);
    }

    public String getHeading(){
        return driver.findElement(By.cssSelector(".page-heading")).getText();
    }

    public String orderSummary() {
        return driver.findElement(By.cssSelector("#center_column > div")).getText();
    }
}
