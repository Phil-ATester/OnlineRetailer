package com.pom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShippingPage extends BasePage{

    @FindBy(how = How.CSS, using ="#cgv")
    private WebElement termsOfServiceCheckBox;

    @FindBy(how = How.XPATH, using ="//*[@id='form']/p/button")
    private WebElement proceedToCheckoutButton;

    @FindBy(how = How.CSS, using =".page-heading")
    private WebElement shippingPageHeading;

    ////*[@id="form"]/p/button

    public ShippingPage(WebDriver driver){
        super(driver);
    }

    public void clickAgreeToTermOfService(){
        termsOfServiceCheckBox.click();
    }

    public PaymentPage clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
        return new PaymentPage(driver);
    }

    public String getPageHeading(){
        return shippingPageHeading.getText();
    }
}
