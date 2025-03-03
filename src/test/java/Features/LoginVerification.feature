Feature: Login functionality of application
  Scenario Outline: Verification of login functionality
    Given Open the browser and launch the application
    When User enters "<username>" and "<password>" in the app
#    And click on the sign in button
    Then user log in to the application
    Examples:
            | username                        | password        |
            | tripathi.saurabh00@gmail.com  | sambaAfrica9 |