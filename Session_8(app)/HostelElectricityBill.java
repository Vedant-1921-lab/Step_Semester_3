import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double getBill();
    public abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    public double getBill() {
        return units * 8;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    public double getBill() {
        return (units * 6) / (double) occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    public double getBill() {
        return units * 10 + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(Integer.parseInt(parts[1]));
                    break;
                case "SHARED":
                    rooms[i] = new SharedRoom(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
                case "AC":
                    rooms[i] = new ACRoom(Integer.parseInt(parts[1]));
                    break;
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.getBill();
            total += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}