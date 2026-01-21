package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarInsurancePage extends BasePage {
    private By registrationLocator = By.xpath("//input[@name='registrationNumber']");
    private By brandMarutiLocator = By.xpath("//a[@title='Maruti']/span[text()='Maruti']");
    private By variantAltoLocator = By.xpath("//div[@title='Alto 800']");
    private By fuelPetrolLocator = By.xpath("//li[text()='Petrol']");
    private By fuelVariantLocator = By.xpath("//li[text()='LX  (796 cc)']");
    private By yearLocator = By.xpath("//li[text()='2026']");
    private By customerNameLocator = By.xpath("//input[@id='customerName']");
    private By mobileNumberLocator = By.xpath("//input[@id='mobileNumber']");
    private By checkboxLocator = By.xpath("//*[@id=\"modal-popup\"]/div/div[3]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/label/span");
    private By viewPricesButtonLocator = By.xpath("//*[@id=\"modal-popup\"]/div/div[3]/div[1]/div/div[2]/div[2]/div[2]/button");

    public CarInsurancePage(WebDriver driver) {
        super(driver);
    }

    public void enterRegistration(String registrationNumber) {
        WebElement registration = wait.until(ExpectedConditions.visibilityOfElementLocated(registrationLocator));
        registration.clear();
        registration.sendKeys(registrationNumber);
    }

    public void selectBrand() {
        wait.until(ExpectedConditions.presenceOfElementLocated(brandMarutiLocator));
        WebElement brand = wait.until(ExpectedConditions.elementToBeClickable(brandMarutiLocator));
        js.executeScript("arguments[0].scrollIntoView(true);", brand);
        js.executeScript("arguments[0].click();", brand);
    }

    public void selectVariant() {
        wait.until(ExpectedConditions.presenceOfElementLocated(variantAltoLocator));
        WebElement variant = wait.until(ExpectedConditions.elementToBeClickable(variantAltoLocator));
        js.executeScript("arguments[0].click();", variant);
    }

    public void selectFuel() {
        wait.until(ExpectedConditions.presenceOfElementLocated(fuelPetrolLocator));
        WebElement fuel = wait.until(ExpectedConditions.elementToBeClickable(fuelPetrolLocator));
        js.executeScript("arguments[0].click();", fuel);
    }

    public void selectFuelVariant() {
        wait.until(ExpectedConditions.presenceOfElementLocated(fuelVariantLocator));
        WebElement fuelVariant = wait.until(ExpectedConditions.elementToBeClickable(fuelVariantLocator));
        js.executeScript("arguments[0].click();", fuelVariant);
    }

    public void selectYear() {
        // Wait for element to be stable and clickable
        wait.until(ExpectedConditions.presenceOfElementLocated(yearLocator));
        wait.until(ExpectedConditions.elementToBeClickable(yearLocator));
        WebElement year = driver.findElement(yearLocator);
        js.executeScript("arguments[0].scrollIntoView(true);", year);
        wait.until(ExpectedConditions.elementToBeClickable(yearLocator)).click();
    }

    public void enterCustomerName(String name) {
        WebElement customerName = wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameLocator));
        customerName.sendKeys(name);
    }

    public void enterMobileNumber(String mobile) {
        WebElement mobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberLocator));
        mobileNumber.sendKeys(mobile);
    }

    public void acceptTermsAndConditions() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator));
        checkbox.click();
    }

    public void clickViewPrices() {
        WebElement viewPrices = wait.until(ExpectedConditions.elementToBeClickable(viewPricesButtonLocator));
        viewPrices.click();
    }

    public void navigateToQuotes() {
        driver.navigate().to("https://www.insurancedekho.com/car-insurance/quotes?request=696dce967dd99b5c0dd2e921");
    }

    public void fillCarDetails(String registration, String name, String mobile) {
        enterRegistration(registration);
        // Use polling wait before brand selection
        wait.until(ExpectedConditions.presenceOfElementLocated(brandMarutiLocator));
        selectBrand();
        wait.until(ExpectedConditions.presenceOfElementLocated(variantAltoLocator));
        selectVariant();
        wait.until(ExpectedConditions.presenceOfElementLocated(fuelPetrolLocator));
        selectFuel();
        wait.until(ExpectedConditions.presenceOfElementLocated(fuelVariantLocator));
        selectFuelVariant();
        wait.until(ExpectedConditions.presenceOfElementLocated(yearLocator));
        selectYear();
        enterCustomerName(name);
        enterMobileNumber(mobile);
        acceptTermsAndConditions();
        clickViewPrices();
    }
}
