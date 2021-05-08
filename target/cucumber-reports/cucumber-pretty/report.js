$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/login.feature");
formatter.feature({
  "line": 1,
  "name": "mercurytours Feature",
  "description": "",
  "id": "mercurytours-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Registeration Test Scenario",
  "description": "",
  "id": "mercurytours-feature;registeration-test-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "user is already on landing Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user clicks on registerlink",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user enters contact information \"\u003cfirstname\u003e\" and \"\u003clastname\u003e\" and \"\u003cphone\u003e\" and \"\u003cemail\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user enters mailing address information \"\u003caddress1\u003e\" and \"\u003ccity\u003e\" and \"\u003cstate\u003e\" and \"\u003cpostalcode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user enters user information \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" and \"\u003cconfirmpassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "mercurytours-feature;registeration-test-scenario;",
  "rows": [
    {
      "comments": [
        {
          "line": 12,
          "value": "# @source:C:/Users/krishna/eclipse-workspace1/Cucumber/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx/Sheet1"
        }
      ],
      "cells": [
        "firstname",
        "lastname",
        "phone",
        "email",
        "address1",
        "city",
        "state",
        "postalcode",
        "username",
        "password",
        "confirmpassword"
      ],
      "line": 13,
      "id": "mercurytours-feature;registeration-test-scenario;;1"
    },
    {
      "cells": [
        "krishna",
        "bandaru",
        "9874564123",
        "kri124@gmail.com",
        "3-49",
        "HYD",
        "TS",
        "87541",
        "Test123",
        "test@123",
        "test@123"
      ],
      "line": 14,
      "id": "mercurytours-feature;registeration-test-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Registeration Test Scenario",
  "description": "",
  "id": "mercurytours-feature;registeration-test-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "user is already on landing Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user clicks on registerlink",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user enters contact information \"krishna\" and \"bandaru\" and \"9874564123\" and \"kri124@gmail.com\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user enters mailing address information \"3-49\" and \"HYD\" and \"TS\" and \"87541\"",
  "matchedColumns": [
    4,
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user enters user information \"Test123\" and \"test@123\" and \"test@123\"",
  "matchedColumns": [
    8,
    9,
    10
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageTest.user_is_already_on_landing_Page()"
});
formatter.result({
  "duration": 3161364900,
  "status": "passed"
});
formatter.match({
  "location": "RegisterPageTest.user_clicks_on_registerlink()"
});
formatter.result({
  "duration": 48094700,
  "error_message": "java.lang.ClassCastException: class org.openqa.selenium.htmlunit.HtmlUnitDriver cannot be cast to class org.openqa.selenium.TakesScreenshot (org.openqa.selenium.htmlunit.HtmlUnitDriver and org.openqa.selenium.TakesScreenshot are in unnamed module of loader \u0027app\u0027)\r\n\tat com.qa.util.TestUtil.takeScreenShot(TestUtil.java:67)\r\n\tat stepDefinitions.RegisterPageTest.user_clicks_on_registerlink(RegisterPageTest.java:30)\r\n\tat ✽.When user clicks on registerlink(Features/login.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "krishna",
      "offset": 33
    },
    {
      "val": "bandaru",
      "offset": 47
    },
    {
      "val": "9874564123",
      "offset": 61
    },
    {
      "val": "kri124@gmail.com",
      "offset": 78
    }
  ],
  "location": "RegisterPageTest.user_enters_contact_information_and_and_and(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "3-49",
      "offset": 41
    },
    {
      "val": "HYD",
      "offset": 52
    },
    {
      "val": "TS",
      "offset": 62
    },
    {
      "val": "87541",
      "offset": 71
    }
  ],
  "location": "RegisterPageTest.user_enters_mailing_address_information_and_and_and_and(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Test123",
      "offset": 30
    },
    {
      "val": "test@123",
      "offset": 44
    },
    {
      "val": "test@123",
      "offset": 59
    }
  ],
  "location": "RegisterPageTest.user_enters_user_information_and_and(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RegisterPageTest.user_closes_the_browser()"
});
formatter.result({
  "status": "skipped"
});
});