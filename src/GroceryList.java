import java.io.PrintStream;
import java.util.ArrayList;

public class GroceryList {
    ArrayList<ItemOrder> list = new ArrayList<>();

    public void addItemOrder(ItemOrder itemOrder) {
        list.add(itemOrder);
    }

    public double getOrderTotal() {
        double orderTotal = 0;
        for (ItemOrder itemOrder : list) {
            orderTotal += itemOrder.getQuantity() * itemOrder.getPrice();
        }
        return orderTotal;
    }

    public void printList() {
        System.out.println("This list contains:");
        for (ItemOrder itemOrder : list) {
            System.out.println(itemOrder);
        }
        System.out.println("Order total: DKK" + getOrderTotal() + ".");
    }

    public void printToFile(PrintStream output) {
        for (ItemOrder itemOrder : list) {
            output.println(itemOrder.getName() + "," + itemOrder.getQuantity() + "," + itemOrder.getPrice());
        }
    }
}
