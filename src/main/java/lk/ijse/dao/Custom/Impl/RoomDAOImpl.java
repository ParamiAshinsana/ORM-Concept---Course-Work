package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.dao.Custom.StudentDAO;
import lk.ijse.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> getAll() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean add(Room entity) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean update(Room entity) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
