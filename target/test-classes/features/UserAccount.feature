Feature: User Account Management

  Scenario: Successful User Registration
    Given I am on the home page
    When I navigate to the registration page
    And I register with valid details
    Then I should see text "Your Account Has Been Created!"

  Scenario: Successful User Login
    Given I am on the home page
    When I navigate to the login page
    And I login with valid credentials
    Then I should see text "Edit your account information"

  Scenario: Failed User Login
    Given I am on the home page
    When I navigate to the login page
    And I login with invalid credentials
    Then I should see text "Warning: No match for E-Mail Address and/or Password."

  Scenario: Forgot Password
    Given I am on the home page
    When I request password reset for "testuser@gmail.com"
    Then I should see text "An email with a confirmation link has been sent your email address."

  Scenario: Profile Update
    Given I am logged in
    When I update my profile with "vinay"
    Then I should see text "Success: Your account has been successfully updated."

  Scenario: Order History
    Given I am logged in
    When I check my order history
    Then I should see text "Order History"
