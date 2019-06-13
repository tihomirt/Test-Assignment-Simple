# Test-Assignment-Simple
Test assignment to showcase the usage of Maven, JUnit5, Webdriver with Java8+

## Running instructions:
Make sure java8 and maven are installed properly

Download the code

From the root directory of the project - where the pom.xml exists - run the command:

mvn clean test

## Project overview:
The project uses Selenium Webdriver 3, JUnit 5.

### Build tool:
Maven with surefire

### Additional Libraries:
WebDriverManager (https://github.com/bonigarcia/webdrivermanager) - chosen this webdriver manager library to make the intial configuations, maintenance and running easier. 
Logback - for logging basic actions

### There are several groups of classes in the projects:

1. Test Arhcitecture - /src/main/java/com/qa/testbase
Here are all the classes which are responsible for driver creation, and contains extension and initial configuration.

2. Wait package - /src/main/java/com/qa/wait
Wait utilities - Since webdriver 3 these are almost just wrapper classes to make the test cases easier to read.

3. PageObjects and sections - /src/main/java/com/qa/pageobjects
Pageobjects are basicaly mapped webpages into java objects. They make the code maintenance easier and resuable. 

4. Test cases and suites - src/test/java/com/example/qa
The acual test code and test suites are placed here

### Coding style:
Used the Eclipse checkstyle plugin to enforce the same coding style in the whole project.

