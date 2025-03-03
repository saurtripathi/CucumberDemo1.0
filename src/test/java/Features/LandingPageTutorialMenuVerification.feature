Feature: Submenu links verification on landing page
  Scenario: ML & Data Science submenu under Tutorials menu contains link for Python Tutorial
    Given User launches the landing page
    When User navigates to Tutorial -> ML & Data Science submenu
    Then link for Python Tutorial exists