import java.util.Scanner;
import java.util.ArrayList;

class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author + " | " +
                (isIssued ? "Yes" : "No"));
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added");
    }

    void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No Books");
            return;
        }
        for (Book b : books) {
            b.displayBook();
        }
    }

    void issueBook(int id) {
        for (Book b : books) {
            if (b.bookId == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book is issued");
                return;
            }
        }
        System.out.println("Already issued or invalid ID");
    }

    void returnBook(int id) {   // ✅ fixed name
        for (Book b : books) {
            if (b.bookId == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned");
                return;
            }
        }
        System.out.println("Invalid return");
    }
}

public class LMS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library l = new Library();

        l.addBook(new Book(1, "Java", "James"));

        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    l.showBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    l.issueBook(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    l.returnBook(sc.nextInt());
                    break;

                case 4:
                    System.out.println("Thank you for using Library Management System");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
