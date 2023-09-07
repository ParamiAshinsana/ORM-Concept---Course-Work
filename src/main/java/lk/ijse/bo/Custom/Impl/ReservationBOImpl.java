package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.ReservationBO;
import lk.ijse.bo.Custom.RoomBO;
import lk.ijse.dto.ReservationDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationBOImpl implements ReservationBO{
    @Override
    public List<ReservationDTO> getAllReservations() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean addReservations(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean updateReservations(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean deleteReservations(String id) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }
}
