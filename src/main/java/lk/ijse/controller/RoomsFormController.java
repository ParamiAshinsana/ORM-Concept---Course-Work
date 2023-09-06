package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.tm.StudentTM;

public class RoomsFormController {
    public AnchorPane rootRoom;
    public ComboBox typeCBox;
    public ComboBox roomIdCBox;
    public JFXTextField txtKeymoney;
    public JFXTextField roomQty;

    public Button btnSave;
    public Button btnUpdate;
    public Button btnClear;
    public Button btnDelete;

    public TableView roomTbl;
    public TableColumn <? , ?>colRId;
    public TableColumn <? , ?> colType;
    public TableColumn <? , ?> colKeymoney;
    public TableColumn <? , ?> colQty;

    public void btnSaveOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void roomTableonclicked(MouseEvent mouseEvent) {

    }
}
