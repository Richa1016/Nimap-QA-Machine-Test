# Nimap Infotech - QA Technical Assessment (FieldForceConnect)

This repository contains the complete Quality Assurance assessment submission for **FieldForceConnect**, including UI Automation Framework, API Testing Suite, and Manual Quality Assurance documentation.

---

## 1. Automation Testing Framework
- **Tech Stack**: Java 21, Selenium WebDriver 4.28.1, TestNG, Maven
- **Design Pattern**: Page Object Model (POM)
- **Features Implemented**:
  - TestNG `@DataProvider` parameterization (Valid & Invalid Login scenarios).
  - Explicit & dynamic synchronization waits handling slow network page hydration.
  - End-to-end automated flows covering:
    1. `LoginTest`: Verifying valid credentials redirection and invalid inputs blocking.
    2. `PunchInTest`: Triggering attendance punch actions and validating system responses.
    3. `AddCustomerTest`: Automated form entry and lead creation pipelines.
- **Execution Command**:
  ```bash
  mvn clean test
