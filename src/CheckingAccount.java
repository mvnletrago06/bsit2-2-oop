public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName,
                           double openingBalance, double overdraftLimit) {
        super(accountNumber, ownerName, openingBalance);

        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "CHECKING";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        double remaining = getBalance() - amount;

        // Checks if the withdrawal goes past the overdraft limit.
        if (remaining < -overdraftLimit) {
            double shortfall = (-overdraftLimit) - remaining;
            throw new InsufficientFundsException(shortfall);
        }

        // Used instead of super.withdraw() because checking can go negative.
        applyWithdrawal(amount);
    }
}
