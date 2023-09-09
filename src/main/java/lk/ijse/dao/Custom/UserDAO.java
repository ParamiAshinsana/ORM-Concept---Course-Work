package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

import java.io.IOException;

public interface UserDAO extends CrudDAO<User> {
    boolean checkPassword(String username, String password) throws IOException;

}
