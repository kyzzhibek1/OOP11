public class Amount {
    private final double amount;
    private final String transactions;
    public Amount(double amount, String transactions) {
        this.amount = amount;
        this.transactions = transactions;
    }
    @Override    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                ", transactions='" + transactions + '\'' +
                '}';    }}