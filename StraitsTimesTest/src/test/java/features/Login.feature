Feature: LoginFeature
  This feature outlines the scenarios of Login functionality in Straits Times website

  Scenario Outline: Login Successful with valid user credentials
    Given Web browser is launched
    And Straits Times website homepage is loaded
    When I click on top-right section Login hyperlink
    And I attempt to login valid <loginId> and <password>
    Then I should see my <loginId> and logout hyperlink on top-right
    And I should see either image or video  present in main article
    When I click on the main article
    Then the main article page will be loaded
    And picture or video is present in the article

  Examples:
    |loginId      | password |
    |digitaltest1 | Password1|