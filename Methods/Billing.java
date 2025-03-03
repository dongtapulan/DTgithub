/*
 * Huey P. Sumanting
 * BSIT I-A
 * 
 */
public class Billing {
    //First method: Compute bill for single books
    public static double computeBill(double price, int par1, double par2) {
        return price + (price * 0.08); // Add 8% tax
    }

    //Second Method: Compute bill for multiple photo books
    public static double computeBill(double price, int quantity) {
        double total = price * quantity;
        return total + (total * 0.08); // Add 8% tax
    }

    public static void main(String[] args) {
        // Testing all overloaded methods
        System.out.println("Total for one book: $" + computeBill(50.0, 3, 20.0));
        System.out.println("Total for multiple books: $" + computeBill(50.0, 3));
        System.out.println("Total with coupon discount: $" + computeBill(50.0, 3, 20.0));
    }
}
