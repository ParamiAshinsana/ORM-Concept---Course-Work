package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomBOImpl implements StudentBO {
    @Override
    public List<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean addStudents(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean updateStudents(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean deleteStudents(String id) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String generateNewStudentsID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
