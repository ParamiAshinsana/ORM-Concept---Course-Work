package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.ReservationDAO;
import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.entity.Reservation;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

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
    public List<String> uploadStID() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT studentId FROM student");
        List<String> stdnId = nativeQuery.getResultList();
        transaction.commit();
        session.close();
        return stdnId;
    }

    @Override
    public List<String> uploadRmID() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT roomTypeId FROM room");
        List<String> rmmId = nativeQuery.getResultList();
        transaction.commit();
        session.close();
        return rmmId;
    }
}
