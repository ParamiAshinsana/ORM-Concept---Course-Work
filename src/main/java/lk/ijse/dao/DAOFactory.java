package lk.ijse.dao;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        D_STUDENTS
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case D_STUDENTS:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }
}
