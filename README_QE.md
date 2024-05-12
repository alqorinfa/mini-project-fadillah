# Mini Project Fadillah

## About Project
This repository hosts the codebase for a mini Quality Engineering (QE) project aimed at testing web applications, RESTful APIs, and mobile applications. The project is developed to ensure the quality and reliability of software products through a structured and comprehensive testing regimen.

## Test Case Document
- API: https://docs.google.com/spreadsheets/d/14jPXglZ3d8fwDOpTqhwGptSwiiM9Pqxx/edit?usp=drive_link&ouid=111197493947437779762&rtpof=true&sd=true
- Web: https://docs.google.com/spreadsheets/d/1rT61QMC8Hp3xE28PbI-e5iCnSOrp-O3j/edit?usp=drive_link&ouid=111197493947437779762&rtpof=true&sd=true
- Mobile: https://docs.google.com/spreadsheets/d/13sEfaAgKOUZm8qBS7MtOEfihh6Tf_TCC/edit?usp=drive_link&ouid=111197493947437779762&rtpof=true&sd=true

## Tech Stacks
- API Testing - Postman, REST Assured
- Web Testing - Selenium Webdriver 
- Mobile Testing - Appium, android studio
- BDD Frameworks - Cucumber Test Suite, Serenity BDD

## Test Results
- API Testing: 94% success rate with 29 test cases passing and 2 test cases failing. Failures occurred in the "register (invalid email)" and "create order (no quantity)" scenarios.
- Web Testing: 87% success rate with 10 test cases passing and 2 test cases failing. Failures occurred in the "create book (invalid year)" and "edit book (invalid year)" scenarios.
- Mobile Testing: 100% success rate with a total of 13 test cases passing.

## Setup
To use this project locally, follow these steps:
1. **Clone the Repository**: 
   ```bash
   git clone https://github.com/alqorinfa/mini-project-fadillah
   ```
2. **Navigate to the Project Directory**:
   ```bash
   cd your_project
   ```
3. **Install Dependencies**:
   - For web application testing, ensure you have the necessary testing frameworks and libraries installed. 
   - For RESTful API testing, install tools such as Postman, along with any additional libraries needed for scripting or assertions.
   - For mobile application testing, set up your preferred mobile testing framework like Appium, along with necessary drivers and dependencies.
4. **Configure Test Environments**:
   - Set up configurations for different test environments such as development, staging, and production. Ensure the necessary environment variables are set.
5. **Run Tests**:
   - Execute the test suites for web applications, RESTful APIs, and mobile applications using the appropriate commands provided by the testing frameworks.
6. **Review Test Results**:
   - After the tests have completed, review the test results and logs to identify any issues or failures.
7. **Contribute**:
   - If you encounter any issues or have suggestions for improvements, feel free to contribute by opening issues or pull requests on the GitHub repository.

By following these steps, you can set up and use this project locally for testing web applications, RESTful APIs, and mobile applications.