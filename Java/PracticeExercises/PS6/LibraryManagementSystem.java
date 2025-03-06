public class LibraryManagementSystem {
    private Item[] items;
    private int ctr = 0;

    public LibraryManagementSystem(int maxItems) {
        items = new Item[maxItems];
    }

    // method overloading (?)
    public void addItem(int isbn, String name, String author) {
        items[ctr] = new Book(isbn, name, author);
        ctr++;
    }

    // method overloading (?)
    public void addItem(double volume, String name, String publisher) {
        items[ctr] = new Magazine(volume, name, publisher);
        ctr++;
    }

    // method overloading (?)
    public Book findItem(int isbn) {
        for(Item i : items) {
            if(i instanceof Book) {
                Book temp = (Book) i;
                if(temp.getISBN() == isbn) {
                    return temp;
                }
            }
        }
        return null;
    }

    // method overloading (?)
    public Magazine findItem(double volume) {
        for(Item i : items) {
            if(i instanceof Magazine) {
                Magazine temp = (Magazine) i;
                if(temp.getVolume() == volume) {
                    return temp;
                }
            }
        }
        return null;
    }


    public void listItems() {
        System.out.println("\n==========List of Books==========");
        for(Item i : items) {
            if(i instanceof Book && !i.isBorrowed) {
                i.displayDetails();
            }
        }

        System.out.println("\n==========List of Magazines======");
        for(Item i : items) {
            if(i instanceof Magazine) {
                i.displayDetails();
            }
        }

    }
}