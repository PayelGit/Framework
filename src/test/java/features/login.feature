Feature: Validate login functionality


  Scenario Outline:
    Given user is in login page
    When user enters "<username>" and "<password>"
    Then user verifies "<url>" and "<status>"

    Examples:
    |username               | password  | url                                                     |status   |
    |9thstage@gonetor.com   | Admin@123 | https://ralvie.minervaiotstaging.com/select-organization|         |
    |9thstage@gonetor.com   |           | https://ralvie.minervaiotstaging.com/                   |required |
    |                       | Admin@123 | https://ralvie.minervaiotstaging.com/                   |required |
    |9thstage@gonetor.com   | Admin@1234| https://ralvie.minervaiotstaging.com                    |incorrect|
    |9thstage@gonetor.in    | Admin@123 | https://ralvie.minervaiotstaging.com/                   |incorrect|
    |                       |           | https://ralvie.minervaiotstaging.com/                   |required |