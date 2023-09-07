package lk.ijse.dto.tm;

public class ReservationTM {
    private String sid;
    private String rid;
    private String reservationId;
    private String date;
    private String status;

    public ReservationTM() {
    }

    public ReservationTM(String sid, String rid, String reservationId, String date, String status) {
        this.sid = sid;
        this.rid = rid;
        this.reservationId = reservationId;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationTM{" +
                "sid='" + sid + '\'' +
                ", rid='" + rid + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
