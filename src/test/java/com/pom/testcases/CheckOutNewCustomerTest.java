package com.pom.testcases;

import com.pom.pageobjects.*;
import org.testng.annotations.Test;

public class CheckOutNewCustomerTest extends BaseClass{

    String fName = randomString(5);
    String lName = randomString(5);
    String email = randomString(7 ) + "@gmail.com";

    @Test
    public void searchTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(1000);
        ProductSearchPage productSearchPage = homePage.search("Dress");
        CartPage cartPage = productSearchPage.selectItem("Blouse");
        SignInPage signInPage = cartPage.clickProceedToCheckout();
        SignUpPage signUpPage = signInPage.createAccount(email);
        Thread.sleep(2000);
        // sign in
        //SignInPage signUpPage = new SignInPage(driver);
        signUpPage.setTitle("Mr");
        signUpPage.setFirstName(fName);
        signUpPage.setLastName(lName);
        signUpPage.setEmail(email);
        signUpPage.setPassword("Password");
        signUpPage.setDateOfBirth("10", "May", "2000");
        signUpPage.setAddressFirstName(fName);
        signUpPage.setAddressLastName(lName);
        signUpPage.setCompanyField("Company A");
        signUpPage.setAddressField1("1 Company Street");
        signUpPage.setCity("City A");
        signUpPage.selectState("New York");
        signUpPage.setZipCode(randomNumber(5));
        signUpPage.selectCountry("United States");
        signUpPage.setMobileNo(randomNumber(8));
        signUpPage.setAlias(email);

        //return address

        AddressPage addressPage = signUpPage.clickRegister();
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
