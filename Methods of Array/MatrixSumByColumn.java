import java.util.Scanner;

public class MatrixSumByColumn {

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

        // Calculate and print the sum of each column
        for (int col = 0; col < matrix[0].length; col++) {
            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            System.out.println("Sum of column " + (col + 1) + " = " + sum);
        }

        console.close();
    }
}
