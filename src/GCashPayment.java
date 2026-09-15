public class GCashPayment extends Payment implements Refundable {

    private String mobile;

    public GCashPayment(int id, String payerName, double amount, String mobile) {
        super(id, payerName, amount);
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String provider() {
        return "GCASH";
    }

    @Override
    public void pay() {
        try {
            System.out.printf(" GCash: PHP %.2f sent from %s.%n",
                    getAmount(), mobile);
        } catch (Exception e) {
            System.out.println("Unable to process GCash payment.");
        }
    }

    @Override
    public String refund() {
        try {
            return "GCash refund of PHP "
                    + String.format("%.2f", getAmount())
                    + " returned to " + mobile + ".";
        } catch (Exception e) {
            return "GCash refund could not be processed.";
        }
    }

    @Override
    public void printThankYou() {
        super.printThankYou();
        System.out.println(" An SMS receipt was sent to " + mobile);
    }
}

