Feature:  Product Search and Filter
Background:
    Given I am on the home page
    When I search Product "MacBook"

  Scenario: Verify Product Search Functionality
    Then I should see the link of:
    | MacBook |
 
 Scenario: Verify Category Filter 
    And Select Category
    Then I should see text "There is no product that matches the search criteria."
    
    Scenario:  Verify Sorting Functionality - price high to Low
    And Select Price High to Low
    Then Sorting High to Low 
   
   Scenario:  Verify Sorting Functionality Price Low to High
    And Select Price Low to High
    Then Sorting Low to High
    
    