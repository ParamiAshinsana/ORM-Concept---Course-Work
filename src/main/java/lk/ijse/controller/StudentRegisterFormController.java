package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.Custom.UserBO;
import lk.ijse.dto.UserDTO;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentRegisterFormController implements Initializable {

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_USER);


    public PasswordField txtPassword;
    public PasswordField confirmTxtPassword;
    public JFXTextField txtUser;
    public JFXTextField txtEmail;
    public JFXTextField userIdTxt;
    public AnchorPane rootRegister;

    public void BtnRegisterOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        String uid = userIdTxt.getText();
        String uname = txtUser.getText();
        String usPassword = txtPassword.getText();
        String usEmail = txtEmail.getText();


        if (userBO.addUsers(new UserDTO(uid, uname,usPassword,usEmail))) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error!!").show();
        }
    }

    public void backOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"))));
        stage.setTitle("Register Form");
        stage.show();
        rootRegister.getScene().getWindow().hide();
    }

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateNextUserId();
    }
    private void generateNextUserId() throws ClassNotFoundException {
        try {
            String nextId = userBO.generateNewUsersID();
            userIdTxt.setText(nextId);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
