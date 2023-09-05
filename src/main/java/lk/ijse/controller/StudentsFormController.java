package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;

public class StudentsFormController {
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.B_STUDENT);


    public AnchorPane rootStudent;

    public JFXTextField txtFieldStudentId;
    public JFXTextField txtFieldStudentName;
    public ComboBox CBoxgender;
    public JFXTextField txtFieldAddress;
    public JFXTextField txtContact;
    public DatePicker dob;

    public TableView studentTbl;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colGender;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDob;

    public Button btnSave;
    public DatePicker datePickerDob;

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException{
        String studentId = txtFieldStudentId.getText();
        String studentName = txtFieldStudentName.getText();
        String address = txtFieldAddress.getText();
        String contact = txtContact.getText();
        String dob = String.valueOf(datePickerDob.getValue());
        String gender = String.valueOf(CBoxgender.getValue());

        System.out.println(txtFieldStudentId);
        System.out.println("HIII");

        try {
            studentBO.addStudents(new StudentDTO(studentId,studentName,address,contact,dob,gender));
            new Alert(Alert.AlertType.CONFIRMATION, "Student Saved !").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }
    }

    public void studentTableonclicked(MouseEvent mouseEvent) {

    }
}
