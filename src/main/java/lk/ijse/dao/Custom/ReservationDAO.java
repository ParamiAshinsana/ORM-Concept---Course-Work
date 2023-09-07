package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;

import java.io.IOException;
import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation> {
    List<String> uploadStID() throws IOException;
    List<String> uploadRmID() throws IOException;
}
