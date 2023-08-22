package lk.ijse.bo.Custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public ArrayList<StudentDTO> getAllStudents()throws SQLException, ClassNotFoundException;

    public boolean addStudents(StudentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateStudents(StudentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteStudents(String id) throws SQLException, ClassNotFoundException;

    public String generateNewStudentsID() throws SQLException, ClassNotFoundException;
}
