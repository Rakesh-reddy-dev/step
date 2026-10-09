import java.util.Scanner;

public class Problem1_CanteenBillingCounter {

    interface Bill {
        double getFinalAmount();
        String getType();
    }

    static class StudentBill implements Bill {
        private final double amount;

        StudentBill(double amount) {
            this.amount = amount;
        }

        public double getFinalAmount() {
            return amount * 0.90;
        }

        public String getType() {
            return "STUDENT";
        }
    }

    static class StaffBill implements Bill {
        private final double amount;

        StaffBill(double amount) {
            this.amount = amount;
        }

        public double getFinalAmount() {
            return amount * 0.95;
        }

        public String getType() {
            return "STAFF";
        }
    }

    static class GuestBill implements Bill {
        private final double amount;

        GuestBill(double amount) {
            this.amount = amount;
        }

        public double getFinalAmount() {
            return amount + 10;
        }

        public String getType() {
            return "GUEST";
        }
    }

    static Bill createBill(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT":
                return new StudentBill(amount);
            case "STAFF":
                return new StaffBill(amount);
            case "GUEST":
                return new GuestBill(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Bill bill = createBill(type, amount);
            double finalAmount = bill.getFinalAmount();

            System.out.printf("%s: %.2f%n", bill.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
