# EcommerceTestAutomation
Application used: [https://naveenautomationlabs.com/opencart/](url)

A Java Selenium TestNG framework is a robust automation framework that leverages Java programming language, Selenium WebDriver for web interactions, and TestNG for efficient test organization and execution. It provides a structured approach to writing and executing automated test scripts.

# Steps to configure and run the automated test scripts.
1. Import the Project:
a) Open Eclipse IDE.

Go to File > Open Projects from File System...

Browse and select the project folder (containing src, test output, etc.).

Click Finish.
b) Download the latest version of Java Selenium binding from [https://www.selenium.dev/downloads/](url)

c) Download TestNg Jar file from [https://mvnrepository.com/artifact/org.testng/testng/6.9.10](url)

2. Configure Java Build Path:
Right-click on the project in Eclipse.

Select Properties.

Navigate to Java Build Path.

Click on the Libraries tab.

Add all Selenium and TestNg jar files to Class-Path, Apply & Close.

3. Install TestNG Plugin:
Go to Help > Eclipse Marketplace.

Search for "TestNG".

Install the TestNG Eclipse plugin.

4. Set Up ChromeDriver System Property:
Open the BaseClass.java file.


5. Run TestNG Tests:
Right-click on the testng.xml file.

Select Run As > TestNG Suite.

6. View TestNG Reports:
After test execution, open the Test Reports folder in the project directory.

Open the HTML reports (emailable-report.html and index.html) in a web browser.

7. Configure Screenshot Storage:
Open the Add_And_Remove_Product_From_Wishlist.java file.

Modify the SCREENSHOT_FOLDER constant to the desired folder name for storing screenshots.

Ensure the specified folder exists in the project directory.

8. Re-run Tests:
Repeat Step 5 (Run TestNG Tests).






