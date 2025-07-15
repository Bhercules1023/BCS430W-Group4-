package com.example.myshiftapp_new;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateScheduleController {

    @FXML
    private ListView<String> scheduledUsers;

    @FXML
    private TextField firstName;

    @FXML
    private TextField enterPositionTitle;

    @FXML
    private TextField enterWeekOf;

    @FXML
    private TextField enterSunday;

    @FXML
    private TextField enterMonday;

    @FXML
    private TextField enterTuesday;

    @FXML
    private TextField enterWednesday;

    @FXML
    private TextField enterThursday;

    @FXML
    private TextField enterFriday;

    @FXML
    private TextField enterSaturday;

    @FXML
    private TextField enterUserTask;

    @FXML
    private Label messageLabel;

    private ObservableList<String> CurrentlyScheduledList = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        displayCurrentlyScheduled();
        scheduledUsers.setItems(CurrentlyScheduledList);
    }

    @FXML
    private void displayCurrentlyScheduled(){

        String currentlyScheduled = "SELECT (Firstname, Title) FROM Schedule";

        try (Connection connect = new DatabaseConnection().getConnection();
             PreparedStatement statement = connect.prepareStatement(currentlyScheduled)){

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String getName = resultSet.getString("Firstname");
                String positionTitle = resultSet.getString("Title");

                //Double Check on This Section Below!!
                CurrentlyScheduledList.add(getName);
                CurrentlyScheduledList.add(positionTitle);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCreateSchedule(){
        String firstname = firstName.getText();
        String title = enterPositionTitle.getText();
        String weekOf = enterWeekOf.getText();
        String sunday = enterSunday.getText();
        String monday = enterMonday.getText();
        String tuesday = enterTuesday.getText();
        String wednesday = enterWednesday.getText();
        String thursday = enterThursday.getText();
        String friday = enterFriday.getText();
        String saturday = enterSaturday.getText();
        String taskName = enterUserTask.getText();

        String scheduleUser = "INSERT INTO Schedule (Firstname, Title, WeekOf, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, TaskName)";

        try (Connection connect = new DatabaseConnection().getConnection();
             PreparedStatement statement = connect.prepareStatement(scheduleUser)){

            statement.setString(1, firstname);
            statement.setString(2, title);
            statement.setString(3, weekOf);
            statement.setString(4, sunday);
            statement.setString(5, monday);
            statement.setString(6, tuesday);
            statement.setString(7, wednesday);
            statement.setString(8, thursday);
            statement.setString(9, friday);
            statement.setString(10, saturday);
            statement.setString(11, taskName);

            int update = statement.executeUpdate();

            if (update > 0){
                messageLabel.setText("User Was Successfully Added To The Schedule!");
            }
            else{
                messageLabel.setText("Failed To Add User To The Schedule!");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteSchedule(){

    }


}
