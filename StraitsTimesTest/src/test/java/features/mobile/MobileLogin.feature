Feature: LoginFeature
  This feature outlines the scenarios of Login functionality in Straits Times website

  Scenario Outline: Login Successful with valid user credentials and app quick test
    Given ST app is launched
    And I tap on drawer button to open drawer
    Then I tap on 'LOGIN' button
    When Login screen loaded
    Then I entered <loginId> and <password>
    And I tap on 'Continue' button
    When I tap on drawer button
    Then I should see my <loginId> and 'LOGOUT' button

   #Note: I had submitted the Google code challenge form and not able to view the mobile test scenario anymore. Hence I trying to relate the test scenario back at my best
    And I tap on 'ST NOW' Tab
    And I scroll all the way down to the bottom
    Then I should see the 'LOAD MORE' button

  Examples:
    |loginId      | password |
    |digitaltest1 | Password1|