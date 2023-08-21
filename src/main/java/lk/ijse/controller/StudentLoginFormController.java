package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentLoginFormController {
    public PasswordField txtPassword;
    public JFXComboBox cBoxUserProfile;
    public AnchorPane rootLogin;

    public void BtnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))));
        stage.setTitle("Student Form");
        stage.show();
        rootLogin.getScene().getWindow().hide();
    }

    public void RegisterOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_register_form.fxml"))));
        stage.setTitle("Register Form");
        stage.show();
        rootLogin.getScene().getWindow().hide();
    }
}
