/*
 * Huey P. Sumanting
 * BSIT I-A
 * Activity no.3 Methods
 * FormLetterWriter
 * A Java program that accepts two overloaded methods to test in the main method
 */
public class FormLetterWriter {
    //First method: One String Parameter
    public static void displaySalutation(String lastName) {
        System.out.println("Dear Mr. or Ms. " + lastName + ",");
        System.out.println("Thank you for your recent order.\n");
    }
    //Second Method: Two string parameters
    public static void displaySalutation(String firstName, String lastName) {
        System.out.println("Dear " + firstName + " " + lastName + ",");
        System.out.println("Thank you for your recent order.\n");
    }
    //Main method
    public static void main(String[] args) {
        // Testing the methods
        displaySalutation("Sumanting");
        displaySalutation("Huey","Panulde");
    }
}
