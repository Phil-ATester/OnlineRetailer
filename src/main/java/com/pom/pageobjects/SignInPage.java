package com.pom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage extends BasePage{

    @FindBy(how = How.CSS, using = "#email_create")
    private WebElement emailField;

    @FindBy(how = How.CSS, using = "#SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(how = How.CSS, using = ".page-heading")
    private WebElement pageHeading;

    @FindBy(how = How.CSS, using = "#email")
    private WebElement emailAddressField;

    @FindBy(how = How.CSS, using = "#passwd")
    private WebElement passwordField;

    @FindBy(how = How.CSS, using = "#SubmitLogin")
    private WebElement signInBTN;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    public void setEmailAddress(String email){
        emailField.click();
        emailField.sendKeys(email);
    }

    public SignUpPage createAccount(String email){
        setEmailAddress(email);
        createAccountButton.click();
        return new SignUpPage(driver);
    }

    public boolean verifyPage(String pageTitle){
        System.out.println("Page = " + pageHeading.getText());
        return pageHeading.getText().toLowerCase().contains(pageTitle);
    }

    public AddressPage setExistingUser(String emailAddress, String password){
        emailAddressField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        signInBTN.click();
        return new AddressPage(driver);
    }

}
