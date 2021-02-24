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

    public void clickToNewPage(){

    }

}
