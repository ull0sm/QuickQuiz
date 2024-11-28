import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class QuestionBank {
    static DataBase objdb = new DataBase();
    static Scanner sc = new Scanner(System.in);
    private int score = 0;
    private int questionIndex = 0;

    private final String[] questions = {
            "1. What is the time complexity of binary search?\n1. O(n)  2. O(log n)\n3. O(n^2)  4. O(1)",
            "2. Which data structure is used in Depth First Search (DFS)?\n1. Queue  2. Stack\n3. Array  4. Linked List",
            "3. What is the worst-case time complexity of QuickSort?\n1. O(n log n)  2. O(log n)\n3. O(n^2)  4. O(n)",
            "4. What does the acronym SQL stand for?\n1. Structured Query Language  2. Simple Query Language\n3. System Query Language  4. Synchronized Query Language",
            "5. Which sorting algorithm has the best average-case time complexity?\n1. Bubble Sort  2. Insertion Sort\n3. Merge Sort  4. Selection Sort"
    };

    private final int[] answers = {2, 2, 3, 1, 3}; // Correct answers for each question
    private JFrame frame;
    private JLabel questionLabel;
    private JButton[] optionButtons;

    public int DSAQB() {
        initializeFrame();
        return score; // Final score returned when the quiz ends
    }

    private void initializeFrame() {
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        questionLabel = new JLabel("<html>" + questions[questionIndex].replace("\n", "<br>") + "</html>");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(questionLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        optionButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            int choice = i + 1;
            optionButtons[i] = new JButton("Option " + choice);
            buttonPanel.add(optionButtons[i]);
            optionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAnswer(choice);
                }
            });
        }
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleAnswer(int choice) {
        if (choice == answers[questionIndex]) {
            score++;
        }

        questionIndex++;

        if (questionIndex < questions.length) {
            questionLabel.setText("<html>" + questions[questionIndex].replace("\n", "<br>") + "</html>");
        } else {
            JOptionPane.showMessageDialog(frame, "Quiz Over! Your score: " + score);
            frame.dispose();
        }
    }

    public static void JAVAQB() {
        System.out.println("Choose the correct answer:");
        System.out.println("1. Which method is used to start a thread in Java?");
        System.out.println("1. run()\t2. start()\n3. init()\t4. execute()");
        int choice = sc.nextInt();

        if(choice ==2){
            score ++;
        }
        
        System.out.println("2. Which keyword is used to inherit a class?");
        System.out.println("1. implements\t2. extends\n3. super\t4. this");
        choice = sc.nextInt();

        if(choice ==2){
            score ++;
        }
        
        System.out.println("3. What is the size of an int in Java?");
        System.out.println("1. 2 bytes\t2. 4 bytes\n3. 8 bytes\t4. Depends on OS");
        choice = sc.nextInt();

        if(choice ==3){
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
        if(choice ==2){
            score ++;
        }
        System.out.println("result:"+score);
        
    }

    public static void OSQB() {
        System.out.println("Choose the correct answer:");
        System.out.println("1. Which of the following is a non-preemptive scheduling algorithm?");
        System.out.println("1. SJF\t2. RR\n3. FCFS\t4. Priority");
        int choice = sc.nextInt();

        if(choice ==3){
            score ++;
        }
        
        System.out.println("2. What is a deadlock?");
        System.out.println("1. Infinite Loop\t2. Resource Wait\n3. Circular Wait\t4. Thrashing");
        choice = sc.nextInt();

        if(choice ==3){
            score ++;
        }
        
        System.out.println("3. Which scheduling algorithm is used by most OS?");
        System.out.println("1. FCFS\t2. Priority\n3. RR\t4. SJF");
        choice = sc.nextInt();

        if(choice ==3){
            score ++;
        }
        
        System.out.println("4. What is a virtual memory?");
        System.out.println("1. Memory on disk\t2. RAM Extension\n3. None of these\t4. OS Feature");
        choice = sc.nextInt();

        if(choice ==2){
            score ++;
        }
        
        System.out.println("5. Which of the following is not an OS?");
        System.out.println("1. Windows\t2. Linux\n3. Oracle\t4. MacOS");
        choice = sc.nextInt();
        if(choice ==3){
            score ++;
        }
        System.out.println("result:"+score);
        
    }

}