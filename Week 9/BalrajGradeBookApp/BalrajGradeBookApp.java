/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
 * The BalrajGradeBookApp class creates a GUI
 * application for managing student grades.
 */
public class BalrajGradeBookApp extends JFrame
{
    // Global variables
    private JTextField gUsernameField;
    private JPasswordField gPasswordField;

    private JTextField gFirstNameField;
    private JTextField gLastNameField;
    private JTextField gCourseField;

    private JComboBox<String> gGradeComboBox;

    private JButton gLoginButton;
    private JButton gSaveButton;
    private JButton gClearButton;
    private JButton gViewButton;

    private JTextArea gResultsArea;

    private CardLayout gCardLayout;
    private JPanel gMainPanel;

    /*
     * Constructor for the application.
     */
    public BalrajGradeBookApp()
    {
        setTitle("Grade Book Application");

        setSize(700, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        gCardLayout = new CardLayout();

        gMainPanel = new JPanel(gCardLayout);

        // Add panels
        gMainPanel.add(createLoginPanel(), "Login");

        gMainPanel.add(createGradeBookPanel(),
                "GradeBook");

        add(gMainPanel);

        // Show login screen
        gCardLayout.show(gMainPanel, "Login");

        setVisible(true);
    }

    /*
     * Creates the login panel.
     *
     * @return Login panel.
     */
    private JPanel createLoginPanel()
    {
        JPanel lPanel =
                new JPanel(new GridLayout(3, 2, 10, 10));

        lPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        100, 100, 100, 100));

        JLabel lUsernameLabel =
                new JLabel("Username:");

        JLabel lPasswordLabel =
                new JLabel("Password:");

        gUsernameField = new JTextField();

        gPasswordField = new JPasswordField();

        gLoginButton = new JButton("Login");

        lPanel.add(lUsernameLabel);
        lPanel.add(gUsernameField);

        lPanel.add(lPasswordLabel);
        lPanel.add(gPasswordField);

        lPanel.add(new JLabel());

        lPanel.add(gLoginButton);

        /*
         * Login button event.
         */
        gLoginButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(
                            ActionEvent event)
                    {
                        String lUsername =
                                gUsernameField.getText();

                        String lPassword =
                                new String(
                                        gPasswordField
                                                .getPassword());

                        // Validate login
                        if (lUsername.equals("admin")
                                && lPassword.equals(
                                "password"))
                        {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Login Successful!");

                            gCardLayout.show(
                                    gMainPanel,
                                    "GradeBook");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Invalid username or password.");
                        }
                    }
                });

        return lPanel;
    }

    /*
     * Creates the grade book panel.
     *
     * @return Grade book panel.
     */
    private JPanel createGradeBookPanel()
    {
        JPanel lPanel =
                new JPanel(new BorderLayout());

        JPanel lFormPanel =
                new JPanel(new GridLayout(
                        5, 2, 10, 10));

        lFormPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 20, 20, 20));

        // Labels
        JLabel lFirstNameLabel =
                new JLabel("First Name:");

        JLabel lLastNameLabel =
                new JLabel("Last Name:");

        JLabel lCourseLabel =
                new JLabel("Course:");

        JLabel lGradeLabel =
                new JLabel("Grade:");

        // Text fields
        gFirstNameField = new JTextField();

        gLastNameField = new JTextField();

        gCourseField = new JTextField();

        // ComboBox
        String[] lGrades =
                {"A", "B", "C", "D", "F"};

        gGradeComboBox =
                new JComboBox<>(lGrades);

        // Add components
        lFormPanel.add(lFirstNameLabel);
        lFormPanel.add(gFirstNameField);

        lFormPanel.add(lLastNameLabel);
        lFormPanel.add(gLastNameField);

        lFormPanel.add(lCourseLabel);
        lFormPanel.add(gCourseField);

        lFormPanel.add(lGradeLabel);
        lFormPanel.add(gGradeComboBox);

        // Buttons
        gSaveButton =
                new JButton("Save Grade");

        gClearButton =
                new JButton("Clear Form");

        gViewButton =
                new JButton("View Grades");

        JPanel lButtonPanel = new JPanel();

        lButtonPanel.add(gSaveButton);

        lButtonPanel.add(gClearButton);

        lButtonPanel.add(gViewButton);

        // Results area
        gResultsArea =
                new JTextArea(15, 50);

        gResultsArea.setEditable(false);

        JScrollPane lScrollPane =
                new JScrollPane(gResultsArea);

        // Add sections
        lPanel.add(lFormPanel, BorderLayout.NORTH);

        lPanel.add(lButtonPanel, BorderLayout.CENTER);

        lPanel.add(lScrollPane, BorderLayout.SOUTH);

        /*
         * Save button event.
         */
        gSaveButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(
                            ActionEvent event)
                    {
                        saveGrade();
                    }
                });

        /*
         * Clear button event.
         */
        gClearButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(
                            ActionEvent event)
                    {
                        clearForm();
                    }
                });

        /*
         * View button event.
         */
        gViewButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(
                            ActionEvent event)
                    {
                        viewGrades();
                    }
                });

        return lPanel;
    }

    /*
     * Saves a student grade to the CSV file.
     */
    private void saveGrade()
    {
        String lFirstName =
                gFirstNameField.getText().trim();

        String lLastName =
                gLastNameField.getText().trim();

        String lCourse =
                gCourseField.getText().trim();

        String lGrade =
                gGradeComboBox
                        .getSelectedItem()
                        .toString();

        // Validate fields
        if (lFirstName.isEmpty()
                || lLastName.isEmpty()
                || lCourse.isEmpty())
        {
            JOptionPane.showMessageDialog(
                    null,
                    "All fields are required.");

            return;
        }

        // Create student object
        Student lStudent =
                new Student(
                        lFirstName,
                        lLastName,
                        lCourse,
                        lGrade);

        File lFile =
                new File("grades.csv");

        try
        {
            boolean lFileExists =
                    lFile.exists();

            FileWriter lWriter =
                    new FileWriter(
                            lFile,
                            true);

            /*
             * Write CSV header row.
             */
            if (!lFileExists)
            {
                lWriter.write(
                        "firstName,lastName,course,grade\n");
            }

            /*
             * Write student data.
             */
            lWriter.write(
                    lStudent.getFirstName()
                            + ","
                            + lStudent.getLastName()
                            + ","
                            + lStudent.getCourse()
                            + ","
                            + lStudent.getGrade()
                            + "\n");

            lWriter.close();

            JOptionPane.showMessageDialog(
                    null,
                    "Grade saved successfully!");
        }
        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Error saving file.");
        }
    }

    /*
     * Displays saved grade entries.
     */
    private void viewGrades()
    {
        gResultsArea.setText("");

        File lFile =
                new File("grades.csv");

        if (!lFile.exists())
        {
            gResultsArea.setText(
                    "No grade records found.");

            return;
        }

        try
        {
            BufferedReader lReader =
                    new BufferedReader(
                            new FileReader(lFile));

            String lLine;

            // Skip header row
            lReader.readLine();

            while ((lLine =
                    lReader.readLine()) != null)
            {
                String[] lData =
                        lLine.split(",");

                Student lStudent =
                        new Student(
                                lData[0],
                                lData[1],
                                lData[2],
                                lData[3]);

                /*
                 * Uses Student toString method.
                 */
                gResultsArea.append(
                        lStudent.toString()
                                + "\n");
            }

            lReader.close();
        }
        catch (IOException exception)
        {
            gResultsArea.setText(
                    "Error reading file.");
        }
    }

    /*
     * Clears all form fields.
     */
    private void clearForm()
    {
        gFirstNameField.setText("");

        gLastNameField.setText("");

        gCourseField.setText("");

        gGradeComboBox.setSelectedIndex(0);
    }

    /*
     * Main method.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        new BalrajGradeBookApp();
    }
}