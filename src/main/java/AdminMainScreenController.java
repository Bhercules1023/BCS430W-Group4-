package com.example.myshiftapp_new;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMainScreenController {
    @FXML
    private Button adminTimeDisplay;

    @FXML
    private Button adminAnnouncements;

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
    private void handleAdminTimeDisplay() throws IOException {
        Stage stage = (Stage) adminTimeDisplay.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "AdminTimeDisplay.fxml");
    }

    @FXML
    private void handleCreateAnnouncements() throws IOException{
        Stage stage = (Stage) adminAnnouncements.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "CreateAnnouncement.fxml");
    }

    @FXML
    private void handleManageAccounts() throws IOException{
        Stage stage = (Stage) account.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "ManageAccounts.fxml");
    }

    @FXML
    private void handleTimeSheetChart() throws IOException{
        Stage stage = (Stage) timeSheet.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "TimeSheetChart.fxml");
    }

    @FXML
    private void handleAdminPunchInOut() throws IOException{
        Stage stage = (Stage) punchInOut.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "AdminPunchInOut.fxml");
    }

    @FXML
    private void handleBenefits() throws IOException{
        Stage stage = (Stage) benefits.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "Benefits.fxml");
    }

    @FXML
    private void handleAdminNotes() throws IOException{
        Stage stage = (Stage) notes.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "AdminNotes.fxml");
    }

    @FXML
    private void handleLogOut() throws IOException{
        CurrentUser.getInstance().setLoggedInUser(null);
        Stage stage = (Stage) logOut.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "LoginScreen.fxml");
    }

}
