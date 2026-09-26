import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double getFinalAmount();
    public abstract String getType();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    public double getFinalAmount() {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    public double getFinalAmount() {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    public double getFinalAmount() {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Customer[] bills = new Customer[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "STUDENT":
                    bills[i] = new Student(amount);
                    break;
                case "STAFF":
                    bills[i] = new Staff(amount);
                    break;
                case "GUEST":
                    bills[i] = new Guest(amount);
                    break;
            }
        }

        double total = 0;
        for (Customer c : bills) {
            double finalAmount = c.getFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}