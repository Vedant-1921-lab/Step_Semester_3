public class LibraryManagement {
    String title;
    String author;
    int copiesAvailable;

    public LibraryManagement(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        LibraryManagement[] books = new LibraryManagement[4];

        books[0] = new LibraryManagement("Clean Code", "Robert C. Martin", 3);
        books[1] = new LibraryManagement("Effective Java", "Joshua Bloch", 5);
        books[2] = new LibraryManagement("Refactoring", "Martin Fowler", 0);
        books[3] = new LibraryManagement("Design Patterns", "GoF", 2);

        for (LibraryManagement book : books) {
            book.printEntry();
        }
    }
}