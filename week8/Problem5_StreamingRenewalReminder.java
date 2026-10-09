import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problem5_StreamingRenewalReminder {

    interface Plan {
        LocalDate getRenewalDate(LocalDate startDate);
    }

    static class BasicPlan implements Plan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(30);
        }
    }

    static class StandardPlan implements Plan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(90);
        }
    }

    static class PremiumPlan implements Plan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(365);
        }
    }

    static Plan createPlan(String type) {
        switch (type.toUpperCase()) {
            case "BASIC":
                return new BasicPlan();
            case "STANDARD":
                return new StandardPlan();
            case "PREMIUM":
                return new PremiumPlan();
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next(), formatter);

            Plan plan = createPlan(type);
            LocalDate renewalDate = plan.getRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate.format(formatter));
        }

        sc.close();
    }
}
