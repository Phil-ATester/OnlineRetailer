package com.pom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class AddressPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/form/p/button")
    private WebElement proceedToCheckOutButton;

    @FindBy(how = How.CSS, using = "#address_delivery>li")
    private List<WebElement> deliveryAddress;

    @FindBy(how = How.CSS, using ="address_invoice>li")
    private List<WebElement> billingAddress;

    public AddressPage(WebDriver driver){
        super(driver);
    }

    public ShippingPage clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
        return new ShippingPage(driver);
    }

    public void getDeliveryAddress(){
        System.out.println("-------Deliver address --------");
        for (WebElement el : deliveryAddress){
            System.out.println(el.getText());
        }
    }

    public void getBillingAddress(){
        System.out.println("-------Billing address --------");
        for (WebElement e : billingAddress){
            System.out.println(e.getText());
        }
    }
}
