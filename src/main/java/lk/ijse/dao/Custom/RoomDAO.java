package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;

import java.io.IOException;

public interface RoomDAO extends CrudDAO<Room> {
    void updateRoomsQuantity() throws IOException;
}
