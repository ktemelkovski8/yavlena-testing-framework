# yavlena-testing-framework

# Test Environment Setup

## Prerequisites
- **Java Development Kit (JDK):** Ensure JDK 20 or higher is installed.
- **IDE:** Use an Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
- **Maven:** For managing project dependencies.

## Dependencies

Add the following dependencies to your `pom.xml` file:

```xml
<dependencies>
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.13.X</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.23.X</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.8.X</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>LATEST</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.X</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
```
## Setup Steps

### 1. Project Setup

**Create a New Maven Project:**
- In your IDE, create a new Maven project.
- Configure the project’s `pom.xml` with the dependencies listed above.

### 2. Browser Setup

**Install Browsers:**
- Ensure the required browsers (e.g., Chrome, Firefox) are installed.

**WebDriver Setup:**
- Use WebDriverManager for automatic management:

```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");
        driver.quit();
    }
}
```
### 3. Create Test Classes

Create test classes using TestNG annotations. Example:

```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testExample() {
        driver.get("https://www.example.com");
        // Add test logic here
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```
### 4. Configure TestNG

Create a `testng.xml` configuration file if needed for test suite configuration. Example `testng.xml`:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
    <test name="Test">
        <classes>
            <class name="com.example.SampleTest"/>
        </classes>
    </test>
</suite>
```
## Run Tests

Execute tests through your IDE or using Maven commands:

```sh
mvn test
```
## Reporting

**TestNG Reporting:** TestNG provides built-in reports. Check the `test-output` directory for reports.
