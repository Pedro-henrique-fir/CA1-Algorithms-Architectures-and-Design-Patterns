/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foodstorage;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 *
 * @author mac
 */
public class FoodStorage {
    
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Scanner myKB = new Scanner(System.in);
        CircularFoodQueue storage = new CircularFoodQueue(8);
        
        
        System.out.println(" =-=-=-= Food Storage =-=-=-= ");
        
        //Menu
        while (true){
            System.out.println("\n ======= Menu ======= ");
            
            System.out.println("1 - Add food item");
            System.out.println("2 - Remove food item");
            System.out.println("3 - Show first item");
            System.out.println("4 - Show all items");
            System.out.println("5 - Search item");
            System.out.println("6 - Exit");
            
            
            //System.out.println(storage.size());
            
            System.out.print("Choose an option (1-6): ");

            String option = myKB.nextLine().trim();
            
            switch (option) {
                case "1":
                    
                    addItem(myKB, storage);
                    break;
                                        
                case "2":
                    removeFood(storage);
                    break;
                    
                case "3":
                    showFirstItem(storage);
                    break;
                    
                case "4":
                    showAllItems(storage);
                    break;
                    
                case "5":
                    searchFood(myKB, storage);
                    break;
                    
                case "6":
                    System.out.println("Exit");
                    return;
                    
                default:
                    System.out.println("Invalid option. Please choose a option from 1 to 6.");
                    
            }
        }
    }
    
    //asks for the details and adds it to the storage
    private static void addItem(Scanner myKB, CircularFoodQueue storage) {
        if (storage.isFull()) {
            System.out.println("Storage is full");
            return;
        }

        FoodType type = checkFoodType(myKB);
        int weight = checkWeight(myKB);
        LocalDate bestBefore = checkBestBefore(myKB);

        FoodItem item = new FoodItem(type, weight, bestBefore);
        storage.enqueue(item);

        System.out.println("Added: " + item);

    }
    
    //asks for the food name until it is one of the 5 types
    private static FoodType checkFoodType(Scanner myKB) {
        while (true) {
            
            System.out.println(
                    "Food Menu:"
                    + "\n   Burger"
                    + "\n   Pizza"
                    + "\n   Fries"
                    + "\n   Sandwich"
                    + "\n   Hotdog"
                + "\n=-=-=-=-=-=-=-=-="
        );
            
            System.out.print("Food name: ");
            
            String input = myKB.nextLine().trim().toUpperCase();
            try {
                return FoodType.valueOf(input);
                
            } catch (IllegalArgumentException e) {
                System.out.println("\n Invalid food name  \n");
                
            }
        }
    }
    
    //asks for the weight until it is a number greater than 0
    private static int checkWeight(Scanner myKB) {
        while (true) {
            System.out.print("Weight in grams: ");
            try {
                    
                int weight = Integer.parseInt(myKB.nextLine().trim());
                
                if (weight > 0) {
                    return weight;
                    
                } else {
                    System.out.println("\n Invalid weight \n");
                    
                }
                
            } catch (NumberFormatException e) {
                System.out.println("\n Invalid number \n");
                
            }
                                  
        }
    }
    
    //asks for the best before date until it is valid, not expired and at most 14 days from today
    private static LocalDate checkBestBefore(Scanner sc) {
        LocalDate today = LocalDate.now();
        LocalDate maxDate = today.plusDays(14);

        while (true) {
            System.out.print("Best before date (dd/MM/yyyy): ");
            
            try {
                LocalDate bestBefore = LocalDate.parse(sc.nextLine().trim(), dateFormat);
                
                if (bestBefore.isBefore(today)) {
                    System.out.println("This food has expired");
                    
                } else if (bestBefore.isAfter(maxDate)){
                    
                    System.out.println("\n Best before date can be at most 14 days from today (" + maxDate.format(dateFormat) + "). \n");
  
                } else {
                    return bestBefore;
                    
                }
                
            } catch (DateTimeParseException e) {
                System.out.println("\n Use the format dd/MM/yyyy. \n");
            }
            
        }
    }
    
    //removes the oldest food
    private static void removeFood(CircularFoodQueue storage) {
        
        if(storage.isEmpty()) {
            System.out.println("Storage is empty");
            return;
        }

        FoodItem item = storage.dequeue();
        System.out.println("Removed: " + item);
        
    }
    
    //show the oldest food
    private static void showFirstItem(CircularFoodQueue storage) {

        if (storage.isEmpty()) {
            System.out.println("Storage is empty");
            return;
        }

        FoodItem item = storage.peek();

        System.out.println("First item: " + item);
    }
    
    //shows all the foods in the storage
    private static void showAllItems(CircularFoodQueue storage) {
        storage.displayAll();
        
    }  
   
    
    //shows all the food type that the user chooses
    private static void searchFood(Scanner myKB, CircularFoodQueue storage) {
        if (storage.isEmpty()) {
            System.out.println("Storage is empty");
            return;
        }

        System.out.println("\n===== Search Food Item =====");

        FoodType type = checkFoodType(myKB);

        FoodItem[] items = storage.search(type);

        if (items[0] == null) {
            System.out.println("No " + type + " found in the storage.");
            return;
            
        }

        for (FoodItem item : items) {
            if(item != null){
                System.out.println("Food item found: " + item);
            }
            
        }
    }
}
