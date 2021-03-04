package com.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchPage extends BasePage{

    @FindBy(how = How.CSS, using = ".product_list>li")
    private List<WebElement> productList;

    @FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    private WebElement proceedtoCheckoutButton;

    @FindBy(how = How.CSS, using =".layer_cart")
    private WebElement itemAddedToCartPopup;

    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    public CartPage selectItem(String option) throws InterruptedException {
        for (WebElement e : productList) {
            //System.out.println(e.getText());
            if (e.getText().contains(option)) {
                System.out.println("--------------------");
                System.out.println("Select item : " + "" + e.getText());

                Actions action = new Actions(driver);
                action.moveToElement(e).perform();

                action.moveToElement(driver.findElement(By.xpath(" //*[@id='center_column']/ul/li[7]/div/div[2]/div[2]/a[1]/span"))).click().perform();

                //Thread.sleep(1000);

                new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(proceedtoCheckoutButton)).click();

                //proceedtoCheckoutButton.click();
            }
        }
        return new CartPage(driver);
    }

    public boolean isResultCorrect(String item){
        boolean result = false;

        for (WebElement e : productList) {
            if (e.getText().contains(item)) {
                result = true;
                break;
            }
        }

        return result;
    }
}

