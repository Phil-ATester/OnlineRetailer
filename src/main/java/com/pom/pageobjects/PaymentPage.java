package com.pom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PaymentPage extends BasePage {

    @FindBy(how = How.CSS, using = ".payment_module ")
    private List<WebElement> paymentOptions;

    @FindBy(how = How.CSS, using = ".bankwire")
    private WebElement bankWirePayment;

    @FindBy(how = How.CSS, using = ".cheque")
    private WebElement chequePayment;

    @FindBy(how = How.CSS, using =".page-heading")
    private WebElement paymentPageHeading;

    public PaymentPage(WebDriver driver){
        super(driver);
    }

    public OrderSummaryPage selectPaymentOption(String option){
        for (WebElement paymentType: paymentOptions){
            System.out.println("Type of payment" + paymentType.getText());
            if (paymentType.getText().contains(option)){
                paymentType.click();
            }
        }

        return new OrderSummaryPage(driver);
    }

    public OrderSummaryPage selectPayByBankWire(){
        bankWirePayment.click();
        return new OrderSummaryPage(driver);
    }

    public OrderSummaryPage selectPayByCheck(){
        chequePayment.click();
        return new OrderSummaryPage(driver);
    }

    public OrderSummaryPage selectPayment(String option){
        if (option == "bank wire"){
            bankWirePayment.click();
        }else if (option == "cheque"){
            chequePayment.click();
        }

        return new OrderSummaryPage(driver);
    }

    public String getPageHeading(){
        return paymentPageHeading.getText();
    }
}
