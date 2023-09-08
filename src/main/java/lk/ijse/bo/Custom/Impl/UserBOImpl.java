package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.UserBO;
import lk.ijse.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserBOImpl implements UserBO {
    @Override
    public List<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean addUsers(UserDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean updateUsers(UserDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean deleteUsers(UserDTO id) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String generateNewUsersID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
