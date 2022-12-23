Feature: Test the Cat Api response

  Scenario Outline: Verify the Cat scenario
    Given i have the base setup to call the cate api
    When i call the cat api
    Then i Validate the status code <statusCode>

    Examples:
      | statusCode |  |
      |
