package com.pom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends BasePage{

    @FindBy(how = How.CSS, using = ".page-heading")
    private WebElement pageHeading;

    public AccountPage (WebDriver driver){
        super(driver);
    }

    public boolean verifyPage(String pageTitle){
        System.out.println("Page = " + pageHeading.getText());
        return pageHeading.getText().toLowerCase().contains(pageTitle);
    }

}
