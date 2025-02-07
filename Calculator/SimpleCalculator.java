import javax.swing.JOptionPane;

public class SimpleCalculator {
    public static void main(String[] args) {
        // Get first number input
        String input1 = JOptionPane.showInputDialog("Enter the first number:");
        double num1 = Double.parseDouble(input1);

        // Get second number input
        String input2 = JOptionPane.showInputDialog("Enter the second number:");
        double num2 = Double.parseDouble(input2);

        // Choose operation
        String[] options = { "Addition", "Subtraction", "Multiplication", "Division" };
        int choice = JOptionPane.showOptionDialog(null, "Choose an operation:", "Calculator",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        double result = 0;
        String operation = "";

        // Perform the chosen operation
        switch (choice) {
            case 0:
                result = num1 + num2;
                operation = "Addition";
                break;
            case 1:
                result = num1 - num2;
                operation = "Subtraction";
                break;
            case 2:
                result = num1 * num2;
                operation = "Multiplication";
                break;
            case 3:
                if (num2 != 0) 
                {
                    result = num1 / num2;
                    operation = "Division";
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "No operation selected. Exiting...", "Calculator", JOptionPane.WARNING_MESSAGE);
                return;
        }

        // Display result
        JOptionPane.showMessageDialog(null, "Operation: " + operation + "\nResult: " + result, "Calculator", JOptionPane.INFORMATION_MESSAGE);
    }
}
