# Selenium Java Automation Tasks

# Description:
This repository is created to upload Selenium Automation Tasks using Java.

# Task 01 Description:
- Go to "https://www.amazon.in/".

- Search for mobiles in the search Box.

- Display First 5 Mobile Product Titles in the search results page.

# Task 02 Description:
- Go to "https://www.amazon.in/".

- Search for iphone in the search Box.

- Display IPhone products which contains 128GB in the search results page.

# Task 03 Description:
- Go to "https://www.news.google.com/".

- Click on "India" Tab.

- Display News of first 5 sections.

- Click on "World" Tab.

- Display News of first 5 sections.

# Task 04 Description:
- Go to "https://jqueryui.com/datepicker/".

- Print current month WeekEnd Dates.

- Print the Current Date in format DD-MMMMM-YYYY.

# Task 05 Description:
- Go to "https://www.wikipedia.org/".

- Search for "Apple Inc.".

- Print the founders list.

# Task 06 Description:
- Go to "https://www.flipkart.com/".

- Search for "Google Pixel 7a".

- Count Total Products and Display the count.

- Sort by Popularity.

- Add Product to Cart.

- Calculate Total Amount calculated using Java Code and verify the Total Amount using Assert statements.

# Task 07 Description:
- Go to "https://www.amazon.in/".

- Search for "Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Black, 12GB, 256GB Storage)".

- Add Product to Cart along with "Samsung Galaxy S24 Ultra 5G Clear Case, Transparent" product.

- Search for "Samsung Original 45W Power Adapter with Type C to C Cable, Compatible with Smartphone, Black".

- Add Product to Cart.

- Remove "Samsung Galaxy S23 Ultra 5G (Green, 12GB, 256GB Storage)" product from the Shopping Cart.

- Calculate Total Amount of the products in Shopping Cart and verify if the calculated Total Amount using Assert statements.

# Task 08 Description:
- Go to "https://www.google.com/".

- Search for "Crucial 4GB DDR4 RAM".

- Open "Crucial 4GB DDR4 RAM" on the Official Website of Crucial from Google Search Results.

- Store Product Specifications of The RAM such as RAM Capacity, RAM Model Number in a variable.

- Go to "https://www.google.com/". 

- Search for "WD SSD 1TB SN350".

- Open "WD SSD 1TB SN350" on the Official Website of Western Digital from Google Search Results.

- Store Product Specifications of The RAM such as SSD Capacity, SSD Model Number in a variable.

- Go to "Amazon.in"

- Search for "Crucial 4GB DDR4 RAM" in Amazon search.

- Verify if the Product Specifications for the product in Amazon == Product Specifications for the same product at Crucial Official site.

- Add the Product to Cart.

- Search for "WD 1TB SSD SN350" in Amazon search.

- Verify if the Product Specifications for the product in Amazon == Product Specifications for the same product at WD Official site.

- Add the Product to Cart.

- Verify the cart Contents using Assert Statements.

# Task 09 Description:
- Go to "https://www.cricbuzz.com/".

- Click on Live Scores.

- Click on Score Card of the First Section.

- Display Match Title.

- Display the list of Cricket Players (Batters) and 6s.

- Assert the following statements

1. If the match info text is empty or not.

2. If both batter and sixer have equal sizes.

3. If Batter size index is empty or not.

4. If Sixer size index is empty or not.

5. If Sixer value have negative integers. (for Example -2,-1,-3)


# Note on This Selenium Java Automation Tasks
1. Added TestNG
2. Implemented Assert statements
3. Implemented WebDriverWait (explicit waits).

## Required Software to Install:
```
# java version  17.0.12
java --version
```
```
# git version 2.43.0
git --version
```
```
# gradle version 8.11
gradle --version
```
```
# vscode 1.101.2
code --version
```
## Required Dependency to run:
```
# WebDriverManager
# Selenium
# TestNG
```
## Instructions to Run the Code:
```
# to build the project
gradle build
```
```
# to run the project
gradle run
```
```
# to test the project
gradle test
```