
public class method_oneExercise {

    public static double calculateCharges(double income, int consultingTime, double hourlyRate) {
        double charges = 0.0;

        if (income <= 25000) {
            if (consultingTime > 30) {
                charges = (consultingTime - 30) / 60.0 * hourlyRate * 0.4;
            }
        } 
        else 
        {
            if (consultingTime > 20) 
            {
                charges = (consultingTime - 20) / 60.0 * hourlyRate * 0.7;
            }
        }

        return charges;
    }

    public static void main(String[] args) {
        double income = 10000; // assuming I put example income
        int consultingTime = 50; // assuming I put consulting time in minutes
        double hourlyRate = 200; // assuming I put a value here

        double charges = calculateCharges(income, consultingTime, hourlyRate);
        System.out.println("Service charges: $" + charges);
    }
}
//Dili ko sure ani 