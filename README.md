# Quiz System

A simple and interactive Java-based quiz system with a graphical user interface (GUI). This project allows users to log in with their name, select a subject, and take a quiz in topics such as Data Structures and Algorithms (DSA), Operating Systems (OS), or Java.

## Project Structure

- **Login.java**: Manages the login screen, takes the user’s name, and allows them to select a subject for the quiz.
- **QuestionBank.java**: Handles the storage and presentation of questions, options, and answers for different subjects.
- **QuickQuiz.java**: Acts as the entry point to the quiz system and coordinates the flow based on user-selected subjects.

## Features

- Login with name and subject selection.
- Interactive quizzes for DSA, OS, and Java.
- Real-time scoring and feedback at the end of each quiz.
- User-friendly GUI with intuitive navigation.

## Requirements

- **Java JDK 8** or higher.
- **Java Swing** (included with JDK).

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/ull0sm/QuickQuiz.git
cd QuickQuiz
```

### 2. Compile the Code

Compile all the `.java` files:
```bash
javac *.java
```

### 3. Run the Application

```bash
java Login
```

## Usage

1. **Login and Subject Selection**:
    - Enter your name in the login screen.
    - Select a subject (DSA, OS, or Java).
    - Click **Submit** to start the quiz.

2. **Take the Quiz**:
    - Read each question carefully.
    - Select your answer from the multiple-choice options.
    - Click **Next** to proceed to the next question.
    - At the end of the quiz, your score will be displayed.

## How It Works

1. **Login Process**:
   - `Login` class displays a GUI for user input and subject selection.
   - The selected subject is passed to the `QuickQuiz` class.

2. **Quiz Flow**:
   - `QuickQuiz` calls the appropriate subject quiz from `QuestionBank` (e.g., `DSAQB`, `OSQB`, or `JAVAQB`).
   - Questions are displayed one at a time with multiple-choice options.
   - User responses are validated, and the score is updated in real-time.

3. **Question Bank**:
   - `QuestionBank` contains predefined questions, options, and correct answers for each subject.

4. **Scoring and Feedback**:
   - At the end of the quiz, a dialog box shows the total score.

## Contribution

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m "Add new feature"`).
4. Push your branch (`git push origin feature-branch`).
5. Open a pull request.