import javax.swing.JOptionPane;

public class JavaPrelim {
    public static void main(String[] args) {
        String movie_name = JOptionPane.showInputDialog("Enter the Movie name:");
        int ticket_num = Integer.parseInt (JOptionPane.showInputDialog("Enter the ticket number:"));
        double gross_amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the ticket number:"));
        double percentage = Double.parseDouble(JOptionPane.showInputDialog("Percentage of the gross amount number:"));

        double amount_donated = gross_amount * (percentage / 100);
        double netsales = gross_amount - amount_donated;        


        String result = "Movie Name: " + movie_name + "\n" +
        "Number of Tickets Sold: " + ticket_num + "\n" +
        "Gross Amount:" +  "$" + gross_amount + "\n" +
        "Percentage of the Gross Amount Donated:" + amount_donated + "\n" +
        "Amount Donated:" + "$" + amount_donated + "\n" + 
        "Net Sale: " + "$" + netsales + "\n" ;

        JOptionPane.showMessageDialog(null, result,"TheaterSalesData",JOptionPane.INFORMATION_MESSAGE);
    }
}