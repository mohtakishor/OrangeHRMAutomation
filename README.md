# OrangeHRM Automation
#Project DescriptionThis project is based upon the web application of OrangeHRM 
where a user can create his candidate profile and update the resume 
and also the user is able to download the same resume which has been uploaded by the user.

#Tech Stacks

The following project is related to testing 2 scenarios and validating the status code against the application
status which is done by using the following tech stacks.
Prerequisites for running the following test cases are:-
1-Java version: 1.8
2-Maven:-3.6.0
3-TestNG
For Automation purposes, I have used Selenium version 4.1.3 and for reporting purposes, I have used an allure report.


#FrameWork description
This framework consists of several implementations which are TestNG, POM, 
and Builders Design pattern.We have used TestNG to implement the runner for the tests, 
POM as a structure where we have implemented while having different classes for each page 
and Steps to be considered to keep the project more understandable and easy to modify, 
and then we have builder pattern which helps us in giving each method 
or step to be called as in a method chaining format.


#To run the test
1-you can directly from TestNG XML or from test\BasicTestCases
2-You can also run from the maven command :- mvn clean install -Did="Admin" -Dpassword="admin123"
