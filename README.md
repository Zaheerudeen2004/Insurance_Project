# Insurance Automation Framework

A comprehensive **Page Object Model (POM)** framework for automating insurance website testing using Selenium WebDriver and Java.

## Project Structure

```
InsuranceAutomationFramework/
├── src/main/java/org/example/
│   ├── BasePage.java                 # Parent class for all pages
│   ├── base/
│   │   └── BaseTest.java             # Base test class with setup/teardown
│   ├── config/
│   │   └── ConfigReader.java         # Configuration properties reader
│   ├── pages/
│   │   ├── HomePage.java             # Home page actions
│   │   ├── CarInsurancePage.java      # Car insurance specific actions
│   │   ├── BikeInsurancePage.java     # Bike insurance specific actions
│   │   ├── TravelInsurancePage.java   # Travel insurance specific actions
│   │   └── ResultsPage.java           # Results extraction and display
│   ├── utils/
│   │   ├── WebDriverFactory.java      # WebDriver creation
│   │   ├── WaitUtils.java             # Wait conditions
│   │   └── ActionsUtil.java           # Action utilities
│   └── tests/
│       ├── CarInsuranceTest.java      # Car insurance test
│       ├── BikeInsuranceTest.java     # Bike insurance test
│       └── TravelInsuranceTest.java   # Travel insurance test
├── src/test/resources/
│   ├── config.properties              # Configuration data
│   └── testdata/
│       └── insuranceData.json         # Test data in JSON format
├── pom.xml                            # Maven configuration
└── README.md                          # This file
```

## Prerequisites

- **Java 11** or higher
- **Maven 3.6** or higher
- **Chrome Browser** installed on your system
- **WebDriver Manager** (automatically downloads ChromeDriver)

## Installation

1. **Clone or download the project**
2. **Navigate to the project directory:**
   ```bash
   cd Project_Linear_Code
   ```

3. **Install dependencies:**
   ```bash
   mvn clean install
   ```

## Configuration

Edit `src/test/resources/config.properties` to customize:
- Base URL
- Browser type
- Implicit/Explicit wait times
- Test data (registration numbers, username, mobile)

```properties
baseUrl=https://www.insurancedekho.com/
browser=chrome
implicitWait=10
explicitWait=50
username=GUNA
mobile=6380521678
```

## Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test

**Car Insurance Test:**
```bash
mvn exec:java -Dexec.mainClass="org.example.tests.CarInsuranceTest"
```

**Bike Insurance Test:**
```bash
mvn exec:java -Dexec.mainClass="org.example.tests.BikeInsuranceTest"
```

**Travel Insurance Test:**
```bash
mvn exec:java -Dexec.mainClass="org.example.tests.TravelInsuranceTest"
```

### Run in IDE
- Right-click on test class → Run As → Java Application

## Key Features

✅ **Page Object Model** - Clean separation of concerns
✅ **Reusable Base Classes** - BasePage & BaseTest
✅ **Configuration Management** - External config properties
✅ **Wait Utilities** - Implicit and explicit waits
✅ **Action Utilities** - Common actions like hover, click, drag-drop
✅ **Results Extraction** - Extract and display insurance plans and prices
✅ **Error Handling** - Try-catch blocks with proper logging
✅ **WebDriver Management** - Automatic ChromeDriver setup

## Test Coverage

### Car Insurance Flow
1. Click Car Tab
2. Enter registration number
3. Select brand (Maruti), variant (Alto 800)
4. Select fuel type and year
5. Enter customer details
6. Accept terms and view prices
7. Extract and display car insurance plans with prices

### Bike Insurance Flow
1. Click Bike Tab
2. Enter registration number
3. Click Check Prices (using JavaScript)
4. Select brand (Honda), model, and variant
5. Navigate to quotes page
6. Extract and display bike insurance plans with prices

### Travel Insurance Flow
1. Navigate to Travel Insurance
2. Extract and display available travel insurance plans with prices

## Dependencies

- **Selenium WebDriver** 4.15.0
- **WebDriverManager** 5.6.3
- **Google GSON** 2.10.1
- **Maven Compiler Plugin** 3.11.0

## Troubleshooting

### Issue: "Cannot find ChromeDriver"
**Solution:** WebDriverManager will automatically download the correct version. Ensure internet connectivity.

### Issue: "Config properties not found"
**Solution:** Ensure `config.properties` is in `src/test/resources/` directory.

### Issue: "Element not found" or "Timeout"
**Solution:** 
- Verify XPath locators in respective page classes
- Increase wait times in `BaseTest` or `config.properties`
- Check if website structure has changed

## Best Practices

1. **Keep locators in page objects** - Not scattered in tests
2. **Use meaningful method names** - Describe what action is performed
3. **Follow POM structure** - One page class per page
4. **Use explicit waits** - More reliable than implicit waits
5. **Handle exceptions properly** - Don't ignore errors
6. **Keep tests independent** - Each test should run standalone
7. **Use configuration files** - For test data and settings

## Contributing

To add new test cases:
1. Create a new page class in `src/main/java/org/example/pages/`
2. Extend `BasePage`
3. Add locators and methods
4. Create test class in `src/main/java/org/example/tests/`
5. Extend `BaseTest`
6. Implement test logic

## License

This project is open source and available under the MIT License.

## Support

For issues or questions, please refer to the project documentation or contact the development team.

---

**Last Updated:** January 2026
**Framework Version:** 1.0.0
