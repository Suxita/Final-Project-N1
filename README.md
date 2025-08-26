# Final-Project-N1 🏦

TBC Bank Test Automation Framework - Comprehensive end-to-end testing suite for banking application features including location services, card applications, and credit processing.

## 🛠️ Tech Stack
- **Java** – programming language
- **Selenide** – UI testing
- **TestNG** – testing framework
- **Maven** – build automation
- **ZXing** – QR code decoding
- **JavaFaker** – test data generation


##  Quick Start


### Installation & Setup
```bash
git clone <repository-url>

cd Final-Project-N1

mvn clean install

mvn test

mvn test -Dtest
```

### Configuration
- **Base URL:** Configured in `Consts.java`
- **Browser:** Chrome (default), Firefox (configurable)
- **Timeouts:** 10 seconds default
- **Retry Count:** 3 attempts for flaky tests

## 📋 Test Scenarios

### ️ Location & ATM Features
| Test ID | Scenario | 
|---------|----------|
| **SCRUM-T1** | Location Search Filter |
| **SCRUM-T9** | Location Filter Dropdown City Selection | 
| **SCRUM-T5** | ATM/Branch Tabs and Sub-tabs Filtering | 

###  Card Application Features
| Test ID | Scenario |
|---------|----------|
| **SCRUM-T6** | Unauthorized User Getting New Standard TBC Card |
| **SCRUM-T7** | "ერთგული" Card Application After Searching | 

###  Credit Features
| Test ID | Scenario |
|---------|----------|
| **SCRUM-T8** | Full Credit Application Flow Validation For Unauthorized User |

## 🔧 Utils

###  Retry Mechanism (from our elections)
- **Automatic Retry:** Failed tests retry up

```java
@Test(retryAnalyzer = RetryAnalyzer.class)
@RetryCount(count = 3)
public void flakyTest() {
    // Test implementation
}
```

###  QR Code Processing
- **Canvas Extraction:** Extracts QR codes from HTML5 canvas elements
- **ZXing Integration:** Decodes QR code content automatically
- **Error Handling:** Graceful handling of unreadable QR codes

###  Multi-Browser Support
- **Chrome:** Primary browser (maximized/mobile view)
- **Firefox:** Secondary browser support
- **Mobile Testing:** 375x669 resolution simulation

###  Test Data Management
- **Constants:** Centralized in `Consts.java`
- **JavaFaker:** Dynamic test data generation
- **Helper Utilities:** Common validation methods

##  Detailed Test Scenarios

### 1. **Location Search Filter [SCRUM-T1]**
<details>
<summary>Click to expand scenario details</summary>

**Objective:** Validate location search functionality on ATM/Branch map

**Flow:**
1. Navigate to ATM/Branch map page
2. Use search field to filter locations
3. Validate search results accuracy

**Known Issues:**
- Search field interaction can be flaky (retry mechanism enabled)
- Intermittent failures documented with screenshots

**Test Data:**
- `FILTER_WORD`: Predefined search term
- Map validation through pin collection count

</details>

### 2. **ATM/Branch Tabs and Sub-tabs [SCRUM-T5]**
<details>
<summary>Click to expand scenario details</summary>

**Objective:** Test filtering by category (ATM/Branch) and working hours (24/7, Open Now)

**Flow:**
1. Navigate to map page
2. Apply ATM category filter
3. Apply working hours filter (24/7)
4. Validate combined filter results

**Validations:**
- ATM-only results when ATM filter applied
- 24/7 locations when "Anytime" filter active
- Combined filters work without conflicts

</details>

### 3. **City Selection Dropdown [SCRUM-T9]**
<details>
<summary>Click to expand scenario details</summary>

**Objective:** Validate city-based location filtering

**Flow:**
1. Access location map
2. Open city dropdown
3. Select specific city
4. Verify filtered results for selected city

**Edge Cases:**
- Cities with no ATM/Branch locations
- Special characters in city names

</details>

### 4. **Standard TBC Card Application [SCRUM-T6]**
<details>
<summary>Click to expand scenario details</summary>

**Objective:** Test card application process for unauthorized users

**Flow:**
1. Navigate to cards section
2. Select standard TBC card
3. Complete application form
4. Validate application submission

**Requirements:**
- Form validation for required fields
- Proper redirection after submission

</details>

### 5. **"ერთგული" Card Application [SCRUM-T7]**
<details>
<summary>Click to expand scenario details</summary>

**Objective:** Test loyalty card application through search

**Flow:**
1. Use search functionality to find loyalty card
2. Navigate to card details
3. Complete application process
4. Verify successful submission

**Special Features:**
- Georgian language support
- Search-driven navigation

</details>

### 6. **Credit Application Flow [SCRUM-T8]**
<details>
<summary>Click to expand scenario details</summary>

**Objective:** Complete credit application with PMT calculation validation

**Flow:**
1. Navigate from loans to credit page
2. Input credit parameters
3. Validate PMT calculation accuracy
4. Submit credit application

**Mathematical Validation:**
- PMT formula: `P * (r * (1 + r)^n) / ((1 + r)^n - 1)`
- Tolerance: ±1.0 units for calculation verification
- Dynamic data extraction from UI elements

</details>

---
## Other

---
**Bugs found:**

![smth](bug.gif)
