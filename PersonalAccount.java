import java.util.ArrayList;

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    ArrayList<Amount> transactions = new ArrayList<>();

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Amount(amount, "deposit"));
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Cannot withdraw $" + amount + ". Current balance: $" + balance);
        } else {
            balance -= amount;
            transactions.add(new Amount(amount, "withdraw"));
        }
    }

    public void printHistory() {
        for (Amount trans : transactions) {
            System.out.println(trans);
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Amount> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Amount> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}