import java.util.Scanner;

public class QuickQuiz {
    static Scanner sc = new Scanner(System.in);
    static QuestionBank objqb = new QuestionBank();
    public static void main(String[] args) {
        System.out.print("=================================================");
        System.out.println("\n\nQuickQuiz");
        System.out.print("enter your name:");
        String Name = sc.next();
        System.out.println("Enter the subject:");
        System.out.print("\t1.DSA\n\t2.Java\n\t3.OS\nchoice:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                objqb.DSAQB();
                break;
            case 2:
                objqb.JAVAQB();
                break;
            case 3:
                objqb.OSQB();
                break;
        
            default:
                break;
        }
        System.out.println("=================================================");
    }
}