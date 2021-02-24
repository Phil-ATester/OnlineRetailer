package com.pom.testcases;


import com.pom.pageobjects.AccountPage;
import com.pom.pageobjects.SignUpPage;
import com.pom.pageobjects.HomePage;
import com.pom.pageobjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseClass {

    String fName = randomString(5);
    String lName = randomString(5);
    String email = randomString(7 ) + "@gmail.com";

    @Test
    public void signInTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignIn();
        Assert.assertTrue(signInPage.verifyPage("authentication"), "SignIn Page not displayed");
        SignUpPage signUpPage = signInPage.createAccount(email);
        Thread.sleep(2000);
        // TO-DO -- wait need after click button
        Assert.assertTrue(signUpPage.verifyPage("create an account"), "Singup page not displayed");
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
        AccountPage accountPage = signUpPage.clickRegisterButton();
        Assert.assertTrue(accountPage.verifyPage("my account"), "Account page not displayed");
        Thread.sleep(9000);
    }
}
