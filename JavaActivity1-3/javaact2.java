/*
 *
 * ACT#2
 * Java program that adds 5 integers and round them and get the average
 * Author: Huey Sumanting BSIT I A1
 */

 import javax.swing.JOptionPane;

 public class javaact2 {
     public static void main(String[] args) {
         // Declaration of integer double variables
         double num1, num2, num3, num4, num5;
 
         // User input
         num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter decimal number 1:"));
         num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter decimal number 2:"));
         num3 = Double.parseDouble(JOptionPane.showInputDialog("Enter decimal number 3:"));
         num4 = Double.parseDouble(JOptionPane.showInputDialog("Enter decimal number 4:"));
         num5 = Double.parseDouble(JOptionPane.showInputDialog("Enter decimal number 5:"));
 
         // Print the five decimal numbers
         String decimalOutput = "The five decimal numbers are:\n" +
                 num1 + "\n" + num2 + "\n" + num3 + "\n" + num4 + "\n" + num5;
         JOptionPane.showMessageDialog(null, decimalOutput);
 
         // Round each decimal number to the nearest integer by adding 0.5 and casting to int
         int rounded1 = (int) (num1 + 0.5);
         int rounded2 = (int) (num2 + 0.5);
         int rounded3 = (int) (num3 + 0.5);
         int rounded4 = (int) (num4 + 0.5);
         int rounded5 = (int) (num5 + 0.5);
 
         // Calculate the sum of the rounded integers
         int sum = rounded1 + rounded2 + rounded3 + rounded4 + rounded5;
 
         // Calculate the average of the rounded integers
         double average = (double) sum / 5;
 
         // Display the rounded integers, sum, and average
         String resultMessage = "Rounded integers:\n" +
                 rounded1 + "\n" + rounded2 + "\n" + rounded3 + "\n" + rounded4 + "\n" + rounded5 + "\n\n" +
                 "The sum of the rounded integers is: " + sum + "\n" +
                 "The average of the rounded integers is: " + average;
 
         JOptionPane.showMessageDialog(null, resultMessage);
     }
 }
 