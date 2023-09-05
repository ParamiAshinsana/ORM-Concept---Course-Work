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
import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.StudentTM;
import lk.ijse.entity.Student;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentsFormController implements Initializable {
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_STUDENT);
    String stId;

    public Button btnSave;
    public Button btnUpdate;
    public Button btnClear;
    public Button btnDelete;

    public AnchorPane rootStudent;

    public JFXTextField txtFieldStudentId;
    public JFXTextField txtFieldStudentName;
    public ComboBox CBoxgender;
    public JFXTextField txtFieldAddress;
    public JFXTextField txtContact;
    public DatePicker datePickerDob;

    public TableView <StudentTM> studentTbl;
    public TableColumn <? , ?> colId;
    public TableColumn <? , ?> colName;
    public TableColumn <? , ?> colAddress;
    public TableColumn <? , ?> colContact;
    public TableColumn <? , ?> colDob;
    public TableColumn <? , ?> colGender;

    public ObservableList<StudentTM> observableList;

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();

        ObservableList<String> genderBox = FXCollections.observableArrayList( "Male","Female");
        CBoxgender.setItems(genderBox);
    }

    @SneakyThrows
    private void getAll() {
        studentTbl.getItems().clear();
        try {
            List<StudentDTO> allstudents = studentBO.getAllStudents();

            for (StudentDTO s : allstudents) {
                studentTbl.getItems().add(new StudentTM(s.getStudentId(),s.getStudentName(),s.getAddress(),s.getContact(),s.getDob(),s.getGender()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException{
        String studentId = txtFieldStudentId.getText();
        String studentName = txtFieldStudentName.getText();
        String address = txtFieldAddress.getText();
        String contact = txtContact.getText();
        String dob = String.valueOf(datePickerDob.getValue());
        String gender = String.valueOf(CBoxgender.getValue());

        try {
            studentBO.addStudents(new StudentDTO(studentId,studentName,address,contact,dob,gender));
            new Alert(Alert.AlertType.CONFIRMATION, "Student Saved !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }

        getAll();
        txtFieldStudentId.setText("");
        txtFieldStudentName.setText("");
        txtFieldAddress.setText("");
        txtContact.setText("");
        datePickerDob.setValue(null);
        CBoxgender.setValue("");
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String studentName = txtFieldStudentName.getText();
        String address = txtFieldAddress.getText();
        String contact = txtContact.getText();
        String dob = String.valueOf(datePickerDob.getValue());
        String gender = String.valueOf(CBoxgender.getValue());

        try {
            studentBO.updateStudents(new StudentDTO(stId,studentName,address,contact,dob,gender));
            new Alert(Alert.AlertType.CONFIRMATION, "Student Updated !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }
        txtFieldStudentId.setText("");
        txtFieldStudentName.setText("");
        txtFieldAddress.setText("");
        txtContact.setText("");
        datePickerDob.setValue(null);
        CBoxgender.setValue("");
        getAll();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtFieldStudentId.setText("");
        txtFieldStudentName.setText("");
        txtFieldAddress.setText("");
        txtContact.setText("");
        datePickerDob.setValue(null);
        CBoxgender.setValue("");
    }

    public void studentTableonclicked(MouseEvent mouseEvent) {
        Integer index = studentTbl.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
//        System.out.println(">>>>> "+index);

        stId = colId.getCellData(index).toString();
        txtFieldStudentId.setText(colId.getCellData(index).toString());
        txtFieldStudentName.setText(colName.getCellData(index).toString());
        txtFieldAddress.setText(colAddress.getCellData(index).toString());
        txtContact.setText(colContact.getCellData(index).toString());
        datePickerDob.setValue(LocalDate.parse(colDob.getCellData(index).toString()));
        CBoxgender.setValue(colGender.getCellData(index).toString());
    }
}
