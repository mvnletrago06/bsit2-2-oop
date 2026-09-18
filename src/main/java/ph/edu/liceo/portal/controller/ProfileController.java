package ph.edu.liceo.portal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ph.edu.liceo.portal.MainApp;
import ph.edu.liceo.portal.model.Student;

public class ProfileController {

    @FXML private Label initialsLabel;
    @FXML private Label nameLabel;
    @FXML private Label studentNoLabel;
    @FXML private Label courseLabel;
    @FXML private Label emailLabel;

    public void setStudent(Student student) {
        try {
            if (student == null) return;

            String[] parts = student.getFullName().trim().split("\\s+");
            String initials = "";
            if (parts.length > 0 && !parts[0].isEmpty()) {
                initials += parts[0].charAt(0);
            }
            if (parts.length > 1) {
                initials += parts[parts.length - 1].charAt(0);
            }

            initialsLabel.setText(initials.toUpperCase());
            nameLabel.setText(student.getFullName());
            studentNoLabel.setText(student.getStudentNo());
            courseLabel.setText(student.getCourse() + " - Year " + student.getYearLevel());
            emailLabel.setText(student.getEmail());
        } catch (Exception e) {
            System.err.println("Failed to set profile data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout() {
        try {
            MainApp.showLogin();
        } catch (Exception e) {
            System.err.println("Failed to log out: " + e.getMessage());
            e.printStackTrace();
        }
    }
}