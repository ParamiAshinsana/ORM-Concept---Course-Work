package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentRegisterFormController {
    public PasswordField txtPassword;
    public JFXTextField txtUser;
    public AnchorPane rootRegister;

    public void BtnRegisterOnAction(ActionEvent actionEvent) {

    }

    public void backOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"))));
        stage.setTitle("Register Form");
        stage.show();
        rootRegister.getScene().getWindow().hide();
    }
}
