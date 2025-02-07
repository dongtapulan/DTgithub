import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        // Create a Scanner object to read input
       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter your name:");
       String name = scanner.nextLine();

       System.out.println("Enter your age:");
       int age = scanner.nextInt();

       //OUTPUT
       System.out.println("Hello " + name + ", you are " + age + " years old.");

       scanner.close();
    }
}
