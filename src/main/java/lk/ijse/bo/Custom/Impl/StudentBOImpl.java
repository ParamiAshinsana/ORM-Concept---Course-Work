package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.dao.Custom.StudentDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_STUDENTS);

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean addStudents(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.add(new Student(dto.getStudentId(),dto.getStudentName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
    }

    @Override
    public boolean updateStudents(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudents(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewStudentsID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
