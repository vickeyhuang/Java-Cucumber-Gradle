Feature: Gradle-Cucumber integration

  Scenario: basic test
    Given "I" use Cucumber Main class to run tests
    Then  Gradle should report "good job"

   @wip
  Scenario: results are shown
    Given the page is open "http://www.baidu.com"
    When I search for "Cucumber"
    Then a browser title should contains "Cucumber"