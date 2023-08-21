package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentFormController {
    public AnchorPane rootDashboard;
    public JFXButton btnReservations;
    public JFXButton btnHome;
    public JFXButton btnStudents;
    public JFXButton btnRooms;
    public JFXButton btnPayments;
    public StackPane controllarea;

    public void btnReservationsOnAction(ActionEvent actionEvent) {

    }

    public void btnHomeOnAction(ActionEvent actionEvent) {

    }

    public void btnStudentsOnAction(ActionEvent actionEvent) {

    }

    public void btnRoomsOnAction(ActionEvent actionEvent) {

    }

    public void btnPaymentsOnAction(ActionEvent actionEvent) {

    }

    public void logoutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        rootDashboard.getScene().getWindow().hide();
    }
}
