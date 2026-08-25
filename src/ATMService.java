public class ATMService {

    // Overloading: same method name but different parameters.
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
    }

    public void deposit(Account account, double amount, String note) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
        System.out.println("Note: " + note);
    }

    // Varargs allows the method to accept multiple amounts.
    public double depositAll(Account account, double... amounts) {
        double total = 0;

        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }

        return total;
    }

    public void tryToReplace(Account account) {
        account = new SavingsAccount(
                "XX-000",
                "Ghost Account",
                0,
                0
        );

        System.out.println("Inside the method: " + account);

        // The original account does not change because the reference is passed by value.
    }

    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);

        // The balance changes because the same account object is modified.
    }

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {

        // Withdraw first so the transfer does not add money if the withdrawal fails.
        from.withdraw(amount);
        to.deposit(amount);
    }
}
