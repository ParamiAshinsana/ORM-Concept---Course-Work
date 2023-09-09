package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.UserBO;
import lk.ijse.dao.Custom.StudentDAO;
import lk.ijse.dao.Custom.UserDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_USERS);


    @Override
    public List<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean addUsers(UserDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return userDAO.add(new User(dto.getUsId(),dto.getUsName(),dto.getUsPassword(),dto.getUsEmail()));
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
    public String generateNewUsersID() throws SQLException, ClassNotFoundException, IOException {
        return userDAO.generateNewId();
    }
}
