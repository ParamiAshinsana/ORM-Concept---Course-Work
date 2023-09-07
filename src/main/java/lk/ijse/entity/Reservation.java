package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
    @Id
    private String reservationId;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Room room;
    private String date;
    private String status;



    public Reservation() {
    }

    public Reservation(String reservationId, Student student, Room room, String date, String status) {
        this.reservationId = reservationId;
        this.student = student;
        this.room = room;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", student=" + student +
                ", room=" + room +
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
