package com.pom.testcases;

import com.pom.pageobjects.*;
import org.testng.annotations.Test;

public class CheckOutExistingCustomer extends BaseClass{

    String fName = "John";
    String lName = "brown";
    String email = "TestUser999@gmail.com";
    String pw = "password1";

    @Test
    public void CheckOutExistingCustomerTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(1000);
        ProductSearchPage productSearchPage = homePage.search("Dress");
        CartPage cartPage = productSearchPage.selectItem("Blouse");
        SignInPage signInPage = cartPage.clickProceedToCheckout();
        SignUpPage signUpPage = signInPage.createAccount(email);
        Thread.sleep(2000);
        AddressPage addressPage = signInPage.setExistingUser(email, pw);
        addressPage.getBillingAddress();
        addressPage.getDeliveryAddress();
        ShippingPage shippingPage = addressPage.clickProceedToCheckOutButton();
        System.out.println("Shipping page heading: " + shippingPage.getPageHeading());
        shippingPage.clickAgreeToTermOfService();
        PaymentPage paymentPage = shippingPage.clickProceedToCheckoutButton();
        System.out.println("Payment Page : " + paymentPage.getPageHeading());
        OrderSummaryPage orderSummaryPage = paymentPage.selectPayment("bank wire");
        System.out.println("Summary Page: " + orderSummaryPage.getPageHeading());
        System.out.println("Payment Information: " + orderSummaryPage.getPaymentInformation());
        OrderConfirmationPage orderConfirmationPage = orderSummaryPage.clickIConfirmMyOrder();
        System.out.println(" ------- Order Confirmation ----------");
        System.out.println(orderConfirmationPage.orderSummary());

        Thread.sleep(5000);
    }
}
