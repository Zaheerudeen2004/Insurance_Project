package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelInsurancePage extends BasePage {
    public By travelPlansLocator = By.xpath("//div[@class='tpcards tpCardsV2']/div[@class='d-flex jsb aic tpInnerMain']/a");
    public By travelPricesLocator = By.xpath("//div[@class='starting']/span");

    public TravelInsurancePage(WebDriver driver) {
        super(driver);
    }

    public By getTravelPlansLocator() {
        return travelPlansLocator;
    }

    public By getTravelPricesLocator() {
        return travelPricesLocator;
    }
}
