package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;

import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation> {
    List<String> loadStudentID();
    List<String> loadRoomID();
}
