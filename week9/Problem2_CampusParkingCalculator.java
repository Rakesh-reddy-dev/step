import java.util.Scanner;

public class Problem2_CampusParkingCalculator {

    interface Vehicle {
        double getCharge();
        String getType();
    }

    static class Bike implements Vehicle {
        private final int hours;

        Bike(int hours) {
            this.hours = hours;
        }

        public double getCharge() {
            return hours * 10.0;
        }

        public String getType() {
            return "BIKE";
        }
    }

    static class Car implements Vehicle {
        private final int hours;

        Car(int hours) {
            this.hours = hours;
        }

        public double getCharge() {
            return 30 + (hours - 1) * 20.0;
        }

        public String getType() {
            return "CAR";
        }
    }

    static class Truck implements Vehicle {
        private final int hours;

        Truck(int hours) {
            this.hours = hours;
        }

        public double getCharge() {
            return Math.max(100, hours * 50.0);
        }

        public String getType() {
            return "TRUCK";
        }
    }

    static Vehicle createVehicle(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle = createVehicle(type, hours);
            double charge = vehicle.getCharge();

            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
