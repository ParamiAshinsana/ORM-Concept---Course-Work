package lk.ijse.entity;

public class User {
    private String usId;
    private String usName;
    private String usPassword;
    private String usEmail;

    public User() {
    }

    public User(String usId, String usName, String usPassword, String usEmail) {
        this.usId = usId;
        this.usName = usName;
        this.usPassword = usPassword;
        this.usEmail = usEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "usId='" + usId + '\'' +
                ", usName='" + usName + '\'' +
                ", usPassword='" + usPassword + '\'' +
                ", usEmail='" + usEmail + '\'' +
                '}';
    }

    public String getUsId() {
        return usId;
    }

    public void setUsId(String usId) {
        this.usId = usId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }
}
