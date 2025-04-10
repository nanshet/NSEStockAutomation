# NSEStockAutomation

This is a Selenium-based automation framework for validating stock details (price, 52-week high/low) on [NSE India](https://www.nseindia.com) using Java, TestNG, and Maven.

 Tech Stack

- Java
- Selenium WebDriver
- Maven
- TestNG
- Log4j
- ExtentReports
- WebDriverManager
- Page Object Model (POM)

1. **Clone the Repository**
   cmd
   git clone https://github.com/nanshet/NSEStockAutomation.git
   cd NSEStockAutomation
   
2  **Import as Maven project**

   Open in Eclipse or IntelliJ
   Choose Import > Maven > Existing Maven Project
   
3 **Install Dependencies Maven will automatically download required dependencies from pom.xml.**

4 **Configure Browsers**

  Make sure your system has Chrome, Firefox, or Edge installed.

  WebDriverManager will handle driver binaries automatically
  
5 **For execution just run the Testrunner file**

  Right-click Testrunner.java → Run As → Java Application