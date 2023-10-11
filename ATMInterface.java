
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMInterface {
    private double balance;
    private List<String> transactionHistory;
    private Scanner scanner;

    public ATMInterface() {
        balance = 1000.0; // Initial balance
        transactionHistory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn $" + amount);
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited $" + amount);
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void transfer() {
        System.out.print("Enter the recipient's account number: ");
        String recipientAccount = scanner.next();
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred $" + amount + " to account " + recipientAccount);
            System.out.println("$" + amount + " transferred successfully to account " + recipientAccount);
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        int choice;

        do {
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            choice = atm.scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.withdraw();
                    break;
                case 3:
                    atm.deposit();
                    break;
                case 4:
                    atm.transfer();
                    break;
                case 5:
                    atm.showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        atm.scanner.close();
    }
}


