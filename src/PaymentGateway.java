import java.util.ArrayList;

public class PaymentGateway {

    private ArrayList<Payment> payments = new ArrayList<>();

    public void add(Payment payment) {
        try {
            payments.add(payment);
        } catch (Exception e) {
            System.out.println("Unable to add payment.");
        }
    }

    public int count() {
        return payments.size();
    }

    public void processAll() {
        if (payments.isEmpty()) {
            System.out.println("No payments have been made yet.");
            return;
        }

        try {
            for (Payment p : payments) {
                p.printReceipt();
                p.printThankYou();
            }
        } catch (Exception e) {
            System.out.println("Unable to process all payments.");
        }
    }

    public void showServiceFees() {
        if (payments.isEmpty()) {
            System.out.println("No payments have been made yet.");
            return;
        }

        try {
            for (Payment p : payments) {
                System.out.printf(
                        "[%d] %-6s standard 2%%: PHP %8.2f student 1%%: PHP %8.2f%n",
                        p.getId(),
                        p.provider(),
                        p.serviceFee(),
                        p.serviceFee(0.01)
                );
            }
        } catch (Exception e) {
            System.out.println("Unable to calculate service fees.");
        }
    }

    public Payment findById(int id) {
        try {
            for (Payment p : payments) {
                if (p.getId() == id) {
                    return p;
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to search for payment.");
        }

        return null;
    }

    public double totalCollected() {
        double total = 0;

        try {
            for (Payment p : payments) {
                total += p.getAmount();
            }
        } catch (Exception e) {
            System.out.println("Unable to calculate total collected.");
        }

        return total;
    }

    public void refundAll() {
        int found = 0;

        try {
            for (Payment p : payments) {
                if (p instanceof Refundable) {
                    Refundable r = (Refundable) p;
                    r.printRefundNotice();
                    found++;
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to process refunds.");
        }

        if (found == 0) {
            System.out.println("No refundable payments were found.");
        }
    }
}
