public class DeliveryFee {

    static abstract class Delivery {
        protected double weight;
        protected double distance;

        public Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public abstract double getFee();
        public abstract String getType();
    }

    static class Standard extends Delivery {
        public Standard(double weight, double distance) {
            super(weight, distance);
        }

        public double getFee() {
            return 5 + weight * 0.50 + distance * 0.10;
        }

        public String getType() {
            return "STANDARD";
        }
    }

    static class Express extends Delivery {
        public Express(double weight, double distance) {
            super(weight, distance);
        }

        public double getFee() {
            return 15 + weight * 2.00 + distance * 0.20;
        }

        public String getType() {
            return "EXPRESS";
        }
    }

    static class International extends Delivery {
        private double customsFee;

        public International(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        public double getFee() {
            return 25 + weight * 2.00 + distance * 0.60 + customsFee;
        }

        public String getType() {
            return "INTERNATIONAL";
        }
    }

    public static void main(String[] args) {
        Delivery[] deliveries = {
            new Standard(10, 50),
            new Express(5, 20),
            new International(20, 100, 30)
        };

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.getFee();
            total += fee;
            System.out.printf("%s: %.2f%n", d.getType(), fee);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}