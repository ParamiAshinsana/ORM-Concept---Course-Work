package lk.ijse.bo;

import lk.ijse.bo.Custom.Impl.ReservationBOImpl;
import lk.ijse.bo.Custom.Impl.RoomBOImpl;
import lk.ijse.bo.Custom.Impl.StudentBOImpl;
import lk.ijse.bo.Custom.Impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }

    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        B_STUDENT , B_ROOM , B_RESERVATION , B_USER
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case  B_STUDENT:
                return new StudentBOImpl();
            case  B_ROOM:
                return new RoomBOImpl();
            case  B_RESERVATION:
                return new ReservationBOImpl();
            case  B_USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
