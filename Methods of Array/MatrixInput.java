//pg81
import java.util.Scanner;

public class MatrixInput {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rows = 3; // Example row size
        int cols = 3; // Example column size
        int[][] matrix = new int[rows][cols];

        // Input values into the matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.println("Enter value for matrix[" + row + "][" + col + "]: ");
                matrix[row][col] = console.nextInt();
            }
        }

        // Print the matrix to verify input
        System.out.println("Matrix values:");
        for (int row = 0; row < matrix.length; row++) 
        {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        console.close();
    }
}

/*
 * Matrix Dimensions: 
 * int rows = 3; and int cols = 3; set the dimensions of the matrix (you can change these values as needed).
Matrix Initialization: int[][] matrix = new int[rows][cols]; 
creates a 2D array with the specified dimensions.
Input Loop: The nested for loops iterate through each element of the matrix, prompting the user to enter a value for each position.

Print Loop: The nested for loops iterate through the matrix again to print the values, verifying the input.
 */