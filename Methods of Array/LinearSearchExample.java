//PG.47
public class LinearSearchExample {
    public static void main(String[] args) {
        int[] list = {35, 12, 27, 18, 45, 16, 38}; // Array of elements
        int target = 27; // The number we are searching for

        int index = linearSearch(list, target);

        if (index != -1) {
            System.out.println("Number " + target + " found at index " + index);
        } else {
            System.out.println("Number " + target + " not found in the array.");
        }
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) { // If target is found
                return i; // Return the index
            }
        }
        return -1; // If not found, return -1
    }
}
/* 
how the Code Works:
The method linearSearch() iterates through each element in the array.
It checks if the current element matches the target value (27).
If a match is found, it returns the index of that element.
If no match is found, it returns -1, indicating the value is not in the array.*/ 