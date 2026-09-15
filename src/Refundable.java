public interface Refundable {

    String refund();

    default void printRefundNotice() {
        try {
            System.out.println(" " + refund());
        } catch (Exception e) {
            System.out.println(" Unable to process refund notice.");
        }
    }
}
