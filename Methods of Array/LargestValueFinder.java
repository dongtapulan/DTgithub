//pg.57
public class LargestValueFinder {

    // Method to find the largest value in a list of doubles
    public static double largest(double ... list) {
        double max = 0.0;
        int arraySize = list.length;

        if (arraySize != 0) {
            for (int i = 0; i < arraySize; i++) {
                if (max < list[i]) {
                    max = list[i];
                }
            }
        }
        return max;
    }

    // Main method to test the 'largest' method
    public static void main(String[] args) {
        double[] values = {3.5, 7.2, 1.8, 9.3, 6.4};
        double maxValue = largest(values);
        System.out.println("The largest value is: " + maxValue);
    }
}
