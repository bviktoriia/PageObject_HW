Feature: Test scenario for Compute Engine form model

  Scenario: Fill out the form

    Given User is on "Home Page"

    When User enters searchEnter as "Google Cloud Platform Pricing Calculator" into the search field on "Home Page"

    And User is navigated to the "Results Page" and select the needed result

    And User is navigate to the "Calculator Page" and select Compute Engine form

    And User is on "Compute Engine Form Model" and fills value as "4" in Number Of Instances field

    And User is on "Compute Engine Form Model" fills value as "" in fill What For field

    And User is on "Compute Engine Form Model" fills value as "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)" in Operating System Software field

    And User is on "Compute Engine Form Model" fills value as "Regular" in Provisioning Model field

    And User is on "Compute Engine Form Model" fills value as "General purpose" in Machine Family field

    And User is on "Compute Engine Form Model" fills value as "N1" in Series field

    And User is on "Compute Engine Form Model" fills value as "n1-standard-8 (vCPUs: 8, RAM: 30GB)" in Machine Type field

    And User is on "Compute Engine Form Model" select option in Add GPUs field

    And User is on "Compute Engine Form Model" fills value as "NVIDIA Tesla V100" in GPU Type field

    And User is on "Compute Engine Form Model" fills value as 1 in Number Of GPUs field

    And User is on "Compute Engine Form Model" fills value as "2x375 GB" in Local SSD field

    And User is on "Compute Engine Form Model" fills value as "Frankfurt (europe-west3)" in Datacenter Location field

    And User is on "Compute Engine Form Model" fills value as "1 Year" in Committed Usage field

    And User is on "Compute Engine Form Model" clicks on Add To Estimate button

    And User is on "Estimate Module" gets actual price of the selected Compute Engine

    And User is on "Estimate Module" clicks on Send To Email button

    Then User from "Estimate Module" opens Email Generating Page

    And User from "Email Generating Page" opens the https://yopmail.com/en/ page

    And User from "Email Generating Page" generates random email

    Then User from "Email Generating Page" navigates to Inbox Page

    And User from "Inbox Page" checks the price of the selected Compute Engine in the new email

    And User checks that the emailed matches the result in the calculator





