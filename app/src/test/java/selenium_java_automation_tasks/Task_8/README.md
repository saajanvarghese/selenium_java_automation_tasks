# Selenium Java Automation Tasks

# Task 08 Description: flipkart Task - Amazon Product Calculate Total Amount
# Task Steps

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

# Note on This Selenium Java Automation Task
1. Added TestNG
2. Implemented Assert statements
3. Implemented WebDriverWait (explicit waits).

## Required Software to Install:
```
# java version 17
java --version
```
```
# git version 2.43.0
git --version
```
```
# gradle version 8.6
gradle --version
```
```
# vscode 1.95.3
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
# to clean the project
gradle clean
```
```
# to test the project
gradle test
```