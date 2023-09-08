package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.Custom.ReservationBO;
import lk.ijse.bo.Custom.RoomBO;
import lk.ijse.dao.Custom.ReservationDAO;
import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.ReservationTM;
import lk.ijse.dto.tm.RoomTM;
import lk.ijse.dto.tm.StudentTM;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public TableView <ReservationTM>resvTbl;
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
        setCellValueFactory();
        getAll();

        ObservableList<String> statusBox = FXCollections.observableArrayList( "Paid","Not Paid");
        resStatusCBox.setItems(statusBox);
    }

    private void getAll() throws IOException {
        resvTbl.getItems().clear();
        try {
            List<ReservationDTO> allreservation = reservationBO.getAllReservations();

            for (ReservationDTO Rs : allreservation) {
                resvTbl.getItems().add(new ReservationTM(Rs.getReservationId(),Rs.getStudent().getStudentId(),Rs.getRoom().getRoomTypeId(),Rs.getDate(),Rs.getStatus()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory() {
        colResId.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        colRStId.setCellValueFactory(new PropertyValueFactory<>("sid"));
        colRRmId.setCellValueFactory(new PropertyValueFactory<>("rid"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
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

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        String reservationId = txtResvId.getText();
        String S_ID = String.valueOf(RstIdCBox.getValue());
        String R_ID = String.valueOf(RrmIdCBox.getValue());
        String date = String.valueOf(resDatePicker.getValue());
        String status = String.valueOf(resStatusCBox.getValue());

        roomDAO.updateRoomsQuantity();

        student.setStudentId(S_ID);
        room.setRoomTypeId(R_ID);

        if (reservationBO.addReservations(new ReservationDTO(reservationId, student, room, date, status))) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error!!").show();
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void RstIdCBoxOnAction(ActionEvent actionEvent) {

    }

    public void RrmIdCBoxOnAction(ActionEvent actionEvent) {

    }

    public void resvTblOnClicked(MouseEvent mouseEvent) {
        Integer index = resvTbl.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        RsID = colResId.getCellData(index).toString();
        RstIdCBox.setValue(colRStId.getCellData(index).toString());
        RrmIdCBox.setValue(colRRmId.getCellData(index).toString());
        resDatePicker.setValue(LocalDate.parse(colDate.getCellData(index).toString()));
        resStatusCBox.setValue(colStatus.getCellData(index).toString());
    }
}
