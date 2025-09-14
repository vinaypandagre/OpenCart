Feature: Product Details and Add to Cart
Background:
    Given I am on the home page
    When I search Product "HP LP3065"
    And Click On The Product Link

  Scenario: Verify Product Description Without Login
    Then I should see text "Description"

  Scenario: Add To Cart Test Without Login
    When I Click on Add to Cart
    Then I should see text "Success: You have added "

  Scenario: Multiple Products Add Test  Without Login
    When I Click on Add to Cart
    And I search another Product "iPhone"
    When I Click on Add to Cart1
    And I Click On Checkout
	Then I should see the link of:
  		| HP LP3065 |
  		| iPhone    |

    
   
