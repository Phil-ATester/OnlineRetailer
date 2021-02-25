package com.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductSearchPage extends BasePage{

    @FindBy(how = How.CSS, using = ".product_list>li")
    private List<WebElement> productList;

   // @FindBy(how = How.CSS, using =".product_list>li>div>div>div>a>img")
   // private WebElement itemImg;

    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    //.product_list>li>div>div>div>a[title="Blouse"]
    public CartPage selectItem(String option) throws InterruptedException {
        for (WebElement e: productList){
            //System.out.println(e.getText());
            if(e.getText().contains(option)){
                System.out.println("--------------------");
                System.out.println("Select item : " + "" + e.getText());

                Actions action = new Actions(driver);
                action.moveToElement(e).perform();

                action.moveToElement(driver.findElement(By.xpath(" //*[@id='center_column']/ul/li[7]/div/div[2]/div[2]/a[1]/span"))).click().perform();

                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")).click();


            }
        }
        return new CartPage(driver);
    }

    public void selectProceedToCheckOut(){

    }

    public void getSearchResult(){
        for(WebElement e: productList){
            System.out.println(e.getText());
        }
    }

}

