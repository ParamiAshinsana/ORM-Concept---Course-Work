package lk.ijse.bo.Custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RoomBO extends SuperBO {
    public List<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException, IOException;

    public boolean addRooms(RoomDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean deleteRooms(String id) throws SQLException, ClassNotFoundException, IOException;
}
