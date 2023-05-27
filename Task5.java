import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String bookId, String title, String author) {
        Book book = new Book(bookId, title, author);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("Book ID: " + book.getBookId() +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor());
            }
        }
    }

    public void searchBook(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                System.out.println("Book found:");
                System.out.println("Book ID: " + book.getBookId() +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    public void removeBook(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                books.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(bookId, title, author);
                    break;
                case "2":
                    library.displayBooks();
                    break;
                case "3":
                    System.out.print("Enter Book ID: ");
                    String searchBookId = scanner.nextLine();
                    library.searchBook(searchBookId);
                    break;
                case "4":
                    System.out.print("Enter Book ID: ");
                    String removeBookId = scanner.nextLine();
                    library.removeBook(removeBookId);
                    break;
                case "5":
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }
}
