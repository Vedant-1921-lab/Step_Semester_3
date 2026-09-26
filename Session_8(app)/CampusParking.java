import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double getCharge();
    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    public double getCharge() {
        return hours * 10;
    }

    public String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    public double getCharge() {
        if (hours <= 1) {
            return 30;
        }
        return 30 + (hours - 1) * 20;
    }

    public String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    public double getCharge() {
        double charge = hours * 50;
        return Math.max(charge, 100);
    }

    public String getType() {
        return "TRUCK";
    }
}

public class CampusParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;
                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;
                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.getCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", v.getType(), charge);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}