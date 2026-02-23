# Manual Test Cases to Automation Traceability (AutomationExercise)

This document shows a **step-by-step conversion flow**:
1. Manual test case
2. Automation test case (implementation-level)
3. Cucumber feature scenario
4. Step definition binding
5. POM method mapping

---

## TC-001: Home page loads successfully

### 1) Manual Test Case
- **Precondition**: Browser is launched.
- **Steps**:
  1. Open `https://automationexercise.com/`
  2. Observe home page main banner/slider.
- **Expected**: Home banner is visible.

### 2) Automation Test Case
- Launch base URL.
- Verify home banner locator `#slider` is displayed.

### 3) Feature Mapping
- **File**: `home_and_login.feature`
- **Scenario**: `Validate home page is loaded`
- **Tag**: `@manual-TC-001`

### 4) Step Definition Mapping
- `Given user launches Automation Exercise home page`
- `Then home page banner should be visible`

### 5) POM Mapping
- `HomePage.open(String url)`
- `HomePage.isHomeVisible()`

---

## TC-002: Login with invalid credentials

### 1) Manual Test Case
- **Precondition**: User is on home page.
- **Steps**:
  1. Click Signup / Login
  2. Enter invalid email/password
  3. Click Login
- **Expected**: Error `Your email or password is incorrect!`

### 2) Automation Test Case
- Navigate to Login page from home.
- Fetch invalid credentials from JSON test data.
- Submit login and assert error text.

### 3) Feature Mapping
- **File**: `home_and_login.feature`
- **Scenario**: `Validate login with invalid credentials`
- **Tag**: `@manual-TC-002`

### 4) Step Definition Mapping
- `When user navigates to signup login page`
- `When user logs in with invalid credentials from "testdata/users.json"`
- `Then invalid login error should be displayed as "Your email or password is incorrect!"`

### 5) POM Mapping
- `HomePage.goToSignupLogin()`
- `LoginPage.login(String email, String password)`
- `LoginPage.loginError()`

---

## TC-003: Search product

### 1) Manual Test Case
- **Precondition**: User is on home page.
- **Steps**:
  1. Click Products.
  2. Confirm all products list loaded.
  3. Search a product (ex: Tshirt)
- **Expected**: Searched products section appears.

### 2) Automation Test Case
- Open products page and validate title label.
- Pass product keyword from Scenario Outline examples.
- Assert `SEARCHED PRODUCTS` heading.

### 3) Feature Mapping
- **File**: `products.feature`
- **Scenario Outline**: `Search a product from all products page`
- **Tag**: `@manual-TC-003`

### 4) Step Definition Mapping
- `When user navigates to products page`
- `When user searches for product "<productName>"`
- `Then searched products section should be visible`

### 5) POM Mapping
- `HomePage.goToProducts()`
- `ProductsPage.isAllProductsVisible()`
- `ProductsPage.search(String productName)`
- `ProductsPage.isSearchedProductsVisible()`
