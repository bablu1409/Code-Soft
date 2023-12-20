import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
	
    private BankAccount userAccount;
    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
    	System.out.println("Welcome to our Bank ATM:");
    	System.out.println("These are the available options you get from the Bank ATM:");
        System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
    }

    public void performTransaction(int option, Scanner scanner) {  
    	switch (option) {   
            case 1:
                // Withdraw
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                }
                break;

            case 2:
                // Deposit
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                break;

            case 3:
                // Check Balance
                System.out.println("Current balance: " + userAccount.getBalance());
                break;

            case 4:
                // Exit
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class ATM_INTERFACE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming an initial balance of $1000 for the bank account
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }
    }
}