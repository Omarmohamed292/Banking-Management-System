# BankFX

A JavaFX desktop banking management system built with **Java 17**, **JavaFX**, **Maven**, and **JUnit 5**.

## Overview

BankFX is an educational banking application that demonstrates object-oriented programming, inheritance, polymorphism, GUI development, validation, transaction logging, and separation between the UI and business logic.

## Features

- Customer registration and login
- Employee login and customer management
- Normal and investment account creation
- Deposit and withdrawal operations
- Account deletion
- Customer profile updates
- Investment balance projection at 5%
- Normal account 7% cashback rule from the original project requirements
- Transaction logging with date/time and account ID
- Input validation and JavaFX error/information dialogs
- Business logic separated into a `BankService`
- JUnit tests for account and service behavior

## Tech Stack

- Java 17+
- JavaFX 17
- Maven
- JUnit 5
- IntelliJ IDEA or any Java IDE that supports Maven

## Project Structure

```text
src/
├── main/java/
│   ├── app/             # JavaFX application entry point
│   ├── mainClasses/     # Domain models and account types
│   ├── Nodes/           # Reusable JavaFX UI components
│   ├── Scenes/          # JavaFX application screens
│   └── services/        # Business logic
│
├── main/resources/      # Images and CSS
└── test/java/            # JUnit tests
```

## Running the Project

1. Install **JDK 17 or newer** and Maven.
2. Clone the repository.
3. Open the project as a Maven project.
4. Run:

```bash
mvn clean test
mvn javafx:run
```

The application starts on the login screen.

## Demo Credentials

### Customer

| ID | Password |
|---|---|
| C0 | 123 |
| C1 | 123 |
| C2 | 123 |
| C3 | 123 |
| C4 | 123 |

### Employee

| ID | Password |
|---|---|
| 1 | 1 |
| 2 | 2 |
| 3 | 3 |

These credentials are sample data for demonstration only.

## Architecture

The application uses a simple layered structure:

- **Models:** `Customer`, `Employee`, `Account`, `NormalAccount`, `InvestmentAccount`, and `Transaction`.
- **Service layer:** `BankService` handles authentication, registration, account management, deposits, and withdrawals.
- **UI layer:** JavaFX `Scenes` and reusable `Nodes` handle presentation and user interaction.

This keeps most business operations out of the JavaFX event handlers and makes the core logic easier to test.

## Testing

Run the unit tests with:

```bash
mvn test
```

The test suite covers:

- Deposits and withdrawals
- Cashback behavior
- Investment projection
- Invalid transaction amounts
- Registration and duplicate IDs
- Account creation and operations through `BankService`

## Transaction Log

Successful account operations are appended to `transaction.txt` in the project working directory. The file is intentionally ignored by Git because it is runtime data.

## Notes

This is an educational desktop project. It does **not** use a database, and authentication data is stored in memory for the current application session. It should not be treated as production banking software.
