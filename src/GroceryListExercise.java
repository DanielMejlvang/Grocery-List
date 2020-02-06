import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class GroceryListExercise {
    public static void main(String[] args) throws FileNotFoundException {
        //add from file
        Scanner input = new Scanner(new File("itemOrder.txt"));
        GroceryList list = new GroceryList();
        addFromFile(list, input);

        //create new item order
        System.out.println("Create new item?\n1. Yes\n2. No");
        Scanner console = new Scanner(System.in);
        int answer = console.nextInt();
        console.nextLine();
        while (answer == 1) {
            System.out.println("Please input item name: ");
            String itemName = console.nextLine();
            System.out.println("Please input quantity: ");
            int itemQuantity = console.nextInt();
            System.out.println("Please input price per unit: ");
            double itemPrice = console.nextDouble();
            new ItemOrder(itemName, itemQuantity, itemPrice, list);

            System.out.println("Do you want to add another item?\n1. Yes\n2. No");
            answer = console.nextInt();
            console.nextLine();
        }

        PrintStream output = new PrintStream(new File("itemOrder.txt"));
        list.printToFile(output);
        list.printList();
    }

    public static void addFromFile(GroceryList list, Scanner input) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] tokens = line.split(",");
            new ItemOrder(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]), list);
        }
    }
}
