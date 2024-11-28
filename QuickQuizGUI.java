import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickQuizGUI {
    static QuestionBank objqb = new QuestionBank();
    static JFrame frame = new JFrame("QuickQuiz");
    static CardLayout cardLayout = new CardLayout();
    static JPanel mainPanel = new JPanel(cardLayout);

    public static void main(String[] args) {
        setupWelcomeScreen();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Welcome Screen
    private static void setupWelcomeScreen() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel titleLabel = new JLabel("Welcome to QuickQuiz", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomePanel.add(titleLabel);

        JTextField nameField = new JTextField("Enter your name");
        welcomePanel.add(nameField);

        // Drop-down for Subject Selection
        String[] subjects = {"DSA", "Java", "OS"};
        JComboBox<String> subjectDropdown = new JComboBox<>(subjects);
        welcomePanel.add(subjectDropdown);

        JButton startButton = new JButton("Start Quiz");
        startButton.addActionListener(e -> {
            String selectedSubject = (String) subjectDropdown.getSelectedItem();
            setupQuizScreen(selectedSubject, nameField.getText());
        });
        welcomePanel.add(startButton);

        mainPanel.add(welcomePanel, "Welcome");
        cardLayout.show(mainPanel, "Welcome");
    }

    // Quiz Screen
    private static void setupQuizScreen(String subject, String name) {
        JPanel quizPanel = new JPanel();
        quizPanel.setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        quizPanel.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(2, 2, 10, 10));
        quizPanel.add(optionsPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        quizPanel.add(nextButton, BorderLayout.SOUTH);

        // Load Questions
        String[][] questions;
        if (subject.equals("DSA")) {
            questions = objqb.getDSAQuestions();
        } else if (subject.equals("Java")) {
            questions = objqb.getJavaQuestions();
        } else {
            questions = objqb.getOSQuestions();
        }

        // Question Navigation Logic
        final int[] currentQuestion = {0};
        loadQuestion(questions, currentQuestion, questionLabel, optionsPanel, nextButton);

        nextButton.addActionListener(e -> {
            currentQuestion[0]++;
            if (currentQuestion[0] < questions.length) {
                loadQuestion(questions, currentQuestion, questionLabel, optionsPanel, nextButton);
            } else {
                showResultScreen(name);
            }
        });

        mainPanel.add(quizPanel, "Quiz");
        cardLayout.show(mainPanel, "Quiz");
    }

    // Load Question
    private static void loadQuestion(String[][] questions, int[] currentQuestion, JLabel questionLabel, JPanel optionsPanel, JButton nextButton) {
        String[] question = questions[currentQuestion[0]];
        questionLabel.setText((currentQuestion[0] + 1) + ". " + question[0]);
        optionsPanel.removeAll();

        ButtonGroup group = new ButtonGroup();
        for (int i = 1; i < question.length; i++) {
            JRadioButton optionButton = new JRadioButton(question[i]);
            group.add(optionButton);
            optionsPanel.add(optionButton);
        }

        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    // Result Screen
    private static void showResultScreen(String name) {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        JLabel resultLabel = new JLabel("Thank you, " + name + "! Quiz Completed!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));
        resultPanel.add(restartButton, BorderLayout.SOUTH);

        mainPanel.add(resultPanel, "Result");
        cardLayout.show(mainPanel, "Result");
    }
}

// QuestionBank Class
class QuestionBank {
    public String[][] getDSAQuestions() {
        return new String[][]{
            {"What is the time complexity of binary search?", "O(n)", "O(log n)", "O(n^2)", "O(1)"},
        };
    }

    public String[][] getJavaQuestions() {
        return new String[][]{
            {"Which method is used to start a thread in Java?", "run()", "start()", "init()", "execute()"},
            {"Which keyword is used to inherit a class?", "implements", "extends", "super", "this"},
            {"What is the size of an int in Java?", "2 bytes", "4 bytes", "8 bytes", "Depends on OS"},
            {"Which of these is not a Java feature?", "Object-Oriented", "Platform-Independent", "Secure", "Pointer-Based"},
            {"What is the default value of a boolean variable?", "true", "false", "0", "null"},
        };
    }

    public String[][] getOSQuestions() {
        return new String[][]{
            {"Which of the following is a non-preemptive scheduling algorithm?", "SJF", "RR", "FCFS", "Priority"},
            {"What is a deadlock?", "Infinite Loop", "Resource Wait", "Circular Wait", "Thrashing"},
            {"Which scheduling algorithm is used by most OS?", "FCFS", "Priority", "RR", "SJF"},
            {"What is a virtual memory?", "Memory on disk", "RAM Extension", "None of these", "OS Feature"},
            {"Which of the following is not an OS?", "Windows", "Linux", "Oracle", "MacOS"},
        };
    }
}