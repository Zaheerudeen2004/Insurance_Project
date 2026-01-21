package org.example.pages;

import java.util.ArrayList;
import java.util.List;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {
    // Locators for Car Insurance Results
    public By carPlanNamesLocator = By.xpath("//div[@class='brandNam black3 ']");
    public By carPricesLocator = By.xpath("//div[@class='right']/button");

    // Locators for Bike Insurance Results
    public By bikePlanNamesLocator = By.xpath("//div[@class='brandNam black3 ']");
    public By bikePricesLocator = By.xpath("//div[@class='right']/button");

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNames(By namesLocator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(namesLocator));
        List<WebElement> elems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(namesLocator));
        List<String> list = new ArrayList<>();
        for (WebElement e : elems) {
            list.add(e.getText().trim());
        }
        return list;
    }

    public List<String> getPrices(By pricesLocator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(pricesLocator));
        List<WebElement> elems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pricesLocator));
        List<String> list = new ArrayList<>();
        for (WebElement e : elems) {
            try {
                list.add(e.getText().trim());
            } catch (Exception ex) {
                list.add("Price Unavailable");
            }
        }
        return list;
    }

    public void printPlanAndPrices(String title, By namesLocator, By pricesLocator) {
        List<String> names = getNames(namesLocator);
        List<String> prices = getPrices(pricesLocator);
        int size = Math.min(names.size(), prices.size());
        
        // Print header with border
        System.out.println("\n");
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    " + centerText(title, 51) + "                    ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣");
        
        // Print each insurance plan with numbering
        for (int i = 0; i < size; i++) {
            String number = String.format("%2d.", (i + 1));
            String planInfo = String.format("%-45s --> %s", names.get(i), prices.get(i));
            System.out.println("║  " + number + " " + String.format("%-68s", planInfo) + " ║");
        }
        
        // Print footer with count
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║  Total Plans Found: " + String.format("%-52d", size) + " ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
    }
    
    private String centerText(String text, int width) {
        if (text.length() >= width) return text;
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) sb.append(" ");
        sb.append(text);
        return sb.toString();
    }
}
