package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.Custom.RoomBO;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationsFormController implements Initializable {
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_ROOM);
    String rmId;

    public AnchorPane rootReservation;
    public JFXTextField txtResvId;
    public ComboBox RstIdCBox;
    public ComboBox RrmIdCBox;
    public DatePicker resDatePicker;
    public ComboBox resStatusCBox;

    public Button btnSave;
    public Button btnUpdate;
    public Button btnClear;
    public Button btnDelete;

    public TableView resvTbl;
    public TableColumn <? , ?>colResId;
    public TableColumn <? , ?>colRStId;
    public TableColumn <? , ?>colRRmId;
    public TableColumn <? , ?>colDate;
    public TableColumn <? , ?>colStatus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void RstIdCBoxOnAction(ActionEvent actionEvent) {

    }

    public void RrmIdCBoxOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

    }

    public void resvTblOnClicked(MouseEvent mouseEvent) {

    }
}
