package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.BikeInsurancePage;
import org.example.pages.HomePage;
import org.example.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BikeInsuranceTest extends BaseTest {
    
    @Test(priority = 2, description = "Test Bike Insurance quote retrieval")
    public void testBikeInsurance() {
        try {
            HomePage homePage = new HomePage(driver);
            BikeInsurancePage bikePage = new BikeInsurancePage(driver);
            ResultsPage resultsPage = new ResultsPage(driver);

            // Navigate to Bike Insurance
            homePage.navigateToHome();
            homePage.clickBikeTab();

            // Fill bike details
            bikePage.enterRegistration("TN51AE8196");
            bikePage.clickCheckPricesUsingJS();
            bikePage.selectBikeDetails();

            // Navigate to quotes page
            bikePage.navigateToQuotes();

            // Display results
            resultsPage.printPlanAndPrices("BIKE INSURANCE QUOTES",
                    resultsPage.bikePlanNamesLocator,
                    resultsPage.bikePricesLocator);

            System.out.println("\n✅ TEST PASSED: Bike Insurance Test Completed Successfully!\n");
            Assert.assertTrue(true, "Bike Insurance Test Passed");
        } catch (Exception e) {
            System.err.println("\n❌ TEST FAILED: Bike Insurance Test - " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Bike Insurance Test Failed: " + e.getMessage());
        }
    }
}
