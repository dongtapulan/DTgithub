import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Patient {
    String name, age, gender, diagnosis;

    public Patient(String name, String age, String gender, String diagnosis) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Diagnosis: " + diagnosis;
    }
}

public class MedicalGUI extends JFrame {
    private ArrayList<Patient> patients = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> patientList = new JList<>(listModel);

    public MedicalGUI() {
        setTitle("Medical Record System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField diagnosisField = new JTextField();
        
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Gender:"));
        inputPanel.add(genderField);
        inputPanel.add(new JLabel("Diagnosis:"));
        inputPanel.add(diagnosisField);
        
        // Creating button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Patient");
        JButton removeButton = new JButton("Remove Selected");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        
        // Adding components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(patientList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = genderField.getText();
                String diagnosis = diagnosisField.getText();
                if (!name.isEmpty() && !age.isEmpty() && !gender.isEmpty() && !diagnosis.isEmpty()) {
                    Patient patient = new Patient(name, age, gender, diagnosis);
                    patients.add(patient);
                    listModel.addElement(patient.toString());
                    nameField.setText("");
                    ageField.setText("");
                    genderField.setText("");
                    diagnosisField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = patientList.getSelectedIndex();
                if (selectedIndex != -1) {
                    patients.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a patient to remove!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MedicalGUI().setVisible(true));
    }
}
