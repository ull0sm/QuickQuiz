import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionBank {
    static DataBase objdb = new DataBase();
    static Scanner sc = new Scanner(System.in);
    static int score = 0;

    private int questionIndex = 0;
    private JFrame frame;
    private JLabel questionLabel;
    private JButton[] optionButtons;
    private String[] questions;
    private int[] answers;

    public int DSAQB() {
        questions = new String[] {
            "1. What is the time complexity of binary search?\n1. O(n)  2. O(log n)\n3. O(n^2)  4. O(1)",
            "2. Which data structure is used in Depth First Search (DFS)?\n1. Queue  2. Stack\n3. Array  4. Linked List",
            "3. What is the worst-case time complexity of QuickSort?\n1. O(n log n)  2. O(log n)\n3. O(n^2)  4. O(n)",
            "4. What does the acronym SQL stand for?\n1. Structured Query Language  2. Simple Query Language\n3. System Query Language  4. Synchronized Query Language",
            "5. Which sorting algorithm has the best average-case time complexity?\n1. Bubble Sort  2. Insertion Sort\n3. Merge Sort  4. Selection Sort"
        };
        answers = new int[] {2, 2, 3, 1, 3};
        initializeFrame("Data Structures and Algorithms Quiz");
        return score;
    }

    public int JAVAQB() {
        questions = new String[] {
            "1. Which method is used to start a thread in Java?\n1. run()  2. start()\n3. init()  4. execute()",
            "2. Which keyword is used to inherit a class?\n1. implements  2. extends\n3. super  4. this",
            "3. What is the size of an int in Java?\n1. 2 bytes  2. 4 bytes\n3. 8 bytes  4. Depends on OS",
            "4. Which of these is not a Java feature?\n1. Object-Oriented  2. Platform-Independent\n3. Secure  4. Pointer-Based",
            "5. What is the default value of a boolean variable?\n1. true  2. false\n3. 0  4. null"
        };
        answers = new int[] {2, 2, 2, 4, 2};
        initializeFrame("Java Quiz");
        return score;
    }

    public int OSQB() {
        questions = new String[] {
            "1. Which of the following is a non-preemptive scheduling algorithm?\n1. SJF  2. RR\n3. FCFS  4. Priority",
            "2. What is a deadlock?\n1. Infinite Loop  2. Resource Wait\n3. Circular Wait  4. Thrashing",
            "3. Which scheduling algorithm is used by most OS?\n1. FCFS  2. Priority\n3. RR  4. SJF",
            "4. What is virtual memory?\n1. Memory on disk  2. RAM Extension\n3. None of these  4. OS Feature",
            "5. Which of the following is not an OS?\n1. Windows  2. Linux\n3. Oracle  4. MacOS"
        };
        answers = new int[] {3, 3, 3, 2, 3};
        initializeFrame("Operating Systems Quiz");
        return score;
    }

    private void initializeFrame(String quizTitle) {
        frame = new JFrame(quizTitle);
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
}