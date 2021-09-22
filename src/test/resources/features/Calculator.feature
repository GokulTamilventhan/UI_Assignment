@testSuite
  Feature: Functionality of the borrowing estimate calculator
    @Testcase1 @Testcase3 @TestSuite
    Scenario Outline: Verification of borrowing estimate calculation
      Given the borrowing calculator webpage is launched
      # When the webpage is completely loaded
      When a person selects application type as "<applicationType>"
      And a person selects the number of dependents as "<noOfDependents>"
      And a person selects property you would to buy as "<property>"
      And a person enters your income(before tax) as "<income>" per year
      And a person enters your other income as "<otherIncome>" per year
      And a person enters living expenses as "<expenses>" per month
      And a person enters current home loan repayments "<homeLoanRepaymentAmount>" per month
      And a person enters other loan repayments as "<otherLoanRepayment>" per month
      And a person enters other commitments as "<otherCommitments>" per month
      And a person enters total credit limit as "<totalCreditLimit>"
      And the person clicks on the button "Work out how much I could borrow"
      Then I validate that the borrowing estimate is equal to "<expectedValue>" and "<validateMessage>"
      Then I close the browser

      Examples:
        | applicationType | noOfDependents | property        | income | otherIncome | expenses | homeLoanRepaymentAmount | otherLoanRepayment | otherCommitments | totalCreditLimit | expectedValue                                                                                                                                                   | validateMessage |
        | Single          | 0              | Home to live in | 80000  | 10000       | 500      | 0                       | 100                | 0                | 10000            | $479,000                                                                                                                                                        | false           |
        | Single          | 0              | Home to live in | 0      | 0           | 1        | 0                       | 0                  | 0                | 0                | Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641. | true            |


    @Testcase2Part1 @TestSuite
    Scenario Outline: Start over button clears the form when valid inputs are given
      Given the borrowing calculator webpage is launched
      # When the webpage is completely loaded
      When a person selects application type as "<applicationType>"
      And a person selects the number of dependents as "<noOfDependents>"
      And a person selects property you would to buy as "<property>"
      And a person enters your income(before tax) as "<income>" per year
      And a person enters your other income as "<otherIncome>" per year
      And a person enters living expenses as "<expenses>" per month
      And a person enters current home loan repayments "<homeLoanRepaymentAmount>" per month
      And a person enters other loan repayments as "<otherLoanRepayment>" per month
      And a person enters other commitments as "<otherCommitments>" per month
      And a person enters total credit limit as "<totalCreditLimit>"
      And the person clicks on the button "Work out how much I could borrow"
      Then I click on "Start Over" to clear the form
      Then I validate if the start over button clears the form
      Then I close the browser

      Examples:
        | applicationType | noOfDependents | property        | income | otherIncome | expenses | homeLoanRepaymentAmount | otherLoanRepayment | otherCommitments | totalCreditLimit | expectedBorrowingEstimate |  |
        | Single          | 0              | Home to live in | 80000  | 10000       | 500      | 0                       | 100                | 0                | 10000            | $479,000                  |  |


    @Testcase2Part2 @TestSuite
    Scenario Outline: Start over button clears the form when insufficient inputs are given
      Given the borrowing calculator webpage is launched
      # When the webpage is completely loaded
      When a person selects application type as "<applicationType>"
      And a person selects the number of dependents as "<noOfDependents>"
      And a person selects property you would to buy as "<property>"
      And a person enters living expenses as "<expenses>" per month
      And the person clicks on the button "Work out how much I could borrow"
      Then I click on "Start Over" to clear the form
      Then I validate if the start over button clears the form
      Then I close the browser

      Examples:
        | applicationType | noOfDependents | property        | income | otherIncome | expenses | homeLoanRepaymentAmount | otherLoanRepayment | otherCommitments | totalCreditLimit | expectedBorrowingEstimate |  |
        | Single          | 0              | Home to live in | 80000  | 10000       | 500      | 0                       | 100                | 0                | 10000            | $479,000                  |  |