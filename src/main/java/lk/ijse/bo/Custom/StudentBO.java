package lk.ijse.bo.Custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException, IOException;

    public boolean addStudents(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean updateStudents(StudentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteStudents(String id) throws SQLException, ClassNotFoundException;

    public String generateNewStudentsID() throws SQLException, ClassNotFoundException;
}
