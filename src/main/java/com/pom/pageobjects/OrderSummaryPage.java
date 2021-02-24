package com.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderSummaryPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//*[@id='cart_navigation']/button")
    private WebElement confirmOrderButton;

    @FindBy(how = How.CSS, using =".page-heading")
    private WebElement summaryPageHeading;

    public OrderSummaryPage(WebDriver driver){
        super(driver);
    }

    public OrderConfirmationPage clickIConfirmMyOrder() {
        confirmOrderButton.click();
        return new OrderConfirmationPage(driver);
    }

    public String getPaymentInformation(){
        return driver.findElement(By.xpath("//*[@id='center_column']//div")).getText();
    }

    public String getPageHeading(){
        return summaryPageHeading.getText();
    }
}
