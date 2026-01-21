package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BikeInsurancePage extends BasePage {
    private By registrationLocator = By.name("registrationNumber");
    private By checkPricesLocator = By.xpath("//span[text()='Check Prices']");
    private By brandHondaLocator = By.xpath("//a[@title='Honda']");
    private By modelLocator = By.xpath("//*[@id=\"modal-popup\"]/div/div[2]/div[1]/div/div[3]/div/div[1]/ul/div[1]");
    private By variantLocator = By.xpath("//*[@id=\"modal-popup\"]/div/div[2]/div[1]/div/div[2]/div/div/div/div[1]/ul/li");
    private By nextButtonLocator = By.xpath("//*[@id=\"modal-popup\"]/div/div[2]/div[1]/div/div[3]/div/div[1]/ul/li[1]");

    public BikeInsurancePage(WebDriver driver) {
        super(driver);
    }

    public void enterRegistration(String registrationNumber) {
        WebElement registration = wait.until(ExpectedConditions.elementToBeClickable(registrationLocator));
        registration.sendKeys(registrationNumber);
    }

    public void clickCheckPricesUsingJS() {
        WebElement checkPrices = wait.until(ExpectedConditions.presenceOfElementLocated(checkPricesLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkPrices);
    }

    public void selectBrand() {
        wait.until(ExpectedConditions.presenceOfElementLocated(brandHondaLocator));
        WebElement brand = wait.until(ExpectedConditions.elementToBeClickable(brandHondaLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", brand);
    }

    public void selectModel() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modelLocator));
        WebElement model = wait.until(ExpectedConditions.elementToBeClickable(modelLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", model);
    }

    public void selectVariant() {
        wait.until(ExpectedConditions.presenceOfElementLocated(variantLocator));
        WebElement variant = wait.until(ExpectedConditions.elementToBeClickable(variantLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", variant);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(nextButtonLocator));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
    }

    public void navigateToQuotes() {
        driver.navigate().to("https://www.insurancedekho.com/bike-insurance/quotes?request=696dede53e886a94698fc186#confirmReg");
    }

    public void selectBikeDetails() {
        selectBrand();
        selectModel();
        selectVariant();
        clickNextButton();
    }
}
