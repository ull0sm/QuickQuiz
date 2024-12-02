import java.awt.*;
import javax.swing.*;

public class Login {

    // Change the return type to String to return the selected subject
    public static String displayLogin() {
        JFrame frame = new JFrame("Quiz System Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Panel for organizing UI components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        // Username input
        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(20);
        panel.add(nameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nameField);

        // Subject selection
        JLabel subjectLabel = new JLabel("Select a subject:");
        JComboBox<String> subjectComboBox = new JComboBox<>(new String[]{"DSA", "OS", "JAVA"});
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(subjectLabel);
        panel.add(subjectComboBox);

        // Submit button
        JButton submitButton = new JButton("Submit");
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(submitButton);

        final String[] selectedSubject = {null};

        // Submit action listener
        submitButton.addActionListener(e -> {
            String username = nameField.getText().trim();
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                selectedSubject[0] = (String) subjectComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "Name: " + username + "\nSubject: " + selectedSubject[0]);
                frame.dispose();
            }
        });

        // Make the frame visible and modal
        frame.setVisible(true);

        // Block until the frame is closed
        while (selectedSubject[0] == null) {
            try {
                Thread.sleep(100);  // Short sleep to avoid busy waiting
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return selectedSubject[0];
    }

    public static void main(String[] args) {
        // Call the Login method and get the selected subject
        String selectedSubject = displayLogin();
        System.out.println("Selected subject: " + selectedSubject);

        // Pass the selected subject to the QuickQuiz class to start the corresponding quiz
        QuickQuiz.runQuiz(selectedSubject);
    }
}
