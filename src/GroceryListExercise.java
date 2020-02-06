import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class GroceryListExercise {
    public static void main(String[] args) throws FileNotFoundException {
        //adds to GroceryList from "itemOrder.txt" file
        Scanner input = new Scanner(new File("itemOrder.txt"));
        GroceryList list = new GroceryList();
        addFromFile(list, input);

        //create new item order by prompting user
        System.out.println("Create new item?\n1. Yes\n2. No");
        Scanner console = new Scanner(System.in);
        int answer = console.nextInt(); //TODO: ensure user input
        console.nextLine(); //consumes linebreak from previous input
        while (answer == 1) {
            System.out.println("Please input item name: ");
            String itemName = console.nextLine();

            System.out.println("Do you know the quantity and price?\n1. Yes\n2. No");
            int answer2 = console.nextInt();
            console.nextLine();
            if (answer2 == 2){
                //calls constructor using only name
                new ItemOrder(itemName, list);
            } else {
                System.out.println("Please input quantity: ");
                int itemQuantity = console.nextInt();
                System.out.println("Please input price per unit: ");
                double itemPrice = console.nextDouble();
                new ItemOrder(itemName, itemQuantity, itemPrice, list);
            }

            //prompts user whether they want to run the loop again
            System.out.println("Do you want to add another item?\n1. Yes\n2. No");
            answer = console.nextInt();
            console.nextLine();

        }

        //prints GroceryList to file
        PrintStream output = new PrintStream(new File("itemOrder.txt"));
        list.printToFile(output);
        //prints GroceryList to console
        list.printList();
    }

    //creates new ItemOrder from info stored in "itemOrder.txt" file
    public static void addFromFile(GroceryList list, Scanner input) {
        while (input.hasNextLine()) {
            //line in file gets put in String
            String line = input.nextLine();
            //String method "split" is used to seperate 'line' into tokens that are put into a String array
            String[] tokens = line.split(",");
            //new itemOrder is created with info in array
            new ItemOrder(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]), list);
        }
    }
}
