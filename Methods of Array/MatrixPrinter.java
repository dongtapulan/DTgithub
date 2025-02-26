//pg.84
import java.util.Scanner;

public class MatrixPrinter {

    // Method to print the matrix
    static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%7d", matrix[row][col]);
            }
            System.err.println();
        }
    }

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

        // Print the matrix
        System.out.println("Matrix values:");
        printMatrix(matrix);

        console.close();
    }
}
