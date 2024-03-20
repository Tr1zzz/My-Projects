import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void checkOutBook(String isbn) {
        books.stream()
                .filter(book -> book.getIsbn().equals(isbn) && book.getQuantity() > 0)
                .findFirst()
                .ifPresent(book -> book.setQuantity(book.getQuantity() - 1));
    }

    public void returnBook(String isbn) {
        books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .ifPresent(book -> book.setQuantity(book.getQuantity() + 1));
    }
}
