package lk.ijse.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.Custom.UserBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.dto.tm.UserTM;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_USER);
    String ussId;

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

    public TableView <UserTM> userTbl;
    public TableColumn <? , ?> colUsID;
    public TableColumn <? , ?> colUsName;
    public TableColumn <? , ?> colUsPassword;
    public TableColumn <? , ?> colUsEmail;
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
        String usName = txtUsName.getText();
        String usPassword = txtpassword.getText();
        String usEmail = txtEmail.getText();

        try {
            userBO.updateUsers(new UserDTO(ussId,usName,usPassword,usEmail));
            new Alert(Alert.AlertType.CONFIRMATION, "User Updated !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }
        userIdTxt.setText("");
        txtUsName.setText("");
        txtpassword.setText("");
        txtEmail.setText("");
        getAll();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        userIdTxt.setText("");
        txtUsName.setText("");
        txtpassword.setText("");
        txtEmail.setText("");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            userBO.deleteUsers(ussId);
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }
    }

    public void userTblOnClicked(MouseEvent mouseEvent) {
        Integer index = userTbl.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
//      System.out.println(">>>>> "+index);

        ussId = colUsID.getCellData(index).toString();
        txtUsName.setText(colUsName.getCellData(index).toString());
        txtpassword.setText(colUsPassword.getCellData(index).toString());
        txtEmail.setText(colUsEmail.getCellData(index).toString());
    }

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateNextUserId();
        setCellValueFactory();
        getAll();
    }

    @SneakyThrows
    private void getAll() {
        userTbl.getItems().clear();
        try {
            List<UserDTO> allusers = userBO.getAllUsers();

            for (UserDTO u : allusers) {
                userTbl.getItems().add(new UserTM(u.getUsId(),u.getUsName(),u.getUsPassword(),u.getUsEmail()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory() {
        colUsID.setCellValueFactory(new PropertyValueFactory<>("usId"));
        colUsName.setCellValueFactory(new PropertyValueFactory<>("usName"));
        colUsPassword.setCellValueFactory(new PropertyValueFactory<>("usPassword"));
        colUsEmail.setCellValueFactory(new PropertyValueFactory<>("usEmail"));
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
