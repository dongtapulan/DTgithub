
public class variables {
    public static void main(String[] args) {
       
        int age = 25;
        double gpa = 1.99;
        char grade = 'A';
        String name = "Huey Sumanting";
        boolean isStudent = true;
        
        System.out.println("I am " + name);
        System.out.println("I am " + age + " years old");
        System.out.println("My GPA is " + gpa );
        System.err.println("My grade is " + grade);
        System.err.println(isStudent);

        if (isStudent){
            System.err.println("I am a student");
        } else {
            System.out.print("not a student");
        }
    }
}
