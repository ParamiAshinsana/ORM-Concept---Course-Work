package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.dao.Custom.StudentDAO;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> getAll() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Room");
        nativeQuery.addEntity(Room.class);
        List nRooms = nativeQuery.getResultList();
        transaction.commit();
        session.close();
        return nRooms;
    }

    @Override
    public boolean add(Room entity) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM room WHERE roomTypeId = :rId";
        NativeQuery<Room> nativeQuery = session.createNativeQuery(sql);
        nativeQuery.setParameter("rId",id);
        nativeQuery.executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void updateRoomsQuantity() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "UPDATE room SET qty = (qty - 1)";
        NativeQuery<Room> nativeQuery = session.createNativeQuery(sql);
        nativeQuery.executeUpdate();

        transaction.commit();
        session.close();
    }
}
