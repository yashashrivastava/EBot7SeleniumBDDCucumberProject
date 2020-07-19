Feature: Search quotes

Scenario: Verifying Search functionality
Given user is already on e-bot7 Home Page
When enter value in search bar and hit enter
  Then verify that list of filtered matches is displayed
  And close the Browser