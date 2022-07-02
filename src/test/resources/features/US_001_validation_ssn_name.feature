@new_register
Feature: user_registration

  Background: user is on the home page & registration page
    Given user is on the home page
    When user clicks on the user icon
    And user clicks on the register link
    Then user should be on the register page and should see the register title


  Scenario: TC_01 user_registration_testing

    Given user sends SSN number
    And user sends first name
    And user sends last name
    Then close the browser

  Scenario: TC_02 user_registration_ssn_fail

    Given user does not send SSN number
    And user sends first name
    And user sends last name
    Then user should see the SNN-error message
    Then close the browser

  Scenario: TC_03 user_registration_firstname_fail

    Given user sends SSN number
    And user does not send first name
    And user sends last name
    Then user should see the FirstName error message
    Then close the browser

  Scenario: TC_04 user_registration_lastname_fail
    Given user sends SSN number
    And user sends first name
    And user does not send last name
    Then user should see the LastName error message
    Then close the browser

    @us_02
  Scenario: TC_xx
    Given user sends SSN number
    And user sends first name
    And user sends last name
    And user sends an username
    And user sends a valid email
    And user sends a valid password
    And user sends a valid confirm password
    And user clicks on the register button
    Then user should see the registration success message
    Then close the browser


  @invalid_ssn
  Scenario Outline: TC_05 user_registration_invalid_ssn_fail

    When user sends invalid SSN number as "<SSN>"
    And user sends first name
    And user sends last name
    Then user should see the SNN-invalid message
    Then close the browser

    Examples: invalid_SSN
      | SSN             |
      | 654             |
      | 654545440       |
      | 65454-5440      |
      | 654-54-5440-    |
      | 654-54-5440-000 |
