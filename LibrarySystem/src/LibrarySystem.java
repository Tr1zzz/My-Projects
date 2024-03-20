import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateLibraryWithBooks(); // Preload some books

        while (true) {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Check out a book");
            System.out.println("5. Return a book");
            System.out.println("Enter your choice (or any other key to exit):");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBooksByTitle();
                    break;
                case 4:
                    checkOutBook();
                    break;
                case 5:
                    returnBook();
                    break;
                default:
                    System.out.println("Exiting system. Farewell!");
                    return;
            }
        }
    }

    private static void populateLibraryWithBooks() {
        library.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "978-0747532699", 10, 1997, "The first novel in the Harry Potter series and Rowling's debut novel."));
        library.addBook(new Book("Alice's Adventures in Wonderland", "Lewis Carroll", "978-1503250214", 5, 1865, "An 1865 novel written by English author Lewis Carroll."));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227", 7, 1937, "A children's fantasy novel by English author J.R.R. Tolkien."));

    }

    private static void addBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        System.out.println("Enter book ISBN:");
        String isbn = scanner.nextLine();
        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter publication year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter a brief description:");
        String description = scanner.nextLine();

        library.addBook(new Book(title, author, isbn, quantity, year, description));
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.println("Enter ISBN of the book to remove:");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
        System.out.println("Book removed successfully if it existed.");
    }

    private static void searchBooksByTitle() {
        System.out.println("Enter title to search:");
        String title = scanner.nextLine();
        List<Book> foundBooks = library.searchByTitle(title);
        if (foundBooks.isEmpty()) {
            System.out.println("No books found.");
        } else {
            foundBooks.forEach(book -> System.out.println(book + "\n"));
        }
    }

    private static void checkOutBook() {
        System.out.println("Enter ISBN of the book to check out:");
        String isbn = scanner.nextLine();
        library.checkOutBook(isbn);
        System.out.println("Book checked out successfully, if available.");
    }

    private static void returnBook() {
        System.out.println("Enter ISBN of the book to return:");
        String isbn = scanner.nextLine();
        library.returnBook(isbn);
        System.out.println("Book returned successfully.");
    }
}
