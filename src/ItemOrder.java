public class ItemOrder {
    private String name;
    private int quantity;
    private double price;
//test kommentar
    public ItemOrder(String name, int quantity, double price, GroceryList list) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;

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
