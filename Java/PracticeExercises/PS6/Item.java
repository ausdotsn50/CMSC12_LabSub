public abstract class Item {
    protected String name;
    protected boolean isBorrowed;

    public Item(String name) {
        this.name = name;
        this.isBorrowed = false;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}