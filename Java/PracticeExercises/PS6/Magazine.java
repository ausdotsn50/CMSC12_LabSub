public class Magazine extends Item {
    private double volume;
    private String publisher;

    public Magazine(double volume, String name, String publisher) {
        super(name);
        this.volume = volume;
        this.publisher = publisher;
    }

    public double getVolume() {
        return volume;
    }

    public String getPublisher () {
        return publisher;
    }

    public void displayDetails() {
        System.out.println("\nVolume: " + volume);
        System.out.println("Name: " + name);
        System.out.println("Publisher: " + publisher);
    };

    public void borrowItem() {
        if(!isBorrowed) {
            isBorrowed = true;
            System.out.println("Magazine: " + name + ", with volume: " + volume + " has been successfully borrowed"); 
        } else {
            displayStatus();
        }
        
    }

    public void returnItem() {
        if(!isBorrowed) {
            displayStatus();
        } else {
            isBorrowed = false;
            System.out.println("Magazine: " + name + ", with volume: " + volume + " has been successfully returned");
        }
    }

    public void displayStatus() {
        if(!isBorrowed) {
            System.out.println("Magazine: " + name + ", with ISBN: " + volume + " is available for borrowing");
        } else {
            System.out.println("Magazine: " + name + ", with ISBN: " + volume + " is not available for borrowing :(");
        }
    }
}