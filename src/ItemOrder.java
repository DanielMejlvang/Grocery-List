public class ItemOrder {
    private String name;
    private int quantity;
    private double price;

    public ItemOrder(String name, int quantity, double price, GroceryList list) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;

        //constructing this object will automatically add it to the GroceryList ArrayList
        list.addItemOrder(this);
    }

    //A second constructor that only needs a name to create a new object and ads it to the GroceryList ArrayList
    public ItemOrder(String name, GroceryList list){
        this.name=name;
        this.quantity=1;
        this.price=0;

        list.addItemOrder(this);
    }

    public String toString() {
        return name + " - " + quantity + " x " + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
