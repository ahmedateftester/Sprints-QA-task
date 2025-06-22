# Sprints QA Automation Project

This project contains automated test cases using **Java + Selenium + TestNG + Maven** to validate core functionalities and security of the demo Magento website.

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/ahmedateftester/Sprints-QA-task.git
cd Sprints-QA-task

2. Install Dependencies
Install Java JDK (version 17 or higher)

Install Maven and ensure it’s in your system PATH

Recommended IDE: VS Code or IntelliJ IDEA

3. ChromeDriver
Download the right version from ChromeDriver Downloads

Place chromedriver.exe in your system PATH or project root

3. Execution Instructions
Run All Tests
			mvn test
			
Run a Specific Test
			mvn -Dtest=CheckoutTest test
			
📁 Project Structure
src/
└── test/
    └── java/
        ├── pages/    # Page Object Model classes
        └── tests/    # TestNG test classes
		
		
4. Test Coverage
Add to Cart flow
Guest Checkout
Search field validation
Basic XSS & SQL injection security validation

5.Notes
Use Thread.sleep() carefully; prefer WebDriverWait
You can integrate Allure for advanced reporting
Make sure you're online when accessing Magento demo site



