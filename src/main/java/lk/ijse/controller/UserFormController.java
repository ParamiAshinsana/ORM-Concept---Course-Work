package lk.ijse.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.bo.Custom.UserBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_USER);


    public AnchorPane rootHome;
//    public JFXTextField txtUserID;
    public JFXTextField txtUsName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtpassword;
    public JFXTextField userIdTxt;

    public Button btnSave;
    public Button btnUpdate;
    public Button btnClear;
    public Button btnDelete;

    public TableView userTbl;
    public TableColumn colUsID;
    public TableColumn colUsName;
    public TableColumn colUsPassword;
    public TableColumn colUsEmail;
//    public TableColumn colUsName;
//    public TableColumn colPassword;
//    public TableColumn colEmail;



    public void btnSaveOnAction(ActionEvent actionEvent) {
        String usId = userIdTxt.getText();
        String usName = txtUsName.getText();
        String usPassword = txtpassword.getText();
        String usEmail = txtEmail.getText();

        try {
            userBO.addUsers(new UserDTO(usId,usName,usPassword,usEmail));
            new Alert(Alert.AlertType.CONFIRMATION, "User Saved !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }


        userIdTxt.setText("");
        txtUsName.setText("");
        txtpassword.setText("");
        txtEmail.setText("");
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void userTblOnClicked(MouseEvent mouseEvent) {

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
