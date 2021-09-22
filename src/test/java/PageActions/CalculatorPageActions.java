package PageActions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import PageObjects.CalculatorPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestException;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPageActions {
    CalculatorPageObjects pageObject = new CalculatorPageObjects();
    SoftAssert softAssert = new SoftAssert();

    public WebDriver launchApplication(WebDriver driver, String baseURL) {
        System.setProperty("webdriver.chrome.driver", pageObject.chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        return driver;
    }

    public void selectApplicationType(WebDriver driver, String applicationType) {
        if(applicationType.equalsIgnoreCase( "Single")) {
            driver.findElement(By.id(pageObject.applicationTypeSingle)).click();
        } else if (applicationType.equalsIgnoreCase( "Joint")){
            driver.findElement(By.id(pageObject.applicationTypeJoint)).click();
        } else {
            // throw exception - application type
            System.out.println("Test data issue;" + applicationType +" Not a valid application type");
        }
    }

    public void selectNumberOfDependents(WebDriver driver, String testDataNumberOfDependents) {
        Select numberOfDependants = new Select(driver.findElement(By.xpath(pageObject.numberOfDependantsInYourDetails)));
        numberOfDependants.selectByVisibleText(testDataNumberOfDependents);
    }

    public void selectBorrowType(WebDriver driver, String borrowType) {
        if(borrowType.equalsIgnoreCase("Home to live in")){
            driver.findElement(By.id(pageObject.borrowTypeHome)).click();
        } else if(borrowType.equalsIgnoreCase("Residential Investment")) {
            driver.findElement(By.id(pageObject.borrowTypeInvestment)).click();
        } else {
            // throw exception - borrow type
            System.out.println("Test data issue;" + borrowType +" Not a valid application type");
        }
    }

    public void enterIncomeBeforeTax(WebDriver driver, String incomeBeforeTax) {
        driver.findElement(By.xpath(pageObject.incomeBeforeTaxField)).clear();
        driver.findElement(By.xpath(pageObject.incomeBeforeTaxField)).sendKeys(incomeBeforeTax);
    }

    public void enterOtherIncome(WebDriver driver, String otherIncome) {
        driver.findElement(By.xpath(pageObject.otherIncomeField)).clear();
        driver.findElement(By.xpath(pageObject.otherIncomeField)).sendKeys(otherIncome);
    }

    public void enterLivingExpenses(WebDriver driver, String livingExpenses){
        driver.findElement(By.xpath(pageObject.livingExpensesField)).clear();
        driver.findElement(By.xpath(pageObject.livingExpensesField)).sendKeys(livingExpenses);
    }

    public void enterCurrentHomeLoanRepayments(WebDriver driver, String currentHomeLoanRepayments) {
        driver.findElement(By.xpath(pageObject.currentHomeLoanRepaymentsField)).clear();
        driver.findElement(By.xpath(pageObject.currentHomeLoanRepaymentsField)).sendKeys(currentHomeLoanRepayments);
    }

    public void enterOtherLoanRepayments(WebDriver driver, String otherLoanRepayments) {
        driver.findElement(By.xpath(pageObject.otherLoanRepaymentsField)).clear();
        driver.findElement(By.xpath(pageObject.otherLoanRepaymentsField)).sendKeys(otherLoanRepayments);
    }

    public void enterOtherCommitments(WebDriver driver, String otherCommitments) {
        driver.findElement(By.xpath(pageObject.otherCommitmentsField)).clear();
        driver.findElement(By.xpath(pageObject.otherCommitmentsField)).sendKeys(otherCommitments);
    }

    public void enterTotalCreditCardLimits(WebDriver driver, String totalCreditCardLimits) {
        driver.findElement(By.xpath(pageObject.totalCreditCardLimitsField)).clear();
        driver.findElement(By.xpath(pageObject.totalCreditCardLimitsField)).sendKeys(totalCreditCardLimits);
    }

    public void clickWorkOutHowMuchICouldBorrowButton(WebDriver driver, String workOutHowMuchICouldBorrowButton) {
        driver.findElement(By.xpath(pageObject.workOutHowMuchICouldBorrowButton)).click();
    }

    public void validateBorrowingEstimate(WebDriver driver, String expectedBorrowingEstimate) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(pageObject.borrowingEstimatePresenceIdentifier),"aria-live","assertive"));
        String actualBorrowingEstimate = driver.findElement(By.id(pageObject.borrowingEstimateIdentifier)).getText();
        System.out.println("actual borrowing estimate: " + actualBorrowingEstimate + "; Comparison Output: " + actualBorrowingEstimate.equals(expectedBorrowingEstimate));
        softAssert.assertEquals(actualBorrowingEstimate,expectedBorrowingEstimate, "Assert Result");
        softAssert.assertAll();
        try {
            if (expectedBorrowingEstimate.equals(actualBorrowingEstimate)) {
                System.out.println("Test PASSED; Expected Borrowing Estimate: " + expectedBorrowingEstimate + " matches the Actual Borrowing Estimate: " + actualBorrowingEstimate);
            } else {
                throw new TestException("Value mismatch");
            }
        }
        catch (TestException exception){
            System.out.print("Test FAILED; Expected Borrowing Estimate: " + expectedBorrowingEstimate + " did not match the Actual Borrowing Estimate: " + actualBorrowingEstimate);
        }
    }

    public void validateMessage(WebDriver driver, String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(pageObject.messageIdentifier),"aria-live","assertive"));
        String actualMessage = driver.findElement(By.xpath(pageObject.messageIdentifier)).getText();
        System.out.println("actual message: " + actualMessage);
        softAssert.assertEquals(actualMessage,expectedMessage, "Assert Result");
        softAssert.assertAll();
        try {
            if (expectedMessage.equals(actualMessage)) {
                System.out.println("Test PASSED; Expected Message: " + expectedMessage + " matches the Actual Message: " + actualMessage);
            } else {
                throw new TestException("Value mismatch");
            }
        }
        catch (TestException exception){
            System.out.print("Test FAILED; Expected Message: " + expectedMessage + " did not match the Actual Message: " + actualMessage);
        }
    }

    public void closeBrowser(WebDriver driver) {
        driver.close();
        driver.quit();
    }

    public void clickStartOver(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageObject.startOverIdentifier)));
        driver.findElement(By.xpath(pageObject.startOverIdentifier)).click();
    }

    public void validateClearForm(WebDriver driver) {
        //Asserting application type
        boolean defaultApplicationTypeValue = driver.findElement(By.id(pageObject.applicationTypeSingle)).isSelected();
        softAssert.assertTrue(defaultApplicationTypeValue, "Default application type is enabled");

        //Asserting default value for number of dependents
        String defaultNumberOfDependents = "0";
        Select select = new Select(driver.findElement(By.xpath(pageObject.numberOfDependantsInYourDetails)));
        WebElement option = select.getFirstSelectedOption();
        String actualOptionSelected = option.getText();
        softAssert.assertTrue((defaultNumberOfDependents.equals(actualOptionSelected)), "Number of dependents is set to default value");

        //Asserting property you would like to buy
        boolean defaultPropertyToBuy = driver.findElement(By.id(pageObject.borrowTypeHome)).isSelected();
        softAssert.assertTrue(defaultPropertyToBuy, "Default property to buy option is enabled is enabled");

        // Asserting your income field
        String defaultYourIncomeValue = "0";
        String expectedYourIncomeFieldValue = driver.findElement(By.xpath(pageObject.incomeBeforeTaxField)).getAttribute("value");
        softAssert.assertEquals(defaultYourIncomeValue, expectedYourIncomeFieldValue, "TEST FAILED! Your income field is not set to default value");

        // Asserting your other income field
        String defaultYourOtherIncomeValue = "0";
        String expectedYourOtherIncomeValue = driver.findElement(By.xpath(pageObject.otherIncomeField)).getAttribute("value");
        softAssert.assertEquals(defaultYourOtherIncomeValue, expectedYourOtherIncomeValue, "TEST FAILED! Your other income field is not set to default value");

        // Asserting living expense field
        String defaultLivingExpenseValue = "0";
        String expectedLivingExpenseValue = driver.findElement(By.xpath(pageObject.livingExpensesField)).getAttribute("value");
        softAssert.assertEquals(defaultLivingExpenseValue, expectedLivingExpenseValue, "TEST FAILED! Your living expense field is not set to default value");

        // Asserting current home loan repayments field
        String defaultCurrentHomeLoanRepaymentValue = "0";
        String expectedCurrentHomeLoanRepaymentValue = driver.findElement(By.xpath(pageObject.currentHomeLoanRepaymentsField)).getAttribute("value");
        softAssert.assertEquals(defaultCurrentHomeLoanRepaymentValue, expectedCurrentHomeLoanRepaymentValue, "TEST FAILED! Your current home loan repayment field is not set to default value");

        // Asserting other loan repayments field
        String defaultOtherHomeLoanRepaymentsValue = "0";
        String expectedOtherHomeLoanRepaymentsValue = driver.findElement(By.xpath(pageObject.otherLoanRepaymentsField)).getAttribute("value");
        softAssert.assertEquals(defaultOtherHomeLoanRepaymentsValue, expectedOtherHomeLoanRepaymentsValue, "TEST FAILED! Your other loan repayment field is not set to default value");

        // Asserting other commitments field
        String defaultOtherCommitmentsValue = "0";
        String expectedOtherCommitmentsValue = driver.findElement(By.xpath(pageObject.otherCommitmentsField)).getAttribute("value");
        softAssert.assertEquals(defaultOtherCommitmentsValue, expectedOtherCommitmentsValue, "TEST FAILED! Your other commitments field is not set to default value");

        // Asserting total credit limit field
        String defaultTotalCreditLimitValue = "0";
        String expectedTotalCreditLimitValue = driver.findElement(By.xpath(pageObject.totalCreditCardLimitsField)).getAttribute("value");
        softAssert.assertEquals(defaultTotalCreditLimitValue, expectedTotalCreditLimitValue, "TEST FAILED! Your total credit limit field is not set to default value");

        softAssert.assertAll();

    }
}
