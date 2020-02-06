import java.io.PrintStream;
import java.util.ArrayList;

public class GroceryList {
    ArrayList<ItemOrder> list = new ArrayList<>();

    //method used when constructing new ItemOrder object that adds the object directly to the GroceryList ArrayList
    public void addItemOrder(ItemOrder itemOrder) {
        list.add(itemOrder);
    }

    //get order total of all ItemOrders in the GroceryList
    public double getOrderTotal() {
        double orderTotal = 0;
        for (ItemOrder itemOrder : list) {
            orderTotal += itemOrder.getQuantity() * itemOrder.getPrice();
        }
        return orderTotal;
    }

    //prints GroceryList to console
    public void printList() {
        System.out.println("This list contains:");
        for (ItemOrder itemOrder : list) {
            System.out.println(itemOrder);
        }
        System.out.println("Order total: DKK " + getOrderTotal() + ".");
    }

    //prints only important information regarding each ItemOrder object to "itemOrder.txt" file
    public void printToFile(PrintStream output) {
        for (ItemOrder itemOrder : list) {
            //values of objects are output with "," to separate them and linebreak between each individual object
            output.println(itemOrder.getName() + "," + itemOrder.getQuantity() + "," + itemOrder.getPrice());
        }
    }
}
