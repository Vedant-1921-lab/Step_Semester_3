public class PaymentSystem {

    static abstract class Payment {
        protected double amount;

        public Payment(double amount) {
            this.amount = amount;
        }

        public abstract double getAdjustedAmount();
        public abstract String getType();
    }

    static class Card extends Payment {
        public Card(double amount) {
            super(amount);
        }

        public double getAdjustedAmount() {
            return amount + amount * 0.02;
        }

        public String getType() {
            return "CARD";
        }
    }

    static class Wallet extends Payment {
        public Wallet(double amount) {
            super(amount);
        }

        public double getAdjustedAmount() {
            return amount + amount * 0.01;
        }

        public String getType() {
            return "WALLET";
        }
    }

    static class BankTransfer extends Payment {
        public BankTransfer(double amount) {
            super(amount);
        }

        public double getAdjustedAmount() {
            return amount;
        }

        public String getType() {
            return "BANKTRANSFER";
        }
    }

    public static void main(String[] args) {
        Payment[] transactions = {
            new Card(1000),
            new Wallet(500),
            new BankTransfer(2000)
        };

        double total = 0;
        for (Payment p : transactions) {
            double adjusted = p.getAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}