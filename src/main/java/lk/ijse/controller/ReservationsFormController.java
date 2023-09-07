package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.Custom.ReservationBO;
import lk.ijse.bo.Custom.RoomBO;
import lk.ijse.dao.Custom.ReservationDAO;
import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.tm.ReservationTM;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationsFormController implements Initializable {
    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_RESERVATION);
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_RESERVATIONS);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_ROOMS);
    String RsID;

    Student student = new Student();
    Room room = new Room();

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

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadStudentId();
        uploadRoomTypeId();
    }

    private void uploadStudentId() throws IOException {
        List<String> RSid = reservationDAO.uploadStID();
        ObservableList<String> rSObservableList = FXCollections.observableArrayList();

        for (String x : RSid){
            rSObservableList.add(x);
        }
        RstIdCBox.setItems(rSObservableList);
    }

    private void uploadRoomTypeId() throws IOException {
        List<String> RRid = reservationDAO.uploadRmID();
        ObservableList<String> rRObservableList = FXCollections.observableArrayList();

        for (String y : RRid){
            rRObservableList.add(y);
        }
        RrmIdCBox.setItems(rRObservableList);
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
