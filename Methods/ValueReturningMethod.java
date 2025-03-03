public class ValueReturningMethod {
    // Method that returns the sum of two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(5, 10);
        System.out.println("Sum: " + result);
    }
}
