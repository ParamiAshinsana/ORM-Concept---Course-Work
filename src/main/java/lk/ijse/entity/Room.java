package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Room {
    @Id
    private String roomTypeId;
    private String type;
    private Double keyMoney;
    private int qty;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservation;

    public Room() {
    }

    public Room(String roomTypeId, String type, Double keyMoney, int qty) {
        this.roomTypeId = roomTypeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public Room(String roomTypeId, String type, Double keyMoney, int qty, List<Reservation> reservation) {
        this.roomTypeId = roomTypeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomTypeId='" + roomTypeId + '\'' +
                ", type='" + type + '\'' +
                ", keyMoney=" + keyMoney +
                ", qty=" + qty +
                ", reservation=" + reservation +
                '}';
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(Double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}
