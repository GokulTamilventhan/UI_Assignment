# READ ME
# Prerequisite:
JDK: 17
IDE: IntelliJ
Plugins for intelliJ: Cucumber for java, maven, gherkin
Maven dependencies for cucumber, junit and selenium

# Executing the test cases:
1.	Open Calculator.feature file and mention a tag prefixing ‘@’ before each test cases to run the test cases separately or provide a common tag before ‘Feature’ line to run all test cases sequencially.
2.	Open Test Runner file and enter the same tag in feature file under tags.
3.	Save the file. Right click on Test runner file and click on Run Test Runner. The test cases will start to execute, and the cucumber report will be generated under target folder in the project.
Note: Test Runner file is already set with appropriate tags and ready for execution.

# Question and Answer Section
# 1. What other test cases would you suggest?
-	Giving invalid values like alphabets in text field, negative integer values 
-	By choosing the application type to ‘Joint’ as it enables additional fields 
-	Selecting different values to the number of dependents
-	Clicking on ‘Work out how much I could do’ to verify the mandatory fields check
-	Clicking on i- information circle to check the static messages
-	Clicking on ANZ repayments calculator is navigated to the expected webpage
-	UIUX testing to verify the UX content of the webpage 
-	Cross browser testing in multiple devices
-	All links in the webpage are getting navigated to appropriate site
-	Form fills for pre-approval with valid and invalid inputs
-	Submit the empty form to validate the mandatory field messages in apply for pre-approval form
-	Check all the static answers under your questions are answered section
-	Buttons like Apply online now, leave your details, find a mobile lender, find your nearest location, and call us are navigating to the respective website
-	Validate the hamburger menu
-	Validate search functionality 
-	Validate if login and register for internet banking are navigated to the respective pages

# 2. If this was part of the larger test, how would you speed up the test?
-	The test case execution speed will be increased by implementing parallel execution 
-	Using xpath for locating elements will be reduced as it does lot of background processing
-	Unnecessary wait statements will be eliminated, and conditional waits are used as it proceeds with the execution once the condition is satisfied 
-	Usage of TestNG framework identifies the errors immediately and reduces time.
-	Using headless browsers improves the performance which executes the test cases without GUI
-	The speed can be improved by disabling images using browser settings to test functional flow.

# 3. Sometimes UI tests can fail unpredictably. For example, the page may not have the fully loaded before test automation attempts to click a button on a webpage. How would you improve the reliability of these tests?
Implicit and explicit waits can be used to wait until the entire page is loaded. Implicit wait waits for the certain amount of time specified whereas the explicit wait waits until the expected conditions are met. Based on the test case, these can be used. Exception handling and logging can be implemented to stabilise the scripts.
