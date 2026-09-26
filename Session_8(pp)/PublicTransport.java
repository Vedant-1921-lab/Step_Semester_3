public class PublicTransport {

    static abstract class Journey {
        protected double distance;

        public Journey(double distance) {
            this.distance = distance;
        }

        public abstract double getFare();
        public abstract String getType();
    }

    static class Bus extends Journey {
        public Bus(double distance) {
            super(distance);
        }

        public double getFare() {
            double fare = 2 + distance * 0.10;
            return Math.min(fare, 10);
        }

        public String getType() {
            return "BUS";
        }
    }

    static class Train extends Journey {
        public Train(double distance) {
            super(distance);
        }

        public double getFare() {
            return 3 + distance * 0.15;
        }

        public String getType() {
            return "TRAIN";
        }
    }

    static class Metro extends Journey {
        private double peakHourFactor;

        public Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        public double getFare() {
            return (1.50 + distance * 0.20) * peakHourFactor;
        }

        public String getType() {
            return "METRO";
        }
    }

    public static void main(String[] args) {
        Journey[] journeys = {
            new Bus(15),
            new Train(50),
            new Metro(10, 1.5)
        };

        double total = 0;
        for (Journey j : journeys) {
            double fare = j.getFare();
            total += fare;
            System.out.printf("%s: %.2f%n", j.getType(), fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}