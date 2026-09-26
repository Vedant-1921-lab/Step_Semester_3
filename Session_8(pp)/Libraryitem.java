import java.time.LocalDate;

public class Libraryitem {

    static abstract class Item {
        protected String title;

        public Item(String title) {
            this.title = title;
        }

        public abstract LocalDate getDueDate();
        public String getTitle() {
            return title;
        }
    }

    static class Book extends Item {
        public Book(String title) {
            super(title);
        }

        public LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(14);
        }
    }

    static class Dvd extends Item {
        public Dvd(String title) {
            super(title);
        }

        public LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(7);
        }
    }

    static class Magazine extends Item {
        public Magazine(String title) {
            super(title);
        }

        public LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(3);
        }
    }

    public static void main(String[] args) {
        Item[] items = {
            new Book("1984"),
            new Dvd("The Matrix"),
            new Magazine("Forbes Issue 500")
        };

        for (Item item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate());
        }
    }
}