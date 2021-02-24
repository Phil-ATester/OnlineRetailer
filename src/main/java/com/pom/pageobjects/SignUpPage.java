package com.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignUpPage extends BasePage{

    @FindBy(how = How.CSS, using = "label[for^='id_gender']")
    private List<WebElement> titleList;

    @FindBy(how = How.CSS, using = "#customer_firstname")
    private WebElement customerFirstnameField;

    @FindBy(how = How.CSS, using = "#customer_lastname")
    private WebElement customerLastNameField;

    @FindBy(how = How.CSS, using = "#email")
    private WebElement customerEmailField;

    @FindBy(how = How.CSS, using = "#passwd")
    private WebElement customerPasswordField;

    @FindBy(how = How.CSS, using = "#days")
    private WebElement dobDate;

    @FindBy(how = How.CSS, using = "#months")
    private WebElement dobMonth;

    @FindBy(how = How.CSS, using = "#years")
    private WebElement dobYear;

   // private By dobDate = By.id("days");
   // private By dobMonth = By.id("months");
   // private By dobYear = By.id("years");

    @FindBy(how = How.CSS, using = "#firstname")
    private WebElement customerAddressFirstnameField;

    @FindBy(how = How.CSS, using = "#lastname")
    private WebElement customerAddressLastNameField;

    @FindBy(how = How.CSS, using = "#company")
    private WebElement companyField;

    @FindBy(how = How.CSS, using = "#address1")
    private WebElement addressField1;

    @FindBy(how = How.CSS, using = "#city")
    private WebElement cityField;

    @FindBy(how = How.CSS, using = "#id_state")
    private WebElement state;

    @FindBy(how = How.CSS, using = "#postcode")
    private WebElement postCode;

    @FindBy(how = How.CSS, using = "#id_country")
    private WebElement country;

    @FindBy(how = How.CSS, using = "#other")
    private WebElement additionalInformationTextField;

    @FindBy(how = How.CSS, using = "#phone")
    private WebElement phone;

    @FindBy(how = How.CSS, using = "#phone_mobile")
    private WebElement mobilePhone;

    @FindBy(how = How.CSS, using = "#alias")
    private WebElement alias;

    @FindBy(how = How.CSS, using = "#submitAccount>span")
    private WebElement registerButton;

    @FindBy(how = How.CSS, using = ".page-heading")
    private WebElement pageHeading;

    public SignUpPage(WebDriver driver){
        super(driver);
       // driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    public boolean verifyPage(String pageTitle){
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading."CREATE AN ACCOUNT"));
        System.out.println("Page = " + pageHeading.getText());
        return pageHeading.getText().equalsIgnoreCase(pageTitle);
    }

    public void setTitle (String title){
       for (WebElement element:titleList){
           if (element.getText().contains(title)){
               element.click();
               break;
           }
       }
    }

    public void setFirstName(String firstName){
        customerFirstnameField.clear();
        customerFirstnameField.sendKeys(firstName);
    }

    public void setLastName(String lastname){
        customerLastNameField.clear();
        customerLastNameField.sendKeys(lastname);
    }

    public void setEmail(String email){
        customerEmailField.clear();
        customerEmailField.sendKeys(email);
    }

    public void setPassword(String password){
        customerPasswordField.clear();
        customerPasswordField.sendKeys(password);
    }

    public void selectElementFromDropDown(By locator, String value){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }

    public Select getSelectOption(WebElement e){
        return new Select(e);
    }

    public void selectMonth(String m){
        Select select = new Select(dobMonth);
        List<WebElement> allOption = select.getOptions();

        for (WebElement e: allOption){
            if(e.getText().contains(m)){
                e.click();
                break;
            }
        }
    }

    public void setDateOfBirth(String date, String month, String year) {
        getSelectOption(dobDate).selectByValue(date);
        selectMonth(month);
        //getSelectOption(dobMonth).selectByVisibleText(month);
        getSelectOption(dobYear).selectByValue(year);
    }

    public void setAddressFirstName(String firstName){
        customerAddressFirstnameField.clear();
        customerAddressFirstnameField.sendKeys(firstName);
    }

    public void setAddressLastName(String lastName){
        customerLastNameField.clear();
        customerLastNameField.sendKeys(lastName);
    }

    public void setTextField(WebElement e, String value){
        e.clear();
        e.sendKeys(value);
    }

    public void setCompanyField(String name){
        setTextField(companyField, name);
    }

    public void setAddressField1(String firstLineAddress){
        setTextField(addressField1, firstLineAddress);
    }

    public void setCity(String city){
        setTextField(cityField, city);
    }

    public void selectState(String name){
        getSelectOption(state).selectByVisibleText(name);
    }

    public void setZipCode(String zipCode){
        postCode.clear();
        postCode.sendKeys(zipCode);
    }

    public void selectCountry(String option){
        getSelectOption(country).selectByVisibleText(option);
    }

    public void setMobileNo(String number){
        mobilePhone.clear();
        mobilePhone.sendKeys(number);
    }

    public void setAlias(String name){
        setTextField(alias, name);
    }

    public AccountPage clickRegisterButton(){
        registerButton.click();
        return new AccountPage(driver);
    }

    public AddressPage clickRegister(){
        registerButton.click();
        return new AddressPage(driver);
    }


}
