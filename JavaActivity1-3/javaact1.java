/*
 * 
 * ACTIVITY 1.1
 * A PROGRAM THAT CALCULATES AVERAGES OF SCORES IN ACTIVITIES IN THE COURSE.
 * Author: Huey Sumanting BSIT I-A1
 */

import javax.swing.JOptionPane;
/*
         * 1.Calculate a student’s average score for a course with 4 quizzes, 2 midterms and 1 final. The quizzes are
            weighted 30%, the midterms 40% and the final 30%.
         */
public class javaact1 {
    public static void main(String[] args) {
        // Variable declarations
        //for quiz scores
        int quiz1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the score for the first quiz:"));
        int quiz2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the score for the second quiz:"));
        int quiz3 = Integer.parseInt(JOptionPane.showInputDialog("Enter the score for the third quiz:"));
        int quiz4 = Integer.parseInt(JOptionPane.showInputDialog("Enter the score for the fourth quiz:"));
        
        // for midterm scores
        int midterm1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the score for the first midterm:"));
        int midterm2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the score for the second midterm:"));
        
        //final exam scores
        int finalExam = Integer.parseInt(JOptionPane.showInputDialog("Enter the score for the final:"));
        
        // Calculate the  total scores
        int quizTotal = quiz1 + quiz2 + quiz3 + quiz4;
        int midtermTotal = midterm1 + midterm2;
        int finalTotal = finalExam;
        
        // calculate the percentage
        double quizWeighted = (quizTotal / 400.0) * 30;
        double midtermWeighted = (midtermTotal / 200.0) * 40;
        double finalWeighted = (finalTotal / 100.0) * 30;
        double totalScore = quizWeighted + midtermWeighted + finalWeighted;
        
        // Display output
        String output = "Results:\n" +
                        "QUIZZES \n" +
                        "First Quiz: " + quiz1 + "\n" +
                        "Second Quiz: " + quiz2 + "\n" +
                        "Third Quiz: " + quiz3 + "\n" +
                        "Fourth Quiz: " + quiz4 + "\n" +

                        "Quiz Total: " + quizTotal + "\n\n" +
                        "MIDTERM\n" +
                        "First Midterm: " + midterm1 + "\n" +
                        "Second Midterm: " + midterm2 + "\n" +

                        "Total Midterms: " + midtermTotal + "\n\n" +
                        "FINAL\n" +
                        "Final: " + finalExam + "\n\n" +
                        "Quiz: " + String.format("%.1f", quizWeighted) + "%\n" +
                        "Midterm: " + String.format("%.1f", midtermWeighted) + "%\n" +
                        "Final: " + String.format("%.1f", finalWeighted) + "%\n\n" +
                        "Total: " + String.format("%.1f", totalScore) + "%";
        
        JOptionPane.showMessageDialog(null, output);
    }
}
