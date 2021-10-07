# HomeLoanCalculator
This is a demo project to calculate home loan
# DemoProject
Steps to Run:
Pull the code from git repository
Go to ->src->test->Java->step definition->Test Runner
Right click on Test Runner->select Run as Junit test

Steps to get the Report:
Go to target->My Reports->xml report
Note: Out of 3 the first and third test case is failed as the expected condition is not matching.

Question 1:What other test we can write-
Scenario 1: We can verify if the user is getting any error message without entering any amount and clicking on "Workout how much i borrow" button
Scenario 2: We can verify what is the maximum amount user is able enter for all text box
Scenario 3: We can verify scenario by changing the 'Application type', 'Property you would like to buy'
Scenario 4: We can verify that 'living expenses' is a mandatory field and without entering any amount user will not be able to proceed.

Question2: How to handle if its a part of large test set how to speed it up--
If its a part of larger test set, we can reuse the code or we can build custom library. We can use Grouping and parameterization.And we can use parallal execution.

Question 3: How to handle if UI tests fail unpredictably. For example, the page may not have fully loaded----
When test fails we can use pageloadTimeout. Or we can use explicit wait where driver will wait for certain condition to met before moving to next step.


