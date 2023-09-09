package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dao.Custom.UserDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.StudentDTO;

import java.io.IOException;

public class StudentLoginFormController {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_USERS);

    public PasswordField txtPassword;
    public JFXComboBox cBoxUserProfile;
    public AnchorPane rootLogin;
    public JFXTextField txtUserProfile;

    public void BtnLoginOnAction(ActionEvent actionEvent) throws IOException {
//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))));
//        stage.setTitle("Student Form");
//        stage.show();
//        rootLogin.getScene().getWindow().hide();



//        String username = txtUsername.getText();
//        String password = txtPassword2.getText();
//
//
//        try {
//            userDAO.checkPassword(username,password);
//
//            Stage stage = new Stage();
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))));
//            stage.setTitle("Student Form");
//            stage.show();
//            rootLogin.getScene().getWindow().hide();
//
//            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Login !").show();
//        }catch (Exception e){
//            new Alert(Alert.AlertType.ERROR,"Please Check Username and password !!").show();
//        }


        String usName = txtUserProfile.getText();
        String usPassword = txtPassword.getText();

        if (userDAO.checkPassword(usName,usPassword)){
            Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            rootLogin.getScene().getWindow().hide();
        }else {
            new Alert(Alert.AlertType.ERROR,"Please Check!!").show();
        }

        txtUserProfile.clear();
        txtPassword.clear();
    }

    public void RegisterOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_register_form.fxml"))));
        stage.setTitle("Register Form");
        stage.show();
        rootLogin.getScene().getWindow().hide();
    }
}
