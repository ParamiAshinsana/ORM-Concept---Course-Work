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
import lk.ijse.bo.Custom.RoomBO;
import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.RoomTM;
import lk.ijse.dto.tm.StudentTM;
import lombok.SneakyThrows;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RoomsFormController implements Initializable {
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_ROOM);
    String rmId;
    public AnchorPane rootRoom;
    public ComboBox typeCBox;
    public ComboBox roomIdCBox;
    public JFXTextField txtKeymoney;
    public JFXTextField roomQty;

    public Button btnSave;
    public Button btnUpdate;
    public Button btnClear;
    public Button btnDelete;

    public TableView <RoomTM>roomTbl;
    public TableColumn <? , ?>colRId;
    public TableColumn <? , ?> colType;
    public TableColumn <? , ?> colKeymoney;
    public TableColumn <? , ?> colQty;

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();

        ObservableList<String> roomIdBox = FXCollections.observableArrayList( "RM-1324","RM-5467","RM-7896","RM-0093");
        roomIdCBox.setItems(roomIdBox);

        ObservableList<String> roomTypeBox = FXCollections.observableArrayList( "Non-AC","Non-AC / Food","AC","AC / Food");
        typeCBox.setItems(roomTypeBox);
    }

    @SneakyThrows
    private void getAll() {
        roomTbl.getItems().clear();
        try {
            List<RoomDTO> allrooms = roomBO.getAllRooms();

            for (RoomDTO r : allrooms) {
                roomTbl.getItems().add(new RoomTM(r.getRoomTypeId(),r.getType(),r.getKeyMoney(),r.getQty()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory() {
        colRId.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeymoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String roomTypeId = String.valueOf(roomIdCBox.getValue());
        String type = String.valueOf(typeCBox.getValue());
        double keyMoney = Double.parseDouble(txtKeymoney.getText());
        int qty = Integer.parseInt(roomQty.getText());

        try {
            roomBO.addRooms(new RoomDTO(roomTypeId,type,keyMoney,qty));
            new Alert(Alert.AlertType.CONFIRMATION, "Room Saved !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }

        getAll();
        roomIdCBox.setValue("");
        typeCBox.setValue("");
        txtKeymoney.setText("");
        roomQty.setText("");
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String type = String.valueOf(typeCBox.getValue());
        double keyMoney = Double.parseDouble(txtKeymoney.getText());
        int qty = Integer.parseInt(roomQty.getText());

        try {
            roomBO.updateRooms(new RoomDTO(rmId,type,keyMoney,qty));
            new Alert(Alert.AlertType.CONFIRMATION, "Room Updated !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }
        roomQty.setText("");
        txtKeymoney.setText("");
        roomIdCBox.setValue("");
        typeCBox.setValue("");
        getAll();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void roomTableonclicked(MouseEvent mouseEvent) {

    }
}
