Feature: Search feature verification
  Scenario Outline: Search feature is working on landing page
  Given User opens the landing page
  When User clicks the search icon and enters the "<searchText>" hit enter button
  Then Search list appears and entered "<appearedText>" appears in the list
    Examples:
                |     searchText        |         appearedText            |
                | Project Management    | Project Management Fundamentals |
                | Algorithm Tutorials   | Algorithms Tutorial             |
                | Java Script           | Java Tutorial                   |


