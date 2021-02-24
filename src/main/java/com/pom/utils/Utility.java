package com.pom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

    public static WebElement isElementPresent(WebDriver driver, String path, int time)
    {

        WebElement element = null;

        for(int i=0;i<time;i++)
        {
            try{
                element=driver.findElement(By.cssSelector(path));
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }

        }
        return element;
    }

}
