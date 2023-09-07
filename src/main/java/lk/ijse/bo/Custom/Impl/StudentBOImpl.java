package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.dao.Custom.StudentDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_STUDENTS);

    @Override
    public List<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException, IOException {
        List<StudentDTO> allstudents= new ArrayList<>();
        List<Student> all = studentDAO.getAll();
        for (Student s : all) {
            allstudents.add(new StudentDTO(s.getStudentId(),s.getStudentName(),s.getAddress(),s.getContact(),s.getDob(),s.getGender(),s.getReservation()));
        }
        return allstudents;
    }

    @Override
    public boolean addStudents(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.add(new Student(dto.getStudentId(),dto.getStudentName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender(), new ArrayList<Reservation>()));
    }

    @Override
    public boolean updateStudents(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.update(new Student(dto.getStudentId(),dto.getStudentName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender(), new ArrayList<Reservation>()));
    }

    @Override
    public boolean deleteStudents(String id) throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.delete(id);
    }

    @Override
    public String generateNewStudentsID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
