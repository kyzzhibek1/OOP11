public class Main {
    public static void main(String[] args) {
        try {
            PersonalAccount account = new PersonalAccount(2805, "Jibek");
            account.deposit(3400);
            account.withdraw(500);
            account.deposit(100);

            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("\nTransaction History:");
            account.printHistory();

            double withdrawalAmount = 7000;
            account.withdraw(withdrawalAmount);

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}