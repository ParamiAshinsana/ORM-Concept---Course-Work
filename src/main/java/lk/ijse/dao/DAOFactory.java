package lk.ijse.dao;

import lk.ijse.dao.Custom.Impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        D_STUDENTS , D_ROOMS
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case D_STUDENTS:
                return new StudentDAOImpl();
            case D_ROOMS:
                return new RoomDAOImpl();
            default:
                return null;
        }
    }
}
