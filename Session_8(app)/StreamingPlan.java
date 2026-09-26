import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    public Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate getRenewalDate();
    public String getName() {
        return name;
    }
}

class Basic extends Plan {
    public Basic(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends Plan {
    public Standard(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends Plan {
    public Premium(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            switch (type) {
                case "BASIC":
                    plans[i] = new Basic(name, startDate);
                    break;
                case "STANDARD":
                    plans[i] = new Standard(name, startDate);
                    break;
                case "PREMIUM":
                    plans[i] = new Premium(name, startDate);
                    break;
            }
        }

        for (Plan p : plans) {
            System.out.println(p.getName() + ": " + p.getRenewalDate());
        }

        sc.close();
    }
}