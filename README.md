# Cucumber Hybrid Framework (POM) for AutomationExercise

This project provides a **hybrid framework** using:
- Selenium WebDriver
- Cucumber BDD
- Page Object Model (POM)
- Maven
- JSON test data

Target site: `https://automationexercise.com/`

## 1. Framework Architecture

```text
src/main/java
  com.automationexercise.config      -> Config loader
  com.automationexercise.pages       -> Page Object classes
  com.automationexercise.utils       -> Driver & wait utilities

src/test/java
  com.automationexercise.hooks       -> Cucumber hooks
  com.automationexercise.runner      -> JUnit Cucumber runner
  com.automationexercise.stepdefinitions -> Step definition classes
  com.automationexercise.utils       -> Test data reader

src/test/resources
  features                           -> All cucumber feature files
  testdata                           -> JSON test data

docs
  manual-to-automation-mapping.md    -> Manual -> Automation mapping guide
```

## 2. Step-by-Step: Manual to Automation

### Step A: Prepare manual test cases
Create manual test cases with:
- Test case ID (TC-001, TC-002...)
- Preconditions
- Steps
- Expected results

### Step B: Convert manual cases to automation test cases
For each manual case, convert to:
- URL/navigation action
- Element locator-based actions
- Assertions for expected results

### Step C: Convert automation test cases to feature files
Write one scenario (or scenario outline) per business flow.
Use tags like `@manual-TC-001` for traceability.

### Step D: Convert feature steps to step definition methods
Bind each Gherkin step to Java step methods in:
- `HomeAndLoginSteps.java`
- `ProductSteps.java`

### Step E: Move UI operations to POM classes
Keep locators + operations inside page objects:
- `HomePage`
- `LoginPage`
- `ProductsPage`

## 3. Eclipse Setup Script/Flow

### Option 1: Import as Maven project in Eclipse
1. Open Eclipse
2. `File -> Import -> Maven -> Existing Maven Projects`
3. Select project root (`automationexercise-cucumber-hybrid-framework`)
4. Click `Finish`
5. Right click project -> `Maven -> Update Project`

### Option 2: Use included helper script then import
Run:
```bash
bash scripts/setup-eclipse.sh
```
This command:
- Validates Maven is available
- Generates Eclipse metadata (`.project`, `.classpath`) via Maven Eclipse plugin

After that import as **Existing Projects into Workspace**.

## 4. Run Tests

### Run all features
```bash
mvn clean test
```

### Run by tag
```bash
mvn test -Dcucumber.filter.tags="@smoke"
mvn test -Dcucumber.filter.tags="@manual-TC-003"
```

## 5. Key Files
- `pom.xml` -> dependency and plugin configuration
- `src/test/resources/features/*.feature` -> cucumber scenarios
- `src/test/java/com/automationexercise/stepdefinitions/*.java` -> step bindings
- `src/main/java/com/automationexercise/pages/*.java` -> POM page classes
- `docs/manual-to-automation-mapping.md` -> detailed traceability
