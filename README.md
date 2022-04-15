# TurnTechAssignment

#Project Description
This project is based upon web-application of orangeHRm where a user can create his candidate profile and update the resume and also user is able to download the same resume which has been uploaded by user.


#Tech Stacks
The following project related to testing 2 scenario's and validating the status code against the application status which is done by using following tech stacks.

Prerequisite for running the following test cases are :-
1-Java version : 1.8
2-Maven:-3.6.0
3-testNg

For Automation purpose I have used Selenium version 4.1.3 and for reporting purpose i have allure report .

#FrameWork description

This framework consist of several implementations which are testNg, POM, Builders Design pattern.
We have use testNg to implement the runner for the tests , POM as structure where we have implemented while having different different classes for each Pages and Steps to be considered to keep the project more understandable and easy to modify , and then we have builder pattern which helps us in giving each method or step to be call as in a method chaneing format.

#To run the test

1-you can directly from testNg xml or from test\BasicTestCases
2-You can also run from the maven command mvn clean install -Did="Admin" -Dpassword="admin123"

