package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public ArrayList<StudentDTO> getAllCustomers()throws SQLException, ClassNotFoundException;

    public boolean addCustomers(StudentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomers(StudentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteCustomers(String id) throws SQLException, ClassNotFoundException;

    public String generateNewCustomersID() throws SQLException, ClassNotFoundException;
}
