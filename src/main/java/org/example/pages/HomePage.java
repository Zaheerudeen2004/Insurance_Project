package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By carTabLocator = By.xpath("//div[@class='tabName'][contains(text(), 'Car')]");
    private By bikeTabLocator = By.xpath("//div[text()='Bike']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHome() {
        driver.navigate().to("https://www.insurancedekho.com/");
    }

    public void clickCarTab() {
        WebElement carTab = wait.until(ExpectedConditions.elementToBeClickable(carTabLocator));
        carTab.click();
    }

    public void clickBikeTab() {
        WebElement bikeTab = wait.until(ExpectedConditions.elementToBeClickable(bikeTabLocator));
        bikeTab.click();
    }

    public void navigateToTravel() {
        try {
            // Wait for page to be ready
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[contains(text(), 'Travel Insurance')]")
            ));
            
            // Navigate directly via URL or find by text
            WebElement travelLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Travel Insurance')]")
            ));
            
            // Click using JavascriptExecutor to avoid stale element issues
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", travelLink);
            
            // Wait for the travel insurance page to load
            wait.until(ExpectedConditions.urlContains("travel-insurance"));
        } catch (Exception e) {
            // Fallback: navigate directly
            driver.navigate().to("https://www.insurancedekho.com/travel-insurance");
            wait.until(ExpectedConditions.urlContains("travel-insurance"));
        }
    }
}
