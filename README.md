# Canteen Billing System

## 1. Project Title

Canteen Billing System

## 2. Overview

The Canteen Billing System is a simple Java command-line application for managing canteen menu items, creating customer orders, and calculating the final bill.

The project is designed as a small and easy-to-use CLI application using core Java concepts such as classes, objects, ArrayList, input validation, exception handling, file handling, and CSV storage.

## 3. Features

The system provides the following main features:

### Menu Item Management
- Add a new food item
- View available menu items
- Store item name, price, and available quantity
- Save menu data in a CSV file

### Order Management
- Select food items from the menu
- Enter the required quantity
- Add multiple items to an order
- View the current order
- Check available stock before adding an item

### Bill Calculation
- Calculate the subtotal for each ordered item
- Calculate the total bill
- Display the final bill clearly

### Validation and Error Handling
- Prevent empty item names
- Validate positive prices
- Validate positive quantities
- Validate menu choices
- Handle invalid numeric input
- Prevent ordering more items than available

## 4. Technologies and Tools

- Java
- Java Standard Library
- ArrayList
- File Handling
- CSV File Storage
- Visual Studio Code
- Command Prompt / Terminal
- GitHub

## 5. Project Structure

```text
canteen-billing-system/
│
├── src/
│   ├── Main.java
│   ├── MenuItem.java
│   ├── MenuManager.java
│   ├── OrderItem.java
│   ├── OrderManager.java
│   ├── BillCalculator.java
│   └── InputValidator.java
│
├── data/
│   └── menu.csv
│
├── docs/
│   ├── diagrams/
│   └── screenshots/
│
├── tests/
│   └── test-results.txt
│
├── README.md
└── statement.md