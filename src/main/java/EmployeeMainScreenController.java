package com.example.myshiftapp_new;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeMainScreenController {
    @FXML
    private Button timeDisplay;

    @FXML
    private Button announcements;

    @FXML
    private Button account;

    @FXML
    private Button timeSheet;

    @FXML
    private Button punchInOut;

    @FXML
    private Button benefits;

    @FXML
    private Button notes;

    @FXML
    private Button logOut;

    @FXML
    private Label usernameLabel;

    @FXML
    private void initialize(){
        User currentUser = CurrentUser.getInstance().getLoggedInUser();
        usernameLabel.setText(currentUser.getUsername() + "!");
    }

    @FXML
    private void handleTimeDisplay() throws IOException{
        Stage stage = (Stage) timeDisplay.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "TimeDisplay.fxml");
    }

    @FXML
    private void handleAnnouncements() throws IOException{
        Stage stage = (Stage) announcements.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "Announcements.fxml");
    }

    @FXML
    private void handleAccount() throws IOException{
        Stage stage = (Stage) account.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "Account.fxml");
    }

    @FXML
    private void handleTimeSheetChart() throws IOException{
        Stage stage = (Stage) timeSheet.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "TimeSheetChart.fxml");
    }

    @FXML
    private void handlePunchInOut() throws IOException{
        Stage stage = (Stage) punchInOut.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "PunchInOut.fxml");
    }

    @FXML
    private void handleBenefits() throws IOException{
        Stage stage = (Stage) benefits.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "Benefits.fxml");
    }

    @FXML
    private void handleEmployeeNotes() throws IOException{
        Stage stage = (Stage) notes.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "EmployeeNotes.fxml");
    }

    @FXML
    private void handleLogOut() throws IOException{
        CurrentUser.getInstance().setLoggedInUser(null);
        Stage stage = (Stage) logOut.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "LoginScreen.fxml");
    }

}
