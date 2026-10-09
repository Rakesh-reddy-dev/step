import java.util.Scanner;

public class Problem3_HostelElectricityBill {

    interface Room {
        double getBill();
        String getType();
    }

    static class SingleRoom implements Room {
        private final int units;

        SingleRoom(int units) {
            this.units = units;
        }

        public double getBill() {
            return units * 8.0;
        }

        public String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom implements Room {
        private final int units;
        private final int occupants;

        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public double getBill() {
            return (units * 6.0) / occupants;
        }

        public String getType() {
            return "SHARED";
        }
    }

    static class AcRoom implements Room {
        private final int units;

        AcRoom(int units) {
            this.units = units;
        }

        public double getBill() {
            return units * 10.0 + 200;
        }

        public String getType() {
            return "AC";
        }
    }

    static Room createRoom(String type, int units, int occupants) {
        switch (type.toUpperCase()) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                return new SharedRoom(units, occupants);
            case "AC":
                return new AcRoom(units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            int occupants = 1;

            if (type.equalsIgnoreCase("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room = createRoom(type, units, occupants);
            double bill = room.getBill();

            System.out.printf("%s: %.2f%n", room.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
