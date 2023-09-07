package lk.ijse.dto;

import lk.ijse.entity.Room;
import lk.ijse.entity.Student;

public class ReservationDTO {
    private String reservationId;
    private Student student;
    private Room room;
    private String date;
    private String status;


    public ReservationDTO() {
    }

    public ReservationDTO(String reservationId, Student student, Room room, String date, String status) {
        this.reservationId = reservationId;
        this.student = student;
        this.room = room;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
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
