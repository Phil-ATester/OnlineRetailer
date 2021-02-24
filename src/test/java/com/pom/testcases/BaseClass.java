package com.pom.testcases;

import com.pom.tests.utils.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


/**  Setup Class **/

public class BaseClass {

    public WebDriver driver;

    ReadConfig readConfig = new ReadConfig();
    public String homePage = readConfig.getApplicationURL();

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br){
        switch(br){
            case "IE":
                WebDriverManager.edgedriver().setup();
                driver = new InternetExplorerDriver();
                System.out.println("Internet Explorer Browser selected");
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("FireFox Browser selected");
                break;
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                System.out.println("Chrome Browser selected");
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("No Browser Selected");
                break;
        }

        //System.out.println("url = " + homePage);
        driver.get("http://automationpractice.com/index.php");
        //driver.get(homePage);  // ******* not working as intended *******

        // set the amount of time to wait for a page to load to complete before it throws an error
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);  // time , Timeout unit
    }

/*
    @AfterMethod
    public void recordFailure(ITestResult result){
        System.out.println("Test Result: " + result.getStatus());
        if (ITestResult.FAILURE == result.getStatus()){
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
                System.out.println(result.getName());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }*/

    @AfterClass
    public void tearDown(){
       if (driver != null) {
            driver.quit();
       }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String randomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String randomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }
}
