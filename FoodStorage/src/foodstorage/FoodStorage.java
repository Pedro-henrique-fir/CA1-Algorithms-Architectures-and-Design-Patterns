/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foodstorage;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class FoodStorage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myKB = new Scanner(System.in);
        
        
        System.out.println(" =-=-=-= Food Storage =-=-=-= ");
        
        while (true){
            System.out.println("\n ======= Menu ======= ");
            
            System.out.println("1 - Add food item");
            System.out.println("2 - Remove food item");
            System.out.println("3 - Show first item");
            System.out.println("4 - Show all items");
            System.out.println("5 - Search item");
            System.out.println("6 - Exit");
            
            System.out.print("Choose an option (1-6): ");

            String option = myKB.nextLine().trim();
            
            switch (option) {
                case "1":
                    System.out.println("1");
                    break;
                                        
                case "2":
                    System.out.println("2");
                    break;
                    
                case "3":
                    System.out.println("3");
                    break;
                    
                case "4":
                    System.out.println("4");
                    break;
                    
                case "5":
                    System.out.println("5");
                    break;
                    
                case "6":
                    System.out.println("Exit");
                    return;
                    
                default:
                    System.out.println("Invalid option. Please choose a oprion from 1 to 6.");
                    
            }
        }
    }
    
}
