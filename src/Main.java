import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PaymentGateway gateway = new PaymentGateway();

        gateway.add(new GCashPayment(
                1001,
                "Miro",
                1500.00,
                "0917-555-0134"
        ));

        gateway.add(new MayaPayment(
                1002,
                "Millard",
                899.50,
                "Millard@liceo.edu.ph"
        ));

        gateway.add(new CashPayment(
                1003,
                "Nestlemies",
                250.00
        ));

        while (true) {
            System.out.println();
            System.out.println("================================");
            System.out.println("          LICEO PAY");
            System.out.println("================================");
            System.out.println("1. Make Payment");
            System.out.println("2. Show All Receipts");
            System.out.println("3. Find Payment");
            System.out.println("4. Show Total Collected");
            System.out.println("5. Refund All");
            System.out.println("6. Show Service Fees");
            System.out.println("7. Exit");
            System.out.println("================================");

            try {
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        try {
                            System.out.print("Enter payment ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Enter payer name: ");
                            String name = scanner.nextLine();

                            System.out.print("Enter amount: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.println("Choose payment method:");
                            System.out.println("1. GCash");
                            System.out.println("2. Maya");
                            System.out.println("3. Cash");
                            System.out.print("Choice: ");

                            int method = scanner.nextInt();
                            scanner.nextLine();

                            if (method == 1) {
                                System.out.print("Enter mobile number: ");
                                String mobile = scanner.nextLine();

                                Payment payment =
                                        new GCashPayment(id, name, amount, mobile);

                                gateway.add(payment);
                                payment.printReceipt();
                                payment.printThankYou();

                            } else if (method == 2) {
                                System.out.print("Enter email: ");
                                String email = scanner.nextLine();

                                Payment payment =
                                        new MayaPayment(id, name, amount, email);

                                gateway.add(payment);
                                payment.printReceipt();
                                payment.printThankYou();

                            } else if (method == 3) {
                                Payment payment =
                                        new CashPayment(id, name, amount);

                                gateway.add(payment);
                                payment.printReceipt();
                                payment.printThankYou();

                            } else {
                                System.out.println("Invalid payment method.");
                            }

                        } catch (Exception e) {
                            System.out.println("Invalid payment input.");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        System.out.println();
                        System.out.println("All payment receipts:");
                        gateway.processAll();
                        break;

                    case 3:
                        try {
                            System.out.print("Enter payment ID to find: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            Payment payment = gateway.findById(id);

                            if (payment != null) {
                                System.out.println("Payment found:");
                                payment.printReceipt();
                            } else {
                                System.out.println("Payment not found.");
                            }

                        } catch (Exception e) {
                            System.out.println("Invalid ID.");
                            scanner.nextLine();
                        }
                        break;

                    case 4:
                        System.out.printf(
                                "Total collected: PHP %.2f%n",
                                gateway.totalCollected()
                        );
                        break;

                    case 5:
                        System.out.println();
                        System.out.println(
                                "Refunding every payment that can be refunded:"
                        );
                        gateway.refundAll();
                        break;

                    case 6:
                        System.out.println();
                        System.out.println(
                                "Service fees (the two serviceFee methods):"
                        );
                        gateway.showServiceFees();
                        break;

                    case 7:
                        System.out.println("Thank you for using LICEO PAY.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
