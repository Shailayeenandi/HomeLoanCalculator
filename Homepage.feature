Feature: feature to test borrowing calculator

  Scenario Outline: Check the borrowing estimate after adding expenses
    Given user is on borrowing calculator page
    When user enters <Applicationtype> <dependents> <income> <otherincome> <livingexpenses> <homeloan> <otherloan> <ommitments> <cclimit>
    And user clicks on workout how much i borrow button
    Then user has borrowing estimate of <totalamount>
    And user closes the borrowing calculator page

    Examples: 
      | Applicationtype | dependents | income | otherincome | livingexpenses | homeloan | otherloan | commitments | cclimit | totalamount|
      | Single          |          0 |  80000 |       10000 |            500 |        0 |       100 |           0 |   10000 |     $449,000|

  Scenario Outline: Check the start-over button clears the form
    Given user is on borrowing calculator page
    When user enters <Applicationtype> <dependents> <income> <otherincome> <livingexpenses> <homeloan> <otherloan> <ommitments> <cclimit>
    And user clicks on workout how much i borrow button
    And User clicks on start-over button and clear the form
    And user closes the borrowing calculator page
   
    Examples: 
      | Applicationtype | dependents | income | otherincome | livingexpenses | homeloan | otherloan | commitments | cclimit | 
      | Single          |          0 |  80000 |       10000 |            500 |        0 |       100 |           0 |   10000 |      
      
  Scenario Outline: Check the start-over button clears the form
    Given user is on borrowing calculator page
    When  user enters  <livingexpenses> 
    And user clicks on workout how much i borrow button
    Then user is getting an error message
    And user closes the borrowing calculator page

    Examples: 
     |livingexpenses| 
     |1|  
   