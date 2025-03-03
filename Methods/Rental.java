/*
 * Huey P. Sumanting
 * BSIT I-A
 * Activity no.1 Methods
 * Car Rental
 * calculates car rental costs using method overloading, 
 * applying discounts based on rental days and cars rented. 
 */
public class Rental {
    // Calculates rental cost based on the number of days rented
    public static double calculateRentalCost(int rentalDays) {
        double cost = 50.0 * rentalDays; // Base cost ($50 per day)

        // Apply 5% discount if rental period exceeds 7 days
        if (rentalDays > 7)
        {
            cost *= 0.95;
        }

        return cost;
    }

    // Calculate the rental cost based on the number of days and cars rented
   public static double calculateRentalCost(int rentalDays, int rentedCars) {
        double cost = (50.0 * rentalDays) * rentedCars; // Total cost for multiple cars

        // Apply 5% discount if rental period exceeds 7 days
        if (rentalDays > 7) 
        {
            cost *= 0.95;
        }

        return cost;
    }

    // Calculate the rental cost with an additional discount value applied
   public static double calculateRentalCost(int rentalDays, int rentedCars, int discountValue) {
        double cost = (50.0 * rentalDays) * rentedCars; // Base cost
        cost -= discountValue; // Apply fixed discount

        // Apply 5% discount if rental period exceeds 7 days
        if (rentalDays > 7)
         {
            cost *= 0.95;
        }

        return cost;
    }
    public static void main(String[] args) {
        // Renting for 8 days
        System.out.println("Test 1 (8 days): $" + calculateRentalCost(8));
        // 100 cars for 8 days
        System.out.println("Test 2 (8 days, 100 cars): $" + calculateRentalCost(8, 100));

        // 100 cars for 8 days with $50 discount
        System.out.println("Test 3 (8 days, 100 cars, $50 off): $" + calculateRentalCost(8, 100, 50));
    }
}
