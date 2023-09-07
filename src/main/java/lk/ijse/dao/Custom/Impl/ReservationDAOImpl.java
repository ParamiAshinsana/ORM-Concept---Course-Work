package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.ReservationDAO;
import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public List<Reservation> getAll() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean add(Reservation entity) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException, IOException {
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

    @Override
    public List<String> loadStudentID() {
        return null;
    }

    @Override
    public List<String> loadRoomID() {
        return null;
    }
}
