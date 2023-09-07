package lk.ijse.dto;

import lk.ijse.entity.Room;
import lk.ijse.entity.Student;

public class ReservationDTO {
    private String reservationId;
    private String date;
    private String status;
    private Student student;
    private Room room;

    public ReservationDTO() {
    }

    public ReservationDTO(String reservationId, String date, String status, Student student, Room room) {
        this.reservationId = reservationId;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "reservationId='" + reservationId + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                '}';
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
}