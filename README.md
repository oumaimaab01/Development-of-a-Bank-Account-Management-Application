
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#built-with">Built With</a>
    </li>
  </ol>
</details>




<!-- ABOUT THE PROJECT -->
## About The Project

In this project, the aim is to create a bank account management application. To do this, it is necessary to program two different interfaces: one for clients and another for agents.
The client interface will allow them to view the history of all their transactions, as well as their current balance. Clients will also be able to perform new operations such as deposits or withdrawals.
The agent interface, on the other hand, will allow them to view all the accounts of the agency and to delete or add accounts as they wish.

### Analysis and design of the application, including the classes utilized within the application:

1. **Account Class**:
    - Constructors to initialize an Account instance with name and balance parameters.
    - Methods for adding and removing operations, getters/setters, toString method for string representation, equals method for comparison, deposit and withdraw operations, transfer between accounts, and generating bank statements.
  
2. **Operation Class**:
    - Constructor to specify the type of operation, amount, and date.
    - Methods for string representation and comparison.
  
3. **InsufficientFundException**:
    - Exception thrown if the account balance is insufficient for a transaction.
  
4. **NegativeAmountException**:
    - Exception thrown when attempting to deposit a negative amount.
  
5. **CurrentAccount and SavingAccount Classes**:
    - Subclasses of Account to specify account types.
    - Constructors, toString methods, and specific operations like withdrawal for CurrentAccount and deposit for SavingAccount.

6. **AuthFrame Class**:
    - Authentication frame for user access.
  
7. **AdminFrame Class**:
    - Interface for agent window, allowing viewing, addition, and deletion of accounts.
  
8. **CustomerFrame Class**:
    - Interface for client window, enabling viewing account details and performing transactions.
  
9. **Authorization Class**:
    - Defines a method for user authorization.
  
10. **Bank Class**:
    - Manages a list of bank accounts, providing functionalities like account search, bank instance creation, name modification, adding new accounts, and simulating bank transactions.

11. **Main Class**:
    - Simulates banking operations on two accounts using instances of CurrentAccount and SavingAccount.
    - Utilizes the Authorization interface for user authentication, performing random deposit, withdrawal, and transfer operations on accounts and displaying bank statements afterward.

## Built With

This section lists the major frameworks/libraries used to bootstrap this project.
* [Java](https://www.java.com/)
* [Swing Java](https://docs.oracle.com/javase/tutorial/uiswing/)


<p align="right">(<a href="#readme-top">back to top</a>)</p>










