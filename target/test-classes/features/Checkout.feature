Feature: Checkout Process

Background:
    Given I am on the home page
    When I search Product "HP LP3065"
    And Click On The Product Link
    When I Click on Add to Cart
    And I Click On Checkout

Scenario: Navigate to Checkout Page
    Then I am Navigate to Checkout Page

Scenario: Fill Billing Details
    Then I am Navigate to Checkout Page
    And I Fill the Billing Details
    Then I should see text "Please select the preferred shipping method to use on this order"

Scenario: Select Payment Method
    Then I am Navigate to Checkout Page
    And I Fill the Billing Details
    Then I should see text "Please select the preferred shipping method to use on this order"
    And Check For Shipping Method

Scenario: Place Order
    Then I am Navigate to Checkout Page
    And I Fill the Billing Details
    And Check For Shipping Method
    Then The Order is Confirmed
