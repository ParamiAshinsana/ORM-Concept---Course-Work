package lk.ijse.bo.Custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ReservationBO extends SuperBO {
    public List<ReservationDTO> getAllReservations() throws SQLException, ClassNotFoundException, IOException;

    public boolean addReservations(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean updateReservations(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean deleteReservations(String id) throws SQLException, ClassNotFoundException, IOException;
}
