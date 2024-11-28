import java.awt.*;
import javax.swing.*;

public class Login {

    // Change the return type to String to return the selected subject
    public static String Login() {
        JFrame frame = new JFrame("Quiz System Login");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  

        JLabel usernameLabel = new JLabel("Enter your name:");
        JTextField usernameField = new JTextField(20);
        panel.add(usernameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));  
        panel.add(usernameField);

        JLabel subjectLabel = new JLabel("Select Subjects:");
        panel.add(Box.createRigidArea(new Dimension(0, 10)));  
        panel.add(subjectLabel);
        JComboBox<String> subjectComboBox = new JComboBox<>(new String[]{"DSA", "OS", "JAVA"});
        panel.add(subjectComboBox);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));  
        JButton submitButton = new JButton("Submit");

        // Variable to store the selected subject
        final String[] selectedSubject = new String[1];

        submitButton.addActionListener(e -> {
            String username = usernameField.getText();
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Get the selected subject
                selectedSubject[0] = (String) subjectComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "Name: " + username + "\nSubjects: " + selectedSubject[0]);

                // Close the frame
                frame.dispose();
            }
        });

        panel.add(submitButton);
        frame.add(panel);
        frame.setVisible(true);

        // Wait until the user selects a subject and closes the dialog
        while (selectedSubject[0] == null) {
            try {
                Thread.sleep(100);  // Sleep for a short period to check for user selection
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return selectedSubject[0]; // Return the selected subject
    }

    public static void main(String[] args) {
        // Call the Login method and get the selected subject
        String selectedSubject = Login();
        System.out.println("Selected subject: " + selectedSubject);

        // Pass the selected subject to the QuickQuiz class to start the corresponding quiz
        QuickQuiz.runQuiz(selectedSubject);
    }
}
