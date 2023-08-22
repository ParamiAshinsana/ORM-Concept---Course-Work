package lk.ijse.bo;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }

    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        B_STUDENT
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case  B_STUDENT:
                return new StudentBOImpl();
            default:
                return null;
        }
    }
}
