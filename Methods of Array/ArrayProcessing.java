//pg.44
public class ArrayProcessing {
    // Method to sum all elements in an array
    public static int sumArray(int[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum;
    }

    // Method to find the index of the largest element in an array
    public static int indexLargestElement(int[] list) {
        int maxIndex = 0;
        for (int i = 1; i < list.length; i++) { // Start from 1 since maxIndex is 0
            if (list[maxIndex] < list[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Main method to test the methods
    public static void main(String[] args) {
        int[] numbers = {5, 8, 12, 3, 7, 15, 9}; // Sample array

        // Call sumArray method
        int totalSum = sumArray(numbers);
        System.out.println("Sum of array elements: " + totalSum);

        // Call indexLargestElement method
        int maxIndex = indexLargestElement(numbers);
        System.out.println("Index of the largest element: " + maxIndex);
        System.out.println("Largest element: " + numbers[maxIndex]);
    }
}

/*
 * Code Explanation:
sumArray(int[] list)

This method calculates the sum of all elements in an integer array.
It initializes sum to 0.
Uses a for loop to iterate through each element of the array, adding it to sum.
Returns the final sum.
indexLargestElement(int[] list)

This method finds the index of the largest element in the given array.
It initializes maxIndex to 0 (assuming the first element is the largest).
Iterates through the array, updating maxIndex whenever it finds a larger value.
Returns the index of the largest element.
 */