package lk.ijse.dao;

import lk.ijse.dao.Custom.Impl.ReservationDAOImpl;
import lk.ijse.dao.Custom.Impl.RoomDAOImpl;
import lk.ijse.dao.Custom.Impl.StudentDAOImpl;
import lk.ijse.dao.Custom.Impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        D_STUDENTS , D_ROOMS , D_RESERVATIONS , D_USERS
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case D_STUDENTS:
                return new StudentDAOImpl();
            case D_ROOMS:
                return new RoomDAOImpl();
            case D_RESERVATIONS:
                return new ReservationDAOImpl();
            case D_USERS:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
