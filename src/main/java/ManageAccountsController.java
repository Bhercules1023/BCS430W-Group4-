package com.example.myshiftapp_new;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageAccountsController {

    @FXML
    private Button goBackAdmin;

    @FXML
    private Button manageEmpAccount;

    @FXML
    private Button manageAdminAccount;

    @FXML
    private void handleAdminAccount() throws IOException {
        Stage stage = (Stage) manageAdminAccount.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "AdminAccount.fxml");
    }

    @FXML
    private void handleEmployeeAccount() throws IOException {
        Stage stage = (Stage) manageEmpAccount.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "ManageEmpAccount.fxml");
    }

    @FXML
    private void handleAdminGoBack() throws IOException {
        Stage stage = (Stage) goBackAdmin.getScene().getWindow();
        MyShiftApplication.switchScene(stage, "AdminMainScreen.fxml");
    }
}
