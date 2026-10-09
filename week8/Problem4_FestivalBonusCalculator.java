import java.util.Scanner;

public class Problem4_FestivalBonusCalculator {

    interface Employee {
        double getBonus();
        String getName();
    }

    static class FullTimeEmployee implements Employee {
        private final String name;
        private final double salary;

        FullTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double getBonus() {
            return salary * 0.10;
        }

        public String getName() {
            return name;
        }
    }

    static class PartTimeEmployee implements Employee {
        private final String name;
        private final double salary;

        PartTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double getBonus() {
            return salary * 0.05;
        }

        public String getName() {
            return name;
        }
    }

    static class Intern implements Employee {
        private final String name;

        Intern(String name, double salary) {
            this.name = name;
        }

        public double getBonus() {
            return 2000.0;
        }

        public String getName() {
            return name;
        }
    }

    static Employee createEmployee(String type, String name, double salary) {
        switch (type.toUpperCase()) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new Intern(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = createEmployee(type, name, salary);
            double bonus = employee.getBonus();

            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}
