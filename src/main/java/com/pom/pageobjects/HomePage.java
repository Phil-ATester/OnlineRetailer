package com.pom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage extends BasePage{

    @FindBy (how= How.XPATH, using = "//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img ")
    private WebElement fadedShortSleeveTshirtIMG;

    @FindBy (how = How.CSS, using = ".button[title='Add to cart']")
    private WebElement addToCartBTN;

    @FindBy (how = How.CSS, using = "#search_query_top")
    private WebElement searchTextField;

    @FindBy (how = How.CSS, using = "button[name='submit_search']")
    private WebElement submitSearchBTN;

    @FindBy (how = How.CSS, using = ".login")
    private WebElement signInLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void selectItem(String item){
        Actions actions = new Actions(driver);
        actions.moveToElement(fadedShortSleeveTshirtIMG).build().perform();
        actions.moveToElement(addToCartBTN).click().build().perform();
    }

    public ProductSearchPage search(String item){
        searchTextField.clear();
        searchTextField.sendKeys(item);
        submitSearchBTN.click();
        return new ProductSearchPage(driver);
    }

    public SignInPage clickSignIn(){
        signInLink.click();
        return new SignInPage(driver);
    }
}