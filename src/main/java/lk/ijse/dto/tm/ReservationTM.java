package lk.ijse.dto.tm;

public class ReservationTM {
    private String reservationId;
    private String sid;
    private String rid;
    private String date;
    private String status;

    public ReservationTM() {
    }

    public ReservationTM(String reservationId, String sid, String rid, String date, String status) {
        this.reservationId = reservationId;
        this.sid = sid;
        this.rid = rid;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationTM{" +
                "reservationId='" + reservationId + '\'' +
                ", sid='" + sid + '\'' +
                ", rid='" + rid + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
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
