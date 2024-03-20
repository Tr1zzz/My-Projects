public class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;
    private int year; // Publication year
    private String description; // A brief description of the book

    public Book(String title, String author, String isbn, int quantity, int year, String description) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
        this.year = year;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}
