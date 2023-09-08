package lk.ijse.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HomeFormController {
    public AnchorPane rootHome;
    public JFXTextField txtUsName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtpassword;

    public Button btnSave;
    public Button btnUpdate;
    public Button btnClear;
    public Button btnDelete;

    public TableView userTbl;
    public TableColumn colUsName;
    public TableColumn colPassword;
    public TableColumn colEmail;


    public void btnSaveOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void userTblOnClicked(MouseEvent mouseEvent) {

    }
}
