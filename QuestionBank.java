import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class QuestionBank {
    //static DataBase objdb = new DataBase();
    static Scanner sc = new Scanner(System.in);
    static int score = 0;

    private int questionIndex = 0;
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup buttonGroup;
    private String[] questions;
    private String[][] options;
    private int[] answers;

    public int DSAQB() {
        questions = new String[] {
                "1. What is the time complexity of binary search?",
                "2. Which data structure is used in Depth First Search (DFS)?",
                "3. What is the worst-case time complexity of QuickSort?",
                "4. What does the acronym SQL stand for?",
                "5. Which sorting algorithm has the best average-case time complexity?"
        };
        options = new String[][] {{"1.O(n)","O(log n)","O(n^2)","O(1)"},
                                    {"Queue","Stack","Array"," Linked List"},
                                    {"O(n log n)","O(log n)","O(n^2)","O(n)"},
                                    {"Structured Query Language","Simple Query Language","System Query Language"," Synchronized Query Language"},
                                    {"Bubble Sort","Insertion Sort","Merge Sort","Selection Sort"}};
        answers = new int[] {2, 2, 3, 1, 3};
        initializeFrame("Data Structures and Algorithms Quiz");
        return score;
    }

    public int JAVAQB() {
        questions = new String[] {
                "1. Which method is used to start a thread in Java?",
                "2. Which keyword is used to inherit a class?",
                "3. What is the size of an int in Java?",
                "4. Which of these is not a Java feature?",
                "5. What is the default value of a boolean variable?"
        };
        options = new String[][] {{"run()","start()","init()"," execute()"},
                                    {"implements","extends","super","this"},
                                    {"2 bytes","4 bytes","8 bytes","Depends on OS"},
                                    {"Object-Oriented","Platform-Independent"," Secure","Pointer-Based"},
                                    {"true","false"," 0","null"}};
        answers = new int[] {2, 2, 2, 4, 2};
        initializeFrame("Java Quiz");
        return score;
    }

    public int OSQB() {
        questions = new String[] {
                "1. Which of the following is a non-preemptive scheduling algorithm?",
                "2. What is a deadlock?",
                "3. Which scheduling algorithm is used by most OS?",
                "4. What is virtual memory?",
                "5. Which of the following is not an OS?"
        };
        options = new String[][] {{"SJF","RR","FCFS","Priority"},
                                    {"Infinite Loop","Resource Wait","Circular Wait","Thrashing"},
                                    {"FCFS","Priority","RR","SJF"},
                                    {"Memory on disk","RAM Extension","None of these","OS Feature"},
                                    {"Windows","Linux","Oracle","MacOS"}};
        answers = new int[] {3, 3, 3, 2, 3};
        initializeFrame("Operating Systems Quiz");
        return score;
    }

    private void initializeFrame(String quizTitle) {
        frame = new JFrame(quizTitle);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        questionLabel = new JLabel("<html>" + questions[questionIndex].replace("\n", "<br>") + "</html>");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(questionLabel, BorderLayout.CENTER);

        JPanel optionPanel = new JPanel(new GridLayout(4, 1, 10, 10)); // 4 rows for 4 options
        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            int choice = i + 1;
            for (int j = 0; j < 4; j++) {
                optionButtons[i] = new JRadioButton(options[i][j]);
            }
            buttonGroup.add(optionButtons[i]);
            optionPanel.add(optionButtons[i]);

            optionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAnswer(choice);
                }
            });
        }
        frame.add(optionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleAnswer(int choice) {
        if (choice == answers[questionIndex]) {
            score++;
        }

        questionIndex++;

        if (questionIndex < questions.length) {
            questionLabel.setText("<html>" + questions[questionIndex].replace("\n", "<br>") + "</html>");
            buttonGroup.clearSelection();
        } else {
            JOptionPane.showMessageDialog(frame, "Quiz Over! Your score: " + score);
            frame.dispose();
        }
    }
}