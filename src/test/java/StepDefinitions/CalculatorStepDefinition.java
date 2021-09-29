package StepDefinitions;

import PageActions.CalculatorPageActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;

public class CalculatorStepDefinition {
    String baseURL = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";
    WebDriver driver;
    CalculatorPageActions pageAction = new CalculatorPageActions();

    @Given("^the borrowing calculator webpage is launched$")
    public void the_borrowing_calculator_webpage_is_launched() throws Throwable {
       driver =  pageAction.launchApplication(driver, baseURL);
    }

    @When("^the webpage is completely loaded$")
    public void the_webpage_is_completely_loaded() throws Throwable {

    }

    @When("^a person selects application type as \"([^\"]*)\"$")
    public void a_person_selects_application_type_as(String applicationType) throws Throwable {
        pageAction.selectApplicationType(driver, applicationType);
    }

    @When("^a person selects the number of dependents as \"([^\"]*)\"$")
    public void a_person_selects_the_number_of_dependents_as(String numberOfDependents) throws Throwable {
        pageAction.selectNumberOfDependents(driver, numberOfDependents);
    }

    @When("^a person selects property you would to buy as \"([^\"]*)\"$")
    public void a_person_selects_property_you_would_to_buy_as(String borrowType) throws Throwable {
        pageAction.selectBorrowType(driver, borrowType);
    }

    @When("^a person enters your income\\(before tax\\) as \"([^\"]*)\" per year$")
    public void a_person_enters_your_income_before_tax_as_per_year(String incomeBeforeTax) throws Throwable {
        pageAction.enterIncomeBeforeTax(driver, incomeBeforeTax);
    }

    @When("^a person enters your other income as \"([^\"]*)\" per year$")
    public void a_person_enters_your_other_income_as_per_year(String otherIncome) throws Throwable {
        pageAction.enterOtherIncome(driver, otherIncome);
    }

    @When("^a person enters living expenses as \"([^\"]*)\" per month$")
    public void a_person_enters_living_expenses_as_per_month(String livingExpenses) throws Throwable {
        pageAction.enterLivingExpenses(driver,livingExpenses);
    }

    @When("^a person enters current home loan repayments \"([^\"]*)\" per month$")
    public void a_person_enters_current_home_loan_repayments_per_month(String currentHomeLoanRepayments) throws Throwable {
        pageAction.enterCurrentHomeLoanRepayments(driver, currentHomeLoanRepayments);
    }

    @When("^a person enters other loan repayments as \"([^\"]*)\" per month$")
    public void a_person_enters_other_loan_repayments_as_per_month(String otherLoanRepayments) throws Throwable {
        pageAction.enterOtherLoanRepayments(driver, otherLoanRepayments);
    }

    @When("^a person enters other commitments as \"([^\"]*)\" per month$")
    public void a_person_enters_other_commitments_as_per_month(String otherCommitments) throws Throwable {
        pageAction.enterOtherCommitments(driver, otherCommitments);
    }

    @When("^a person enters total credit limit as \"([^\"]*)\"$")
    public void a_person_enters_total_credit_limit_as(String totalCreditCardLimits) throws Throwable {
        pageAction.enterTotalCreditCardLimits(driver, totalCreditCardLimits);
    }

    @When("^the person clicks on the button \"([^\"]*)\"$")
    public void the_person_clicks_on_the_button(String workOutHowMuchICouldBorrowButton) throws Throwable {
        pageAction.clickWorkOutHowMuchICouldBorrowButton(driver, workOutHowMuchICouldBorrowButton);
    }

    @Then("^I validate that the borrowing estimate is equal to \"([^\"]*)\"$")
    public void i_validate_that_the_borrowing_estimate_is_equal_to(String expectedBorrowingEstimate) throws Throwable {
        pageAction.validateBorrowingEstimate(driver, expectedBorrowingEstimate);
    }

    @Then("^I validate that the borrowing estimate is equal to \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iValidateThatTheBorrowingEstimateIsEqualToAnd(String expectedValue, String validateMessageFlag) throws Throwable {
        if(validateMessageFlag.equalsIgnoreCase("false")) {
            pageAction.validateBorrowingEstimate(driver, expectedValue);
        } else {
            pageAction.validateMessage(driver, expectedValue);
        }
    }

    @Then("^I click on \"([^\"]*)\" to clear the form$")
    public void iClickOnToClearTheForm(String flag) throws Throwable {
        pageAction.clickStartOver(driver);

    }

    @After
    @Then("^I close the browser$")
    public void i_close_the_browser() throws Throwable {
        pageAction.closeBrowser(driver);
    }

    @Then("^I validate if the start over button clears the form$")
    public void i_validate_if_the_start_over_button_clears_the_form() throws Throwable {
        pageAction.validateClearForm(driver);
    }


}
