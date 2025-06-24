# Bank Risk Analysis  
*Console-Based Java Project*

## 🚀 Project Overview

This Java console application models **inter-bank lending dynamics** to assess financial risk within a banking network. It calculates the total assets of each bank by summing their current balances and the loans they have extended to other banks. The program then identifies **unsafe banks** — those whose total assets fall below a user-defined safety limit.

## 🛠️ Features

- Models lending relationships between multiple banks.  
- Calculates total assets considering both bank balances and loans to borrowers.  
- Detects unsafe banks by comparing total assets to a safety threshold.  
- Completely console-based — no graphical user interface (UI).


## 🧩 Code Structure and Functionality

- **Input:**  
  - Number of banks.  
  - Safety limit for banks.  
  - Each bank's balance and loans given to other banks.  

- **Core Methods:**  
  - `getInfo()`: Collects bank balances and borrower loan details from the user.  
  - `calcAssets()`: Calculates total assets for a given bank (balance + loans).  
  - `isUnsafe()`: Iteratively identifies unsafe banks whose total assets fall below the limit and adjusts loan data accordingly.  

- **Output:**  
  - Prints the list of unsafe banks identified after analysis.


## 🏃 How to Run

1. Compile the project using your Java compiler:
2. Run the program from your console or terminal:
3. Follow the prompts to enter the number of banks, the safety limit, and bank data.


## 🗓️ Project Timeline

- **Start Date:** February 15, 2024  
- **End Date:** March 14, 2024


## 📌 Notes

- This is a **console-based** project with no UI components.  
- Designed primarily for educational purposes to demonstrate risk analysis in banking.


*Author: Maheen Asim*

