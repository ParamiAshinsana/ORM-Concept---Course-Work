package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.ReservationDAO;
import lk.ijse.dao.Custom.RoomDAO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;
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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Reservation");
        nativeQuery.addEntity(Reservation.class);
        List<Reservation> nReservations = nativeQuery.getResultList();
        transaction.commit();
        session.close();
        return nReservations;
    }

    @Override
    public boolean add(Reservation entity) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM reservation WHERE reservationId = :rSId";
        NativeQuery<Reservation> nativeQuery = session.createNativeQuery(sql);
        nativeQuery.setParameter("rSId",id);
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
