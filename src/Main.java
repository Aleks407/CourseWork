import java.util.Random;

public class Main {

    public final static Random RANDOM = new Random();
    public final static String[] NAMES = {"Иван", "Петр", "Степан", "Федор", "Василий", "Михаил", "Олег"};
    public final static String[] SURNAMES = {"Иванов", "Петров", "Степанов", "Федоров", "Васильев", "Михайлов", "Олегов"};
    public final static String[] PATRONYMIC_NAMES = {"Иванович", "Петрович", "Степанович", "Федорович", "Васильевич", "Михаилович", "Олегович"};

    public final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(SURNAMES.length)] + " "
                    + NAMES[RANDOM.nextInt(NAMES.length)] + " " +
                    PATRONYMIC_NAMES[RANDOM.nextInt(PATRONYMIC_NAMES.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50_000, 100_000));

        }

    }

    public static void main(String[] args) {

        initEmployees();
        print();
        System.out.println("Сумма зарплат сотрудников " + calculateSumOfSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + findMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + findMaxSalary());
        System.out.println("Средняя ЗП: " + calculateSumOfSalary());
        printFullNames();

    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalary() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double calculateAverageOfSalary() {

        return (double) calculateSumOfSalary() / EMPLOYEES.length;
    }

    private static void printFullNames() {
        for (Employee employee :EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
}




