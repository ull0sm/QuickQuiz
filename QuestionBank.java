import java.util.Scanner;

class QuestionBank {
    static DataBase objdb = new DataBase();
    static Scanner sc = new Scanner(System.in);
    static int score = 0;
    public static void DSAQB() {
        System.out.println("Choose the correct answer:");
        System.out.println("1. What is the time complexity of binary search?");
        System.out.println("1. O(n)\t2. O(log n)\n3. O(n^2)\t4. O(1)");
        int choice = sc.nextInt();
        if(choice ==1){
            score ++;
        }
        System.out.println("result:"+score);
        
    }

    public static void JAVAQB() {
        System.out.println("Choose the correct answer:");
        System.out.println("1. Which method is used to start a thread in Java?");
        System.out.println("1. run()\t2. start()\n3. init()\t4. execute()");
        int choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("2. Which keyword is used to inherit a class?");
        System.out.println("1. implements\t2. extends\n3. super\t4. this");
        choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("3. What is the size of an int in Java?");
        System.out.println("1. 2 bytes\t2. 4 bytes\n3. 8 bytes\t4. Depends on OS");
        choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("4. Which of these is not a Java feature?");
        System.out.println("1. Object-Oriented\t2. Platform-Independent\n3. Secure\t4. Pointer-Based");
        choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("5. What is the default value of a boolean variable?");
        System.out.println("1. true\t2. false\n3. 0\t4. null");
        choice = sc.nextInt();
        if(choice ==1){
            score ++;
        }
        System.out.println("result:"+score);
        
    }

    public static void OSQB() {
        System.out.println("Choose the correct answer:");
        System.out.println("1. Which of the following is a non-preemptive scheduling algorithm?");
        System.out.println("1. SJF\t2. RR\n3. FCFS\t4. Priority");
        int choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("2. What is a deadlock?");
        System.out.println("1. Infinite Loop\t2. Resource Wait\n3. Circular Wait\t4. Thrashing");
        choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("3. Which scheduling algorithm is used by most OS?");
        System.out.println("1. FCFS\t2. Priority\n3. RR\t4. SJF");
        choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("4. What is a virtual memory?");
        System.out.println("1. Memory on disk\t2. RAM Extension\n3. None of these\t4. OS Feature");
        choice = sc.nextInt();

        if(choice ==1){
            score ++;
        }
        
        System.out.println("5. Which of the following is not an OS?");
        System.out.println("1. Windows\t2. Linux\n3. Oracle\t4. MacOS");
        choice = sc.nextInt();
        if(choice ==1){
            score ++;
        }
        System.out.println("result:"+score);
        
    }

}