package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.HomePage;
import org.example.pages.ResultsPage;
import org.example.pages.TravelInsurancePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class TravelInsuranceTest extends BaseTest {
    
    @Test(priority = 3, description = "Test Travel Insurance quote retrieval")
    public void testTravelInsurance() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            HomePage homePage = new HomePage(driver);
            TravelInsurancePage travelPage = new TravelInsurancePage(driver);
            ResultsPage resultsPage = new ResultsPage(driver);

            // Navigate to Travel Insurance
            homePage.navigateToHome();
            homePage.navigateToTravel();
            
            // Wait for travel plans to be visible
            wait.until(ExpectedConditions.presenceOfElementLocated(travelPage.getTravelPlansLocator()));

            // Display travel results
            resultsPage.printPlanAndPrices("TRAVEL INSURANCE QUOTES - STUDENT PLANS",
                    travelPage.getTravelPlansLocator(),
                    travelPage.getTravelPricesLocator());
            
            System.out.println("\n✅ TEST PASSED: Travel Insurance Test Completed Successfully!\n");
            Assert.assertTrue(true, "Travel Insurance Test Passed");
        } catch (Exception e) {
            System.err.println("\n❌ TEST FAILED: Travel Insurance Test - " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Travel Insurance Test Failed: " + e.getMessage());
        }
    }
}
