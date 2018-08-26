# Web Automation
Project describes UI automation of ebay website for searching and adding product to cart. Tests can be executed parralley 
on multiple browsers. Tests are developed in TESTNG framework using Java, Selenium webdriver. 

## Getting Started
1. Download and configure JAVA JRE/JDK for development environment
2. Configure Eclipse IDE
3. Clone above Github project in development environment
4. Import above project in Eclipse and configure as a Maven project

### Important folders and files

webAuto/src/dataObjects                  : Objects are populated with required information after succesful search and addition to cart
webAuto/src/interfaces/Constants.java    : Contains all variables/strings required to run tests
webAuto/src/testListener                 : TestLister to monitor test cases execution status (WIP)
webAuto/src/tests/TestSuite.java         : Test case file
webAuto/src/tests/BrowserFactory.java    : Webdriver instance depending upon browser selection
webAuto/src/webPage/HomePage.java        : Webpage specific operations
webAuto/pom.xml                          : POM file manage project dependecies
webAuto/multiBrowsers.xml                : file can be updated to run tests parallely in multiple browsers

### Test case descrption

Test-1 : Search a product in website and validate if found                           
Test-2 : Add product to cart and validate the cart

## Test execution

1. Launch Eclipse software
2. Import above project
3. Open webAuto/multiBrowsers.xml 
4. Right click on it and Run as TestNG Suite
5. TestNG console provides test result






