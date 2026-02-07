import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Department");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateDepartment();
                case 5 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        employees.add(new Employee(id, name, dept));
        System.out.println("Employee added successfully!");
    }

    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : employees) {
            System.out.println(e.id + " | " + e.name + " | " + e.department);
        }
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Found: " + e.name + " (" + e.department + ")");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void updateDepartment() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("Enter New Department: ");
                e.department = sc.nextLine();
                System.out.println("Department updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
