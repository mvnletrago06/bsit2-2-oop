public class SavingsAccount extends Account {
    public static final double MAINTAINING_BALANCE = 500.0;
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName,
                          double openingBalance, double interestRate) {
        super(accountNumber, ownerName, openingBalance);

        if (openingBalance < MAINTAINING_BALANCE) {
            throw new IllegalArgumentException("Opening balance must be at least PHP " + MAINTAINING_BALANCE);
        }

        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }

        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        double remaining = getBalance() - amount;

        // Checks if the balance will drop below the required maintaining balance
        if (remaining < MAINTAINING_BALANCE) {
            throw new InsufficientFundsException(MAINTAINING_BALANCE - remaining);
        }

        // Delegates actual deduction to parent Account class
        super.withdraw(amount);
    }

    // Calculates monthly interest earned
    public double calculateMonthlyInterest() {
        return getBalance() * interestRate / 12;
    }

    // Deposits the calculated monthly interest into the account balance
    public void applyMonthlyInterest() {
        double interest = calculateMonthlyInterest();
        if (interest > 0) {
            deposit(interest);
        }
    }

    // Getters and Setters
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }
}