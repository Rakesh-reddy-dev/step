class Employee {
    String empName;
    double salary;
    boolean permanent;
}

public class Problem3_DefaultFieldValues {
    public static void main(String[] args) {
        Employee employee = new Employee();

        System.out.println("Name: " + employee.empName);
        System.out.println("Salary: " + employee.salary);
        System.out.println("Permanent: " + employee.permanent);
    }
}
