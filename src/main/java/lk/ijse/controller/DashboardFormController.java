package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane rootDashboard;
    public JFXButton btnReservations;
    public JFXButton btnHome;
    public JFXButton btnStudents;
    public JFXButton btnRooms;
    public JFXButton btnPayments;
    public StackPane controllarea;

    public void btnReservationsOnAction(ActionEvent actionEvent) throws IOException {
        controllarea.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/reservations_form.fxml"));
        controllarea.getChildren().removeAll();
        controllarea.getChildren().setAll(fxml);
    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        controllarea.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/home_form.fxml"));
        controllarea.getChildren().removeAll();
        controllarea.getChildren().setAll(fxml);
    }

    public void btnStudentsOnAction(ActionEvent actionEvent) throws IOException {
        controllarea.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/students_form.fxml"));
        controllarea.getChildren().removeAll();
        controllarea.getChildren().setAll(fxml);
    }

    public void btnRoomsOnAction(ActionEvent actionEvent) throws IOException {
        controllarea.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/rooms_form.fxml"));
        controllarea.getChildren().removeAll();
        controllarea.getChildren().setAll(fxml);
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
