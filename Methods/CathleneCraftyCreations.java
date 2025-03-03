/*
 * Huey P. Sumanting
 * BSIT I-A
 * Activity No.2
 * Crafty Creations:
 * A Java program takes user input for a product name, cost of materials, and hours of work required. 
 */
 
 import java.util.Scanner;

public class CathleneCraftyCreations {
    //Method to compute the retail price
    public static double computeRetailPrice(double costOfMaterials, int hoursOfWork){
        return costOfMaterials + (12 * hoursOfWork) + 7;
    }
    //Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter the cost of materials: ");
        double costOfMaterials = scanner.nextDouble();
        
        System.out.print("Enter the number of hours of work required: ");
        int hoursOfWork = scanner.nextInt();
        
        // Compute the retail price with the formula in the method
        double retailPrice = computeRetailPrice(costOfMaterials, hoursOfWork);
        
        System.out.println("Product: " + productName);
        System.out.println("Retail Price: $" + retailPrice);
        
        scanner.close();
    }
}