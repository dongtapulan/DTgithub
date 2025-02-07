/*
 * 
 * ACT#3
 * 3 DIGIT EXTRACTING PROGRAM
 * Author: Huey Sumanting BSIT I A1
 */

import javax.swing.JOptionPane;

public class javaact3 {
    public static void main(String[] args) {
        // Prompt the user to enter a 3-digit number
        String input = JOptionPane.showInputDialog("Enter a 3-digit number:");
        
        // input string
        int number = Integer.parseInt(input);
        
        //Extract first second and third digit
        int firstDigit = number / 100;
        int middleDigit = (number / 10) % 10;
        int lastDigit = number % 10;
        
        // Display the results using JOptionPane
        String message = "The first digit of " + number + " is: " + firstDigit + "\n" +
                         "The middle digit of " + number + " is: " + middleDigit + "\n" +
                         "The tail digit of " + number + " is: " + lastDigit;
        
        JOptionPane.showMessageDialog(null, message);
    }
}