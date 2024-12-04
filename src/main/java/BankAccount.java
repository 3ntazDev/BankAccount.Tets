
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private boolean isClosed;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.isClosed = false;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with balance: " + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return a copy to prevent modification
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        if (isClosed) {
            throw new IllegalStateException("Cannot deposit to a closed account.");
        }
        balance += amount;
        transactionHistory.add("Deposit: +" + amount + ", Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (isClosed) {
            throw new IllegalStateException("Cannot withdraw from a closed account.");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        transactionHistory.add("Withdrawal: -" + amount + ", Balance: " + balance);
    }

    public void close() {
        isClosed = true;
        transactionHistory.add("Account closed.");
    }
}