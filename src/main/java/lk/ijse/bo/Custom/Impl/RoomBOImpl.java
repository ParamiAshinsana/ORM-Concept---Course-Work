package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.RoomBO;
import lk.ijse.bo.Custom.StudentBO;
import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.dao.Custom.StudentDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.D_ROOMS);

    @Override
    public List<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean addRooms(RoomDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.add(new Room(dto.getRoomTypeId(),dto.getType(),dto.getKeyMoney(),dto.getQty()));
    }

    @Override
    public boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean deleteRooms(String id) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }
}
