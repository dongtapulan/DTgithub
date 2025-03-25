import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class PediatricMentalHealthConsultation {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pediatrics Professional Consultation with Mental Health Counseling");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to maximized by default
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);
        frame.setSize(600, 800);  // Default size if window is restored
        frame.setLocationRelativeTo(null);

        // Main panel with BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Label
        JLabel titleLabel = new JLabel("Pediatrics & Mental Health Consultation");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.DARK_GRAY);
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(20)); // Add space between title and content

        // ----------------- Student Information Section ------------------
        JPanel studentInfoPanel = new JPanel();
        studentInfoPanel.setLayout(new GridLayout(4, 2, 10, 10));
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        
        JTextField studentNameField = createInputField("Student's Name:");
        JTextField studentAgeField = createInputField("Student's Age:");
        JTextField schoolField = createInputField("School:");
        JTextField contactField = createInputField("Contact Number:");
        
        studentInfoPanel.add(studentNameField);
        studentInfoPanel.add(studentAgeField);
        studentInfoPanel.add(schoolField);
        studentInfoPanel.add(contactField);
        
        panel.add(studentInfoPanel);
        panel.add(Box.createVerticalStrut(20)); // Add space between sections

        // ----------------- Parent Information Section -------------------
        JPanel parentInfoPanel = new JPanel();
        parentInfoPanel.setLayout(new GridLayout(3, 2, 10, 10));
        parentInfoPanel.setBorder(BorderFactory.createTitledBorder("Parent Information"));

        JTextField parentNameField = createInputField("Parent's Name:");
        JTextField parentContactField = createInputField("Parent's Contact Number:");
        JTextField relationshipField = createInputField("Relationship to Student:");

        parentInfoPanel.add(parentNameField);
        parentInfoPanel.add(parentContactField);
        parentInfoPanel.add(relationshipField);

        panel.add(parentInfoPanel);
        panel.add(Box.createVerticalStrut(20));

        // ----------------- Preferred Consultation Time -------------------
        JPanel consultationTimePanel = new JPanel();
        consultationTimePanel.setLayout(new GridLayout(1, 2, 10, 10));
        consultationTimePanel.setBorder(BorderFactory.createTitledBorder("Preferred Consultation Time"));

        JTextField consultationTimeField = createInputField("Preferred Time:");

        consultationTimePanel.add(consultationTimeField);

        panel.add(consultationTimePanel);
        panel.add(Box.createVerticalStrut(20));

        // ----------------- Mental Health Concerns ----------------------
        JPanel mentalHealthPanel = new JPanel();
        mentalHealthPanel.setLayout(new GridLayout(1, 2, 10, 10));
        mentalHealthPanel.setBorder(BorderFactory.createTitledBorder("Mental Health Concerns"));

        JLabel mentalHealthLabel = new JLabel("Mental Health Concern:");
        String[] mentalHealthOptions = {"Anxiety", "Depression", "ADHD", "Stress", "Other"};
        JComboBox<String> mentalHealthComboBox = new JComboBox<>(mentalHealthOptions);

        mentalHealthPanel.add(mentalHealthLabel);
        mentalHealthPanel.add(mentalHealthComboBox);

        panel.add(mentalHealthPanel);
        panel.add(Box.createVerticalStrut(20));

        // ----------------- Symptom Checklist --------------------------
        JPanel symptomsPanel = new JPanel();
        symptomsPanel.setLayout(new GridLayout(5, 1, 5, 5));
        symptomsPanel.setBorder(BorderFactory.createTitledBorder("Symptoms"));

        JCheckBox headacheCheck = new JCheckBox("Headache");
        JCheckBox nauseaCheck = new JCheckBox("Nausea");
        JCheckBox sadnessCheck = new JCheckBox("Sadness");
        JCheckBox fatigueCheck = new JCheckBox("Fatigue");
        JCheckBox sleepDisturbanceCheck = new JCheckBox("Sleep Disturbance");

        symptomsPanel.add(headacheCheck);
        symptomsPanel.add(nauseaCheck);
        symptomsPanel.add(sadnessCheck);
        symptomsPanel.add(fatigueCheck);
        symptomsPanel.add(sleepDisturbanceCheck);

        panel.add(symptomsPanel);
        panel.add(Box.createVerticalStrut(20));

        // ----------------- Submit Button -----------------------------
        JButton submitButton = new JButton("Submit Consultation Request");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(Color.DARK_GRAY);
        submitButton.setForeground(Color.WHITE);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validate the fields
                if (studentNameField.getText().isEmpty() || studentAgeField.getText().isEmpty() || schoolField.getText().isEmpty() ||
                    contactField.getText().isEmpty() || parentNameField.getText().isEmpty() || parentContactField.getText().isEmpty() ||
                    relationshipField.getText().isEmpty() || consultationTimeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all the fields before submitting.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Collect symptoms
                StringBuilder symptomsBuilder = new StringBuilder();
                if (headacheCheck.isSelected()) symptomsBuilder.append("Headache, ");
                if (nauseaCheck.isSelected()) symptomsBuilder.append("Nausea, ");
                if (sadnessCheck.isSelected()) symptomsBuilder.append("Sadness, ");
                if (fatigueCheck.isSelected()) symptomsBuilder.append("Fatigue, ");
                if (sleepDisturbanceCheck.isSelected()) symptomsBuilder.append("Sleep Disturbance, ");
                
                String symptoms = symptomsBuilder.length() > 0 ? symptomsBuilder.substring(0, symptomsBuilder.length() - 2) : "No symptoms selected";

                // Display the input values in a dialog box
                String studentInfo = "Student Name: " + studentNameField.getText() + "\n" +
                                     "Age: " + studentAgeField.getText() + "\n" +
                                     "School: " + schoolField.getText() + "\n" +
                                     "Contact: " + contactField.getText() + "\n\n" +
                                     "Parent Name: " + parentNameField.getText() + "\n" +
                                     "Parent Contact: " + parentContactField.getText() + "\n" +
                                     "Relationship: " + relationshipField.getText() + "\n\n" +
                                     "Consultation Time: " + consultationTimeField.getText() + "\n" +
                                     "Mental Health Concern: " + mentalHealthComboBox.getSelectedItem().toString() + "\n" +
                                     "Symptoms: " + symptoms;

                JOptionPane.showMessageDialog(frame, "Consultation Request Submitted:\n\n" + studentInfo, 
                                              "Consultation Confirmation", JOptionPane.INFORMATION_MESSAGE);

                // Diagnose and provide recommendations
                diagnose(symptoms);
            }
        });

        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JTextField createInputField(String label) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.X_AXIS));
        fieldPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel fieldLabel = new JLabel(label);
        JTextField textField = new JTextField(20);
        fieldPanel.add(fieldLabel);
        fieldPanel.add(Box.createHorizontalStrut(10)); // Add some space between label and input field
        fieldPanel.add(textField);
        
        return textField;
    }

    private static void diagnose(String symptoms) {
        String diagnosisMessage = "";
        String homeRemedies = "";
        String citation = "Source: Healthline, Mayo Clinic.";

        if (symptoms.toLowerCase().contains("headache") && symptoms.toLowerCase().contains("nausea")) {
            diagnosisMessage = "You might be experiencing a migraine.";
            homeRemedies = "Rest in a dark, quiet room, hydrate, and avoid bright screens.";
        } else if (symptoms.toLowerCase().contains("sadness") && symptoms.toLowerCase().contains("fatigue")) {
            diagnosisMessage = "You may have symptoms of depression.";
            homeRemedies = "Talk to a counselor, engage in regular physical activity, and ensure adequate sleep.";
        } else {
            diagnosisMessage = "Symptoms are unclear. Please consult a professional.";
            homeRemedies = "Please consult a healthcare provider for a proper diagnosis.";
        }

        String resultMessage = diagnosisMessage + "\n\n" +
                               "Symptoms: " + symptoms + "\n\n" +
                               "Home Remedies: " + homeRemedies + "\n\n" +
                               citation;

        JOptionPane.showMessageDialog(null, resultMessage, "Diagnosis & Remedies", JOptionPane.INFORMATION_MESSAGE);
    }
}
