
---

## `statement.md`

The PDF specifically requires `statement.md` to contain the problem statement, scope, target users, and high-level features. :contentReference[oaicite:1]{index=1}

```markdown
# Canteen Billing System - Project Statement

## Problem Statement

Managing food orders and calculating bills manually in a canteen can lead to incorrect quantities, calculation mistakes, and difficulty in maintaining menu information.

The Canteen Billing System provides a simple command-line solution for managing menu items, creating customer orders, and calculating the final bill accurately.

## Scope of the Project

The project focuses on a small canteen billing process using a Java command-line application.

The system covers:

- Adding and viewing menu items
- Maintaining item prices and available quantities
- Creating and managing customer orders
- Validating user input
- Calculating item subtotals
- Calculating the final bill
- Storing menu information in a CSV file

The project does not include a graphical user interface, web application, online payment system, authentication, or database server.

## Target Users

The main target users are:

- Canteen staff
- Small food-counter operators
- Students or beginners learning basic billing and Java programming concepts

## High-Level Features

1. Menu Item Management
   - Add menu items
   - View menu items
   - Store price and available quantity

2. Order Management
   - Select food items
   - Enter quantities
   - Create an order
   - View the current order

3. Bill Calculation
   - Calculate item subtotals
   - Calculate the total bill
   - Display the final bill

4. Validation and Error Handling
   - Validate names
   - Validate prices
   - Validate quantities
   - Handle invalid input

5. CSV Storage
   - Store menu data in `data/menu.csv`