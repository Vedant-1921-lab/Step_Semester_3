import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double getBonus();
    public String getName() {
        return name;
    }
}

class FullTime extends Employee {
    public FullTime(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double getBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTime extends Employee {
    public PartTime(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double getBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double getBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            switch (type) {
                case "FULLTIME":
                    employees[i] = new FullTime(name, salary);
                    break;
                case "PARTTIME":
                    employees[i] = new PartTime(name, salary);
                    break;
                case "INTERN":
                    employees[i] = new Intern(name, salary);
                    break;
            }
        }

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.getBonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}