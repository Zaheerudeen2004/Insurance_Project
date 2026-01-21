package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.CarInsurancePage;
import org.example.pages.HomePage;
import org.example.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarInsuranceTest extends BaseTest {
    
    @Test(priority = 1, description = "Test Car Insurance quote retrieval")
    public void testCarInsurance() {
        try {
            HomePage homePage = new HomePage(driver);
            CarInsurancePage carPage = new CarInsurancePage(driver);
            ResultsPage resultsPage = new ResultsPage(driver);

            // Navigate to Car Insurance
            homePage.clickCarTab();

            // Fill car details
            carPage.fillCarDetails("DL12AB2345", "BALA", "6380521678");

            // Navigate to quotes page
            carPage.navigateToQuotes();

            // Display results
            resultsPage.printPlanAndPrices("CAR INSURANCE QUOTES",
                    resultsPage.carPlanNamesLocator,
                    resultsPage.carPricesLocator);

            System.out.println("\n✅ TEST PASSED: Car Insurance Test Completed Successfully!\n");
            Assert.assertTrue(true, "Car Insurance Test Passed");
        } catch (Exception e) {
            System.err.println("\n❌ TEST FAILED: Car Insurance Test - " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Car Insurance Test Failed: " + e.getMessage());
        }
    }
}
