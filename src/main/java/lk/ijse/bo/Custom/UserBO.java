package lk.ijse.bo.Custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    public List<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException, IOException;

    public boolean addUsers(UserDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean updateUsers(UserDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean deleteUsers(UserDTO id) throws SQLException, ClassNotFoundException, IOException;

    public String generateNewUsersID() throws SQLException, ClassNotFoundException;
}
