public class Book extends Item implements Borrowable{
    private int isbn;
    private String author;

    public Book(int isbn, String name, String author) {
        super(name);
        this.isbn = isbn;
        this.author = author;
    }

    public int getISBN() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void displayDetails() {
        System.out.println("\nISBN: " + isbn);
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
    };

    public void borrowItem() {
        if(!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book: " + name + ", with ISBN: " + isbn + " has been successfully borrowed"); 
        } else {
            displayStatus();
        }
        
    }

    public void returnItem() {
        if(!isBorrowed) {
            displayStatus();
        } else {
            isBorrowed = false;
            System.out.println("Book: " + name + ", with ISBN: " + isbn + " has been successfully returned");
        }
    }

    public void displayStatus() {
        if(!isBorrowed) {
            System.out.println("Book: " + name + ", with ISBN: " + isbn + " is available for borrowing");
            System.out.println("Book: " + name + ", with ISBN: " + isbn + " is not available for returning");
        } else {
            System.out.println("Book: " + name + ", with ISBN: " + isbn + " is not for borrowing");
            System.out.println("Book: " + name + ", with ISBN: " + isbn + " is for returning");
        }
    }
}