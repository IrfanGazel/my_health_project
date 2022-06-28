Feature: user_registration


  Background: user is on the home page
    Given user is on the home page

  @new_register
  Scenario: TC_01 user_registration_testing
    When user clicks on the user icon
    And user clicks on the register link
    Then user should be on the register page and should see the register title
    And user sends SSN number as "654-54-5440"
    And user sends first name as "team83_user_04"
    And user sends last name as "user_04"

