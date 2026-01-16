import java.util.Scanner;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price  must be positive.");
            this.price = 0.0;
        }
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book myBook = new Book();

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Is the book available? (true/flase): ");
        boolean availability = sc.nextBoolean();

        myBook.setBookID(id);
        myBook.setTitle(title);
        myBook.setAuthor(author);
        myBook.setPrice(price);
        myBook.setAvailability(availability);

        System.out.println("\n Book Details");
        System.out.println("Book ID: " + myBook.getBookID());
        System.out.println("Title: " + myBook.getTitle());
        System.out.println("Author: " + myBook.getAuthor());
        System.out.println("Price: " + myBook.getPrice());
        System.out.println("Available: " + (myBook.isAvailable() ? "Yes" : "No"));

        sc.close();
    }
}
