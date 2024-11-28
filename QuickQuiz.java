import java.util.Scanner;

public class QuickQuiz {
    static Scanner sc = new Scanner(System.in);
    static QuestionBank objqb = new QuestionBank();

    // Accept the subject as an argument and run the corresponding quiz
    public static void runQuiz(String selectedSubject) {
        // Based on the selected subject, call the appropriate quiz method
        switch (selectedSubject) {
            case "DSA":
                System.out.println("Starting DSA quiz...");
                objqb.DSAQB();
                break;
            case "JAVA":
                System.out.println("Starting JAVA quiz...");
                objqb.JAVAQB();
                break;
            case "OS":
                System.out.println("Starting OS quiz...");
                objqb.OSQB();
                break;
            default:
                System.out.println("Invalid subject selected.");
                break;
        }
    }

    public static void main(String[] args) {
        
    }
}
