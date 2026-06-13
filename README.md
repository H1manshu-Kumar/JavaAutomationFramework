<div align="center">

<h1>⚡ Java Automation Framework</h1>

<p>
  <strong>A production-grade, end-to-end test automation framework built with Java - covering UI, API, and BDD testing with rich reporting and CI/CD support.</strong>
</p>

<!-- Badges -->
<p>
  <img src="https://img.shields.io/badge/Java-1.8+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Selenium-4.23.1-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium"/>
  <img src="https://img.shields.io/badge/TestNG-7.4.0-FF6C37?style=for-the-badge&logo=testng&logoColor=white" alt="TestNG"/>
  <img src="https://img.shields.io/badge/Cucumber-7.18-23D96C?style=for-the-badge&logo=cucumber&logoColor=white" alt="Cucumber"/>
  <img src="https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
  <img src="https://img.shields.io/badge/ExtentReports-5.1.2-0078D7?style=for-the-badge" alt="ExtentReports"/>
</p>

<p>
  <img src="https://img.shields.io/github/stars/H1manshu-Kumar/JavaAutomationFramework?style=social" alt="Stars"/>
  <img src="https://img.shields.io/github/forks/H1manshu-Kumar/JavaAutomationFramework?style=social" alt="Forks"/>
  <img src="https://img.shields.io/github/license/H1manshu-Kumar/JavaAutomationFramework" alt="License"/>
  <img src="https://img.shields.io/badge/PRs-Welcome-brightgreen?style=flat-square" alt="PRs Welcome"/>
</p>

<p>
  <a href="#-features">Features</a> •
  <a href="#-tech-stack">Tech Stack</a> •
  <a href="#-project-structure">Project Structure</a> •
  <a href="#-getting-started">Getting Started</a> •
  <a href="#-running-tests">Running Tests</a> •
  <a href="#-test-reporting">Reports</a> •
  <a href="#-cicd-integration">CI/CD</a> •
  <a href="#-contributing">Contributing</a>
</p>

</div>

---

## 📖 Overview

The **Java Automation Framework** is a robust, scalable, and modular end-to-end test automation solution designed for modern software teams. It unifies **UI testing** (Selenium WebDriver), **BDD-style test authoring** (Cucumber), and **structured test orchestration** (TestNG) under a single Maven-based project — giving your QA pipeline consistency, speed, and clear reporting from day one.

Whether you're automating purchase order workflows, validating error-handling scenarios, or running full regression suites, this framework has you covered with a clean architecture and plug-and-play CI/CD integration.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🌐 **UI Automation** | Selenium WebDriver 4.x for cross-browser web testing |
| 🥒 **BDD Testing** | Cucumber 7 with Gherkin syntax for human-readable test scenarios |
| 🧪 **TestNG Integration** | Parallel execution, grouping, annotations, and suite management |
| 📊 **Rich Reporting** | ExtentReports 5 with interactive HTML dashboards |
| 📦 **Maven Profiles** | Separate profiles for Regression, PurchaseOrder & ErrorValidation suites |
| 🔄 **CI/CD Ready** | Works out-of-the-box with Jenkins, GitHub Actions, and Azure Pipelines |
| 🧩 **Modular Design** | Clean separation of framework code, test cases, and configurations |
| 📄 **JSON Support** | Jackson Databind for data-driven testing with JSON test data |

---

## 🏗 Tech Stack

<table>
  <tr>
    <th>Category</th>
    <th>Technology</th>
    <th>Version</th>
    <th>Purpose</th>
  </tr>
  <tr>
    <td>Language</td>
    <td>Java</td>
    <td>1.8+</td>
    <td>Core programming language</td>
  </tr>
  <tr>
    <td>UI Testing</td>
    <td>Selenium WebDriver</td>
    <td>4.23.1</td>
    <td>Browser automation</td>
  </tr>
  <tr>
    <td>Test Framework</td>
    <td>TestNG</td>
    <td>7.4.0</td>
    <td>Test execution & parallelism</td>
  </tr>
  <tr>
    <td>BDD</td>
    <td>Cucumber</td>
    <td>7.18.1</td>
    <td>Gherkin-based test authoring</td>
  </tr>
  <tr>
    <td>Build Tool</td>
    <td>Maven</td>
    <td>3.8+</td>
    <td>Dependency management & builds</td>
  </tr>
  <tr>
    <td>Reporting</td>
    <td>ExtentReports</td>
    <td>5.1.2</td>
    <td>Interactive HTML test reports</td>
  </tr>
  <tr>
    <td>Data Handling</td>
    <td>Jackson Databind</td>
    <td>2.17.2</td>
    <td>JSON test data parsing</td>
  </tr>
  <tr>
    <td>Utilities</td>
    <td>Commons IO</td>
    <td>2.16.1</td>
    <td>File & I/O operations</td>
  </tr>
</table>

---

## 📁 Project Structure

```
JavaAutomationFramework/
│
├── src/
│   ├── main/
│   │   └── java/                  # Framework utilities & base classes
│   │       ├── base/              # Base test setup & teardown
│   │       ├── pages/             # Page Object Model (POM) classes
│   │       ├── utils/             # Helper utilities (config, reporting)
│   │       └── constants/         # Global constants & enums
│   │
│   └── test/
│       └── java/                  # Test cases & step definitions
│           ├── tests/             # TestNG test classes
│           ├── stepdefs/          # Cucumber step definitions
│           └── runners/           # Cucumber test runners
│
├── testNG/
│   ├── testng.xml                 # Default / Regression suite
│   ├── Purchase_testng3.xml       # Purchase Order suite
│   └── ErrorHandling_testng2.xml  # Error Validation suite
│
├── reports/                       # Generated ExtentReports HTML output
├── Screenshots/                   # Test failure screenshots
├── pom.xml                        # Maven build & dependency config
└── README.md                      # Project documentation readme
```

---

## ⚙️ Prerequisites

Before running the framework, ensure the following are installed on your system:

| Requirement | Version | Download |
|---|---|---|
| Java JDK | 8 or higher | [Download](https://adoptium.net/) |
| Apache Maven | 3.6+ | [Download](https://maven.apache.org/download.cgi) |
| Git | Latest | [Download](https://git-scm.com/) |
| A modern browser | Chrome / Firefox | — |

> **Note:** WebDriver binaries are managed automatically via Selenium Manager (included in Selenium 4.x) — no manual driver setup needed!

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/H1manshu-Kumar/JavaAutomationFramework.git
cd JavaAutomationFramework
```

### 2. Install Dependencies

```bash
mvn clean install -DskipTests
```

### 3. Verify Setup

```bash
mvn --version
java -version
```

---

## ▶️ Running Tests

The framework supports multiple Maven profiles for targeted test execution.

### Run the Full Regression Suite (default)

```bash
mvn test
```

### Run Specific Profiles

```bash
# Run Regression tests
mvn test -P Regression

# Run Purchase Order workflow tests
mvn test -P PurchaseOrder

# Run Error Validation / Error Handling tests
mvn test -P ErrorValidation
```

### Run with Verbose Output

```bash
mvn test -P Regression -e -X
```

### Skip Tests During Build

```bash
mvn clean install -DskipTests
```

---

## 📊 Test Reporting

After each test run, **ExtentReports** automatically generates an interactive HTML report.

```
reports/
└── ExtentReport.html     ← Open this in your browser
```

Reports include:
- ✅ Test pass/fail status with timestamps
- 📸 Automatic screenshots on failure
- 📈 Suite-level summary charts
- 🔍 Step-by-step execution logs

---

## 🔄 CI/CD Integration

The framework is CI/CD-ready and can be plugged into any pipeline tool.

### GitHub Actions

Create `.github/workflows/test.yml`:

```yaml
name: Java Automation Tests

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'

      - name: Run Regression Suite
        run: mvn test -P Regression

      - name: Upload Test Reports
        uses: actions/upload-artifact@v3
        with:
          name: extent-reports
          path: reports/
```

### Jenkins Pipeline

```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { git 'https://github.com/H1manshu-Kumar/JavaAutomationFramework.git' }
        }
        stage('Run Tests') {
            steps { sh 'mvn test -P Regression' }
        }
        stage('Publish Report') {
            steps { publishHTML(target: [reportDir: 'reports', reportFiles: 'ExtentReport.html']) }
        }
    }
}
```

---

## 🧩 Key Design Patterns

- **Page Object Model (POM)** — UI elements encapsulated in dedicated page classes for reusability and maintainability
- **Data-Driven Testing** — JSON-based test data via Jackson Databind keeps test logic and data separate
- **BDD with Cucumber** — Gherkin feature files enable collaboration between QA, Dev, and Business stakeholders
- **Configurable Suites** — Multiple TestNG XML files for running targeted subsets of tests without code changes

---

## 🤝 Contributing

Contributions are welcome and appreciated! Here's how to get involved:

1. **Fork** the repository
2. **Create** your feature branch: `git checkout -b feature/amazing-feature`
3. **Commit** your changes: `git commit -m 'Add amazing feature'`
4. **Push** to the branch: `git push origin feature/amazing-feature`
5. **Open** a Pull Request

Please follow the existing code style, add meaningful commit messages, and include test coverage for new features.

---

## 📬 Contact & Support

- **Author**: [H1manshu-Kumar](https://github.com/H1manshu-Kumar)
- **Repository**: [JavaAutomationFramework](https://github.com/H1manshu-Kumar/JavaAutomationFramework)
- **Issues**: [Open an Issue](https://github.com/H1manshu-Kumar/JavaAutomationFramework/issues)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

<div align="center">

**If this framework helped you, please consider giving it a ⭐ on GitHub!**

Made with ☕ and passion for quality engineering.

</div>
