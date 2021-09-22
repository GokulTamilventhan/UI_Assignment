package PageObjects;

public class CalculatorPageObjects {
    public static String projectPath = System.getProperty("user.dir");
    public static String chromeDriverPath = projectPath+"/chromeDriver/chromedriver.exe";
    public static String screenShotsPath = projectPath+"/screenCapture/";
    public static String applicationTypeSingle = "application_type_single";
    public static String applicationTypeJoint = "application_type_joint";
    public static String numberOfDependantsInYourDetails = "//*[@title='Number of dependants']";
    public static String borrowTypeHome = "borrow_type_home";
    public static String borrowTypeInvestment = "borrow_type_investment";
    public static String incomeBeforeTaxField = "//*[text()='Your income (before tax)']/../div/input";
    public static String otherIncomeField = "//*[text()='Your other income']/../div/input";
    public static String livingExpensesField = "//*[text()='Living expenses']/../div/input";
    public static String currentHomeLoanRepaymentsField = "//*[text()='Current home loan repayments']/../div/input";
    public static String otherLoanRepaymentsField = "//*[text()='Other loan repayments']/../div/input";
    public static String otherCommitmentsField = "//*[text()='Other commitments']/../div/input";
    public static String totalCreditCardLimitsField = "//*[text()='Total credit card limits']/../div/input";
    public static String workOutHowMuchICouldBorrowButton = "//*[text()='Work out how much I could borrow']";
    public static String borrowingEstimatePresenceIdentifier = "//*[@id = 'borrowResultTextAmount']/..";
    public static String borrowingEstimateIdentifier = "borrowResultTextAmount";
    public static String startOverIdentifier = "//*[@aria-live = 'assertive']/../../div[@class='box--right']/button";
    public static String messageIdentifier = "//*[@class='borrow__error__text']";

}
