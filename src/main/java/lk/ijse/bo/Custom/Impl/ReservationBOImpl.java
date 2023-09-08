package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.ReservationBO;
import lk.ijse.bo.Custom.RoomBO;
import lk.ijse.dao.Custom.ReservationDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO{
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_RESERVATIONS);

    @Override
    public List<ReservationDTO> getAllReservations() throws SQLException, ClassNotFoundException, IOException {
        List<ReservationDTO> allreservations= new ArrayList<>();
        List<Reservation> all = reservationDAO.getAll();
        for (Reservation rs : all) {
            allreservations.add(new ReservationDTO(rs.getReservationId(),rs.getStudent(),rs.getRoom(),rs.getDate(),rs.getStatus()));
        }
        return allreservations;
    }

    @Override
    public boolean addReservations(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return reservationDAO.add(new Reservation(dto.getReservationId(),dto.getStudent(),dto.getRoom(),dto.getDate(),dto.getStatus()));
    }

    @Override
    public boolean updateReservations(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return reservationDAO.update(new Reservation(dto.getReservationId(),dto.getStudent(),dto.getRoom(),dto.getDate(),dto.getStatus()));
    }

    @Override
    public boolean deleteReservations(String id) throws SQLException, ClassNotFoundException, IOException {
        return reservationDAO.delete(id);
    }
}
