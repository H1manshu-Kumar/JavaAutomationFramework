# Java Automation Framework

This Java-based Test Automation Framework leverages Selenium WebDriver and TestNG to facilitate efficient and scalable automated testing for web applications. Designed with a focus on modularity and ease of use, it integrates seamlessly with CI/CD pipelines and supports cross-browser testing.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [CI/CD Integration](#cicd-integration)
- [Folder Structure](#folder-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Cross-Browser Testing**: Supports multiple browsers including Chrome, Firefox, and Edge.
- **Parallel Test Execution**: Utilizes TestNG for running tests in parallel, reducing execution time.
- **Data-Driven Testing**: Reads test data from Excel and JSON files to drive test cases.
- **Page Object Model (POM)**: Implements POM design pattern for maintainable and reusable code.
- **Comprehensive Reporting**: Generates detailed HTML reports with ExtentReports, including screenshots and logs.
- **CI/CD Integration**: Easily integrates with Jenkins and GitHub Actions for continuous testing.
- **Logging and Debugging**: Incorporates Log4j2 for logging and captures screenshots on test failures.

## Prerequisites

Before setting up the framework, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 11 or higher.
- **Apache Maven**: For dependency management and build automation.
- **Preferred IDE**: Such as IntelliJ IDEA or Eclipse.
- **Git**: For version control.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/H1manshu-Kumar/JavaAutomationFramework.git
   cd JavaAutomationFramework