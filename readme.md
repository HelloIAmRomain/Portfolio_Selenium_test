# Selenium WebDriver Java Project

This is a simple Java project using Selenium WebDriver to automate web interactions and capture screenshots of specific elements on a website. This project demonstrates how to set up Selenium, navigate web pages, interact with elements, and capture screenshots.

## Prerequisites

Before running the project, ensure you have the following prerequisites installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) version 8 or higher
- [Apache Maven](https://maven.apache.org/download.cgi) for managing project dependencies
- [ChromeDriver](https://sites.google.com/chromium.org/driver/) (if using Chrome browser)

## Getting Started

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/selenium-webdriver-java-project.git
    ```
   
2. Build the project using Maven:

   ```bash
   mvn clean install
   ```
   
3. Run the project using Maven:

   ```bash
    mvn exec:java -Dexec.mainClass="com.seleniumtest.PortfolioSeleniumTest"
    ```
   
The project will run and screenshots will be saved to the `Screenshots` directory.


## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.